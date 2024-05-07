package testPackage;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import parameters.Parameters;

public class Testcase extends Parameters {
	WebDriver driver = new ChromeDriver();
	Actions action = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@BeforeTest
	public void mySetup() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
		driver.get(URL);

	}

	@Test(enabled = false, priority = 1)
	public void myTest() {

		WebElement createAccountBtn = driver.findElement(By.cssSelector("ul[id='customer_menu_top'] li a"));
		createAccountBtn.click();
		WebElement createNewAccountBtn = driver.findElement(By.cssSelector("button[title='Continue']"));
		createNewAccountBtn.click();

	}

	@Test(enabled = false, priority = 2)
	public void regestrationNewAccount() throws InterruptedException {

		WebElement firstNameInput = driver.findElement(By.cssSelector("#AccountFrm_firstname"));
		WebElement lastNameInput = driver.findElement(By.cssSelector("#AccountFrm_lastname"));
		WebElement emailInput = driver.findElement(By.cssSelector("#AccountFrm_email"));
		WebElement addresslInput = driver.findElement(By.cssSelector("#AccountFrm_address_1"));
		WebElement citylInput = driver.findElement(By.cssSelector("#AccountFrm_city"));
		WebElement zoneID = driver.findElement(By.cssSelector("#AccountFrm_zone_id"));
		WebElement postCode = driver.findElement(By.cssSelector("#AccountFrm_postcode"));
		WebElement country = driver.findElement(By.cssSelector("#AccountFrm_country_id"));
		WebElement loginUser = driver.findElement(By.cssSelector("#AccountFrm_loginname"));
		WebElement passInput = driver.findElement(By.cssSelector("#AccountFrm_password"));
		WebElement confirmPassInput = driver.findElement(By.cssSelector("#AccountFrm_confirm"));
		WebElement submitBtn = driver.findElement(By.cssSelector("button[title='Continue']"));

		firstNameInput.sendKeys(randoomFirstName[randFName]);
		lastNameInput.sendKeys(randoomLastName[randLName]);
		emailInput.sendKeys(randoomFirstName[randFName] + randoomLastName[randLName] + randomNum + "@gmail.com");
		addresslInput.sendKeys("amman");
		citylInput.sendKeys("jordan");
		Select selectorOne = new Select(zoneID);
		Thread.sleep(1500);
		int randomRegion = rand.nextInt(20);
		selectorOne.selectByIndex(randomRegion);
		Select selectorO = new Select(zoneID);
		Thread.sleep(1500);
		selectorO.selectByIndex(randomRegion);
		postCode.sendKeys("8974510");
		loginUser.sendKeys(randoomFirstName[randFName] + randoomLastName[randLName]);
		passInput.sendKeys("Mohmmad@123456");
		confirmPassInput.sendKeys("Mohmmad@123456");
		driver.findElement(By.cssSelector("#AccountFrm_agree")).click();
		submitBtn.click();
	}

	@Test(enabled = false, priority = 3)
	public void loginSuiteTest() throws InterruptedException {

//		Thread.sleep(2000);
		WebElement menSection = driver.findElement(By.xpath("(//a[contains(text(),'Men')])[3]"));
		menSection.click();
//		action.moveToElement(acountDropDown).perform();
		Thread.sleep(2000);
//		driver.findElement(By.partialLinkText("LOGOUT")).click();
		for (int i = 0; i < 4; i++) {
			int index = i + 1;
			WebElement addBtn = driver.findElement(By.xpath("(//a[@title='Add to Cart'])[" + index + "]"));
			addBtn.click();

			boolean isClickable;
			try {
				wait.until(ExpectedConditions.elementToBeClickable(addBtn));
				isClickable = true;
			} catch (TimeoutException e) {
				isClickable = false;
			}

			if (isClickable == true) {
				System.out.println("The button is clickable.");
				WebElement countity = driver.findElement(By.cssSelector("#product_quantity"));
				countity.clear();
				countity.sendKeys("5");
				WebElement addToCartBtn = driver.findElement(By.cssSelector(".cart"));
				addToCartBtn.click();
				Thread.sleep(1000);
				driver.navigate().back();
				driver.navigate().back();
			} else {
				System.out.println("The button is not clickable.");
			}

		}
	}

	@Test(enabled = true, priority = 4)
	public void asrestForPhoneNumber() {

		WebElement phoneNumber = driver.findElement(By.cssSelector(".contact"));
		List<WebElement> listOfContact = phoneNumber.findElements(By.tagName("li"));
		assertEquals(listOfContact.get(0).getText(), " +123 456 7890");

		WebElement siteMap = driver.findElement(By.xpath("//a[normalize-space()='Site Map']"));
		siteMap.click();
		WebElement bigCountener = driver.findElement(By.xpath("//div[@id='maincontainer']//div[@class='row']//div[1]"));
		WebElement smallCountener = bigCountener.findElement(By.tagName("ul"));
		List<WebElement> listOfList = smallCountener.findElements(By.tagName("li"));

		for (int i = 0; i < listOfList.size(); i++) {
			System.out.println(listOfList.get(i).getText());
		}

	}

	@Test(enabled = false)
	public void regestrationNgewAccount() throws InterruptedException {
		driver.get("https://leaders.jo/en/lg/");
		driver.manage().window().maximize();

		WebElement allItemCountiner = driver.findElement(By.cssSelector(
				".products.product-card-layout-1.columns-6.mobile-col-2.mobile-show-atc.mobile-featured-icons--hover"));
		List<WebElement> listItem = allItemCountiner.findElements(By.tagName("li"));
		System.out.println(listItem.size());
		int randomNumberOfItem = rand.nextInt(listItem.size());
		action.moveToElement(listItem.get(randomNumberOfItem)).perform();
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Add to")).click();
		Thread.sleep(1000);

	}
}
