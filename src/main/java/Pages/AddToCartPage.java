package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCartPage {
	WebDriver driver;
	
    // Constructor to initialize WebDriver
    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
    }
    
 // Locators
    private By Birds = By.xpath("(//a[@href='/actions/Catalog.action?viewCategory=&categoryId=BIRDS'])[2]");
    private By Cats = By.xpath("(//a[@href='/actions/Catalog.action?viewCategory=&categoryId=CATS'])[2]");
    private By Dogs = By.xpath("(//a[@href='/actions/Catalog.action?viewCategory=&categoryId=DOGS'])[2]");
    private By AmazonParrot = By.xpath("//a[text()='AV-CB-01']");
    private By AmazonParrotId = By.xpath("//a[text()='EST-18']");
    private By ManxCat = By.xpath("//a[text()='FL-DSH-01']");
    private By ManxCatId = By.xpath("//a[text()='EST-14']");
    private By Dalmation = By.xpath("//a[text()='K9-DL-01']");
    private By DalmationId = By.xpath("//a[text()='EST-10']");
    private By AddToCart = By.xpath("//a[text()='Add to Cart']");
    private By returnToMainMenu = By.xpath("//a[contains(text(),'Return to Main Menu')]");
   

	public WebElement getBirds() {
		return driver.findElement(Birds);
	}
	public WebElement getCats() {
	    return driver.findElement(Cats);
	}
	public WebElement getDogs() {
	    return driver.findElement(Dogs);
	}
	public WebElement getAmazonParrot() {
		return driver.findElement(AmazonParrot);
	}
	public WebElement getManxCat() {
	    return driver.findElement(ManxCat);
	}
	public WebElement getDalmation() {
	    return driver.findElement(Dalmation);
	}
	public WebElement getAmazonParrotId() {
	    return driver.findElement(AmazonParrotId);
	}
	public WebElement getManxCatId() {
	    return driver.findElement(ManxCatId);
	}
	public WebElement getDalmationId() {
	    return driver.findElement(DalmationId);
	}
	public WebElement getAddToCart() {
		return driver.findElement(AddToCart);
	}
	public WebElement getReturnToMainMenu() {
	    return driver.findElement(returnToMainMenu);
	}
	
}
