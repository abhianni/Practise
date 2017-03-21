package src;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import javax.sound.sampled.AudioFormat.Encoding;

public class ParsingLogFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 Path filename = Paths.get("D:\\New folder\\log.log");
 ParsingLogFile parse = new ParsingLogFile();
 parse.parseLineByline(filename);
	}
	
	public void parseLineByline(Path filename)
	{
		try {
			Scanner scan = new Scanner(Paths.get("D:\\New folder\\log.log"));			
			while(scan.hasNextLine())
			{
				processline(scan.nextLine());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void processline(String line)
	{
		
		if(line.contains("Error"))
		{
			String[] op = line.split(": ");
			System.out.println(op[0]+" Appeared due to :- "+op[1]);
		}
		
		}
}
