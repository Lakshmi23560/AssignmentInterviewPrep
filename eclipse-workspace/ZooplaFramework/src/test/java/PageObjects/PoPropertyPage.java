package PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.TestBase;

public class PoPropertyPage extends TestBase {

	@FindBy(xpath = "//h4[@class='ui-agent__name'][1]")
	public WebElement agentName;

	public PoPropertyPage(WebDriver driver) throws IOException, InterruptedException {

		PageFactory.initElements(driver, this);
	}

	public void clickOnAgentName() throws Exception {

		// WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='ui-agent__name']")));
		oBrowsUtil.ufClick(driver, agentName, 30);

	}

	public String getAgentName() throws InterruptedException {
		String name = agentName.getText();
		return name;
	}

}
