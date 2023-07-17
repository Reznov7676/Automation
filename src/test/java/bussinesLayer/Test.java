package bussinesLayer;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Test {

	
	
	public void hello() {
		
		
	}
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		
		JSONParser readFiles = new JSONParser();
		JSONObject re = (JSONObject) readFiles.parse(new FileReader("/Users/jaymaldikar/eclipse-workspace/PageObjectModel/json/data.json"));
		String qw =(String) re.get("name");
		System.out.println(qw);

		test2 y = new test2();
		
	}

}
