package src;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import com.opencsv.CSVReader;

public class DBWrite {

	FileInputStream fi;
	FileOutputStream fo;

	HSSFSheet s;
	HSSFWorkbook w;
	HSSFWorkbook wo;
	String DB_URL;
	String USER;
	String PASS;
	public static Connection con = null;
	public void testDataFile(String file) throws IOException {
		fi = new FileInputStream(file);

		w = new HSSFWorkbook(fi);
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		DBWrite update = new DBWrite();		
		Map<String, String> ht_mmt_hotelcodeMap = new HashMap<String, String>();
		//update.testDataFile("D:\\Connector\\HT_MMT_Hotel_Code_GVXX0003.xls");
		ht_mmt_hotelcodeMap=update.htmmtMapping("D:\\Connector\\HT_MMT_Hotel_Code_GVXX0003.csv");
		update.testDataFile("D:\\Connector\\GVXX0003.xls");
		Map<Integer, Map<Object, Object>> hoteldata =  update.hotelMapping("GVXX0003");
//		 update.testDataFile("D:\\Connector\\GVXX0003.xls");
//		 update.hotelMapping("GVXX0003");
//		update.testDataFile("D:\\Connector\\HT_MMT_Hotel_Code_GVXX0003.xls");
//		update.htmmtMapping("HT_MMT_Hotel_Code_GVXX0003");
		update.updateDb(hoteldata, ht_mmt_hotelcodeMap);
	}

	public Map<Integer, Map<Object, Object>> hotelMapping(String sheetname) {
		Map<Integer, Map<Object, Object>> hoteldata = new HashMap<Integer, Map<Object, Object>>();
		s = w.getSheet(sheetname);
		int rows = s.getPhysicalNumberOfRows();
		
		for (int i = 1; i < rows; i++) {
			try {
				Map<Object, Object> map = new HashMap<Object, Object>();
				HSSFRow r = s.getRow(0);
				HSSFRow row = s.getRow(i);
				for (int j = 0; j < row.getLastCellNum(); j++) {
					String str = null;
					try {
						
							row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
							str = row.getCell(j).getStringCellValue();	
						map.put(r.getCell(j).getStringCellValue(), str);
					} catch (Exception e) {
						System.out.println(i + " , " + j);
						e.printStackTrace();
					}
				}
				hoteldata.put(i, map);
			} catch (Exception e) {
				System.out.println(i);
				e.printStackTrace();
			}

		}
		//System.out.println(hoteldata);
		try {
			w.close();
			fi.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hoteldata;
	}

	public Map<String, String> htmmtMapping(String filename) throws IOException {
//		s = w.getSheet(sheetname);
//		int rows = s.getPhysicalNumberOfRows();
		Map<String, String> map = new HashMap<String, String>();
//		for (int i = 1; i < rows; i++) {
//			String str = null, str1 = null;
//			HSSFRow row = s.getRow(i);
//			row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
//			str = row.getCell(0).getStringCellValue();
//			row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
//			str1 = row.getCell(1).getStringCellValue();
//			str1 = str1.trim();
//			map.put(str, str1);
//		}
		String[] row = null;
		String csvFilename = "D:\\Connector\\HT_MMT_Hotel_Code_GVXX0003.csv";

		CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
		List content = csvReader.readAll();

		for (Object object : content) {
			row = (String[]) object;
		
			map.put(row[0], row[1]);
		}

		//System.out.println(map);
		return map;
	}
	
	public void updateDb(Map<Integer, Map<Object, Object>> hotelmapping,Map<String, String> htmmtmapping) throws ClassNotFoundException, IOException, SQLException
	{
		String hotel = null;
		Set<Integer> count = hotelmapping.keySet();
		List<String> updatedHotels = new ArrayList<String>();
		DbConnection();
		try{
			Map<Object,Object> map = new HashMap<Object, Object>();
		for(Integer i :count)
		{
			
			 map = hotelmapping.get(i);
			hotel = map.get("Hotel_Code").toString();
			if(!(updatedHotels.contains(hotel)))
			{
		
			if(htmmtmapping.containsKey(hotel))
			{
				 
				map.replace("Hotel_Code", hotel, htmmtmapping.get(hotel));
			}
			//System.out.println(map);
			String h = map.get("Hotel_Code").toString();
			String dmc = map.get("DMC_Code").toString();
			String dmc_hotel_code=map.get("DMCItemCode2").toString();
			String cc = map.get("Country_Code").toString();
			String city = map.get("City_Code").toString();
			
				chkConnection();
				Statement statement = con.createStatement();
				String query = "INSERT IGNORE INTO connector_new.hotel_code_master (Hotel_Code, dmc_Code, dmc_hotel_code, country_code,dmc_city_code,hotel_pah_status,status,last_updated,city_code) "
						+ "VALUES ('"+h+"','"+dmc+"','"+dmc_hotel_code+"','"+cc+"','"+city+"','0','1',now(),'"+city+"');";

				statement.executeUpdate(query);
				updatedHotels.add(hotel);
		}
		}
		con.close();		
		}
		catch(Exception e)
		{
			System.out.println(hotel);
			//e.printStackTrace();
		}
	}

	public void DbConnection() throws ClassNotFoundException, IOException, SQLException
	{
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		Class.forName(JDBC_DRIVER);
		//propfile = System.getProperty("user.dir");

		if (con == null) {
			setDbParm();
			con = DriverManager.getConnection(DB_URL, USER, PASS);
		}
	}

	public void chkConnection() throws SQLException, Exception {
		if (con == null || con.isClosed()) {
			DbConnection();
			con = DriverManager.getConnection(DB_URL, USER, PASS);
		}

	}

	private void setDbParm() throws IOException {
				
		DB_URL = "jdbc:mysql://172.16.47.102:3306/connector_new";
		USER = "sahils";
		PASS = "Sahil@5";

	}
		
}
