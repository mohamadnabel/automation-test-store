package testPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import parameters.Parameters;

public class Testcase extends Parameters {
	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void mySetup() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
		driver.get(URL);

	}

	@Test
	public void myTest() {

		WebElement createAccountBtn = driver.findElement(By.cssSelector("ul[id='customer_menu_top'] li a"));
		createAccountBtn.click();
		WebElement createNewAccountBtn = driver.findElement(By.cssSelector("button[title='Continue']"));
		createNewAccountBtn.click();

	}

	@Test
	public void regestrationNewAccount() {

		WebElement firstNameInput = driver.findElement(By.cssSelector("#AccountFrm_firstname"));
		WebElement lastNameInput = driver.findElement(By.cssSelector("#AccountFrm_lastname"));
		WebElement emailInput = driver.findElement(By.cssSelector("#AccountFrm_email"));
		WebElement addresslInput = driver.findElement(By.cssSelector("#AccountFrm_address_1"));
		WebElement citylInput = driver.findElement(By.cssSelector("#AccountFrm_city"));
		WebElement zoneID = driver.findElement(By.cssSelector("#AccountFrm_zone_id"));
		WebElement postCode = driver.findElement(By.cssSelector("#AccountFrm_postcode"));
		WebElement country = driver.findElement(By.cssSelector("#AccountFrm_country_id"));

		Select selectorOne = new Select(zoneID);
		int randomRegion = rand.nextInt(50);
		selectorOne.selectByIndex(randomRegion);

		Select selectorTow = new Select(country);
		int randomCountry = rand.nextInt(50);
		selectorTow.selectByIndex(randomCountry);
	}
}
