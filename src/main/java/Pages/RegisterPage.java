package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

    private WebDriver driver;

    // Constructor to initialize WebDriver
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By SigninLink = By.xpath("//a[contains(text(),'Sign In')]");
    private By registerButton = By.xpath("//a[contains(text(),'Register Now!')]");

    private By username = By.name("username");
    private By password = By.name("password");
    private By repeatedpassword = By.name("repeatedPassword");

    private By firstname = By.name("account.firstName");
    private By lastname = By.name("account.lastName");
    private By email = By.name("account.email");
    private By phone = By.name("account.phone");
    private By address1 = By.name("account.address1");
    private By address2 = By.name("account.address2");
    private By city = By.name("account.city");
    private By state = By.name("account.state");
    private By zip = By.name("account.zip");
    private By country = By.name("account.country");

    private By dropdown = By.name("account.languagePreference");
    private By dropdown2 = By.name("account.favouriteCategoryId");

    private By checkbox1 = By.name("account.listOption"); // Newsletter
    private By checkbox2 = By.name("account.bannerOption"); // Banner ads

    private By submitButton = By.name("newAccount"); // Replace with actual submit button locator if different

    // Getters for accessing elements

    public WebElement getSigninLink() {
        return driver.findElement(SigninLink);
    }

    public WebElement getRegisterButton() {
        return driver.findElement(registerButton);
    }

    public WebElement getUsername() {
        return driver.findElement(username);
    }

    public WebElement getPassword() {
        return driver.findElement(password);
    }

    public WebElement getRepeatedpassword() {
        return driver.findElement(repeatedpassword);
    }

    public WebElement getFirstname() {
        return driver.findElement(firstname);
    }

    public WebElement getLastname() {
        return driver.findElement(lastname);
    }

    public WebElement getEmail() {
        return driver.findElement(email);
    }

    public WebElement getPhone() {
        return driver.findElement(phone);
    }

    public WebElement getAddress1() {
        return driver.findElement(address1);
    }

    public WebElement getAddress2() {
        return driver.findElement(address2);
    }

    public WebElement getCity() {
        return driver.findElement(city);
    }

    public WebElement getState() {
        return driver.findElement(state);
    }

    public WebElement getZip() {
        return driver.findElement(zip);
    }

    public WebElement getCountry() {
        return driver.findElement(country);
    }

    public WebElement getDropdown() {
        return driver.findElement(dropdown);
    }

    public WebElement getDropdown2() {
        return driver.findElement(dropdown2);
    }

    public WebElement getCheckbox1() {
        return driver.findElement(checkbox1);
    }

    public WebElement getCheckbox2() {
        return driver.findElement(checkbox2);
    }

    public WebElement getSubmit() {
        return driver.findElement(submitButton);
    }
}
