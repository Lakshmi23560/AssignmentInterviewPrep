package PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Testbase;

public class PoAgentsPage extends Testbase {

	@FindBy(xpath = "//h1[@class='bottom-half']//b[1]")
	public WebElement agentPageName;

	public PoAgentsPage(WebDriver driver) throws IOException {
		PageFactory.initElements(driver, this);
	}

	public String validateAgentName() throws InterruptedException {
		String name = agentPageName.getText();
		return name;
	}
}
