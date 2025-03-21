package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginpPage {
	WebDriver driver;
    // Constructor to initialize WebDriver
    public LoginpPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By SigninLink = By.xpath("//a[contains(text(),'Sign In')]");
    private By username = By.name("username");
    private By password = By.name("password");
    private By LoginButton=By.name("signon");
    
	public WebElement getSigninLink() {
		return driver.findElement(SigninLink);
	}
	public WebElement getUsername() {
		return driver.findElement(username);
	}
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	public WebElement getLoginButton() {
		return driver.findElement(LoginButton);
	}
	
}
