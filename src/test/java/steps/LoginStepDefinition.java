package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.LoginPage;
import pages.TestBase;

public class LoginStepDefinition extends TestBase {
	LoginPage loginPage;

	@Before
	public void beforeRun() {
		initDriver();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		driver.get("https://techfios.com/test/107/");

	}

	@Given("{string} button exists")
	public void button_exists(String button) {
		if (button.equalsIgnoreCase("SetSkyBlueBackground")) {
			loginPage.clickontheskyblueButton();
		} else if (button.equalsIgnoreCase("SetSkyWhiteBackground")) {
			loginPage.clickontheskywhiteButton();
		} else {
			System.out.println("background color change");
		}

	}

	@When("I click on the button")
	public void i_click_on_the_button() {
		loginPage.clickontheskyblueButton();
		loginPage.clickontheskywhiteButton();
	}

	@Then("the background color will change to sky blue")
	public void the_background_color_will_change_to_sky_blue() {
		String expectedColor = "sky blue";
		String actualColor = loginPage.getPageColor();
//The parameter inside the Assert.assertTrue() method is returning true value, therefore the test case pass.
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"extra\"]/button[1]")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"extra\"]/button[1]")).isDisplayed());
	}

	@Then("the background color will change to white")
	public void the_background_color_will_change_to_white() {
		String expectedColor = "white";
		String actualColor = loginPage.getPageColor();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"extra\"]/button[2]")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"extra\"]/button[2]")).isDisplayed());
	}

	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}