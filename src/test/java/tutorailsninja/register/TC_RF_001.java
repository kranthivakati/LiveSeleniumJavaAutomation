package tutorailsninja.register;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

public class TC_RF_001 {
	//test scenario :Verify Registering an Account by providing only the Mandatory fields
	@Test
	public static void Verify_Registering_an_Account_by_providing_only_the_Mandatory_fields() {
		WebDriver driver=new ChromeDriver();
		//global wait for all elements it will differ from one website to another website 
		//if it need to change then one place direct changing the value 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("http://tutorialsninja.com/demo");
		WebElement myaccount=driver.findElement(By.xpath(" //span[text()='My Account']"));
		myaccount.click();
		WebElement Register=driver.findElement(By.xpath("//a[text()='Register']"));
		Register.click();
		Faker fake=new Faker(); //to create real time users so that we are using this class 
		String firstname=fake.name().firstName();
		WebElement firstnametextfield=driver.findElement(By.xpath("//input[@id='input-firstname']"));
		firstnametextfield.sendKeys(firstname);
		String lastname=fake.name().lastName();
		WebElement lastnametextfield=driver.findElement(By.xpath("//input[@id='input-lastname']"));
		lastnametextfield.sendKeys(lastname);
		String email=firstname+lastname+"@gmail.com";
		WebElement emailtextfield=driver.findElement(By.xpath("//input[@id='input-email']"));
	    emailtextfield.sendKeys(email);
	    WebElement PhoneNumber= driver.findElement(By.xpath("//input[@id='input-telephone']"));
	    PhoneNumber.sendKeys(fake.phoneNumber().cellPhone());
	    WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
	    password.sendKeys(firstname+"@123");
	    WebElement reconfirmpassword=driver.findElement(By.xpath("//input[@id='input-confirm']"));
	    reconfirmpassword.sendKeys(firstname+"@123");
	    WebElement checkbox=driver.findElement(By.xpath("//input[@type='checkbox']"));
	    checkbox.click();
	    WebElement continuebutton1=driver.findElement(By.xpath("//input[@value='Continue']"));
	    continuebutton1.click();
	    Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
	    Assert.assertTrue(driver.findElement(By.linkText("Success")).isDisplayed());
	    String expectedresult="Your Account Has Been Created!";
	    Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']/h1")).getText(),expectedresult);
	    String line1="Congratulations! Your new account has been successfully created!";
	    String line2="You can now take advantage of member privileges to enhance your online shopping experience with us.";
	    String line3="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
	    String line4="A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please ";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']/p[1]")).getText(),line1);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']/p[2]")).getText(),line2);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']/p[3]")).getText(),line3);
		//Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']/p[4]")).getText(),line4);
		String line5=driver.findElement(By.xpath("//div[@id='content']")).getText();
		Assert.assertTrue(line5.contains(line4));
	    WebElement continuebutton2=driver.findElement(By.xpath("//a[text()='Continue']"));
	    continuebutton2.click();
	    String myAccount="My Account";
	    Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']/h2[1]")).getText(),myAccount);
	    driver.quit();
	}
}
