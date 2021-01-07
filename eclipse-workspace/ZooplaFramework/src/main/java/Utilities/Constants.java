package Utilities;

public class Constants {

	final public int WAIT_COMMON = 5;

	public String getAppURL() throws Exception {

		String environmentFromConfig = System.getProperty("Environment").toLowerCase().trim();
		if (environmentFromConfig.startsWith("qa"))
			return "https://www.zoopla.co.uk/";
		else if (environmentFromConfig.startsWith("dev"))
			return "https://www.zoopla.co.uk/";
		else if (environmentFromConfig.startsWith("prd"))
			return "https://www.zoopla.co.uk/";
		else {
			return "set environment correctly...";
		}
	}
}
