package resources;

import com.qa.pojo.BitlyDataPojo;

public class TestDataBuild {


	public BitlyDataPojo shortenPL() {

		BitlyDataPojo BPayLoad=new BitlyDataPojo();
		BPayLoad.setLong_url("https://www.guru99.com/abap-tutorial.html");
		BPayLoad.setDomain("bit.ly");

		return BPayLoad;
	}

	public String createBitlinkPL() {

		return "{\r\n"
				+ "  \"long_url\": \"https://dev.bitly.com\",\r\n"
				+ "  \"domain\": \"bit.ly\",\r\n"
				+ "  \"group_guid\": \"Bl7b8QuEGAw\",\r\n"
				+ "  \"title\": \"Bitly API Documentation\",\r\n"
				+ "  \"tags\": [\r\n"
				+ "    \"bitly\",\r\n"
				+ "    \"api\"\r\n"
				+ "  ]\r\n"
				+ "  }";
	}
	
	public String blanklongurl() {
		return "{\r\n"
				+ "  \"long_url\": \"\",\r\n"
				+ "  \"domain\": \"bit.ly\",\r\n"
				+ "  \"group_guid\": \"Bl7b8QuEGAw\",\r\n"
				+ "  \"title\": \"Bitly API Documentation\",\r\n"
				+ "  \"tags\": [\r\n"
				+ "    \"bitly\",\r\n"
				+ "    \"api\"\r\n"
				+ "  ]\r\n"
				+ "  }";
	}

	
	public String expandBitlinkPL() {
		
		return "{\r\n"
				+ "  \"bitlink_id\": \"bit.ly/3r23Avz\"\r\n"
				+ "}";
	}

	
	

}
