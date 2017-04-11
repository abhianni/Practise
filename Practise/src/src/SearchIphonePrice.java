package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchIphonePrice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
SearchIphonePrice result = new SearchIphonePrice();
result.sortIphone();
	}
	
	
	public void sortIphone()
	{
		int i=1;		
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		List<Flipkartiphone> list = new ArrayList<Flipkartiphone>();
		driver.get("https://www.flipkart.com/mobiles-accessories/mobiles/pr?otracker=categorytree&p%5B%5D=facets.brand%255B%255D%3DApple&p%5B%5D=facets.price_range.from%3D30000&p%5B%5D=facets.price_range.to%3DMax&p%5B%5D=facets.availability%255B%255D%3DExclude%2BOut%2Bof%2BStock&q=iphone6&sid=tyy%2F4io");
		//WebElement element = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div[2]/div/div[2]/div/div[3]/div/div"));
		String path = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[3]/div[1]/div";
		while(driver.findElements(By.xpath(path+"/div["+i+"]")).size()>0 )
		{
			Flipkartiphone phone = new Flipkartiphone();
			String url = driver.findElement(By.xpath(path+"/div["+i+"]/a")).getAttribute("href");
			String name = driver.findElement(By.xpath(path+"/div["+i+"]/a/div[2]/div[1]/div")).getText();
			String pr =driver.findElement(By.xpath(path+"/div["+i+"]/a/div[2]/div[2]/div[1]/div/div[1]")).getText();
			pr=pr.substring(1);
			String[] str = pr.split(",");
			pr=str[0]+str[1];
			Integer price = Integer.parseInt(pr);
			phone.setPrice(price);
			phone.setProductLink(url);
			phone.setProductName(name);
			list.add(phone);
			i=i+1;
		}
		
        
        Collections.sort( list, new Comperator1());
        for( Flipkartiphone entry:list){
            System.out.println(entry.getPrice()+" | "+entry.getProductName()+" | "+entry.getProductLink());
        }
	}

}
