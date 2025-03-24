package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPagePF {
	WebDriver driver;
	public CheckOutPagePF(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[text()='Proceed to Checkout']")   
	private WebElement proceed;

	@FindBy(xpath="//select[@name='order.cardType']")   
	private WebElement dropdown;

	
	@FindBy(name="order.creditCard")
	private WebElement CardNumber;
	
	@FindBy(name="order.expiryDate")
	private WebElement ExpiryDate;
	
	@FindBy(name="order.billToFirstName")
	private WebElement FirstName;
	
	@FindBy(name="order.billToLastName")
	private WebElement LastName;
	
	@FindBy(name="order.billAddress1")
	private WebElement Address1;
	
	@FindBy(name="order.billAddress2")
	private WebElement Address2;
	
	@FindBy(name="order.billCity")
	private WebElement city;
	
	@FindBy(name="order.billState")
	private WebElement state;
	
	@FindBy(name="order.billZip")
	private WebElement zip;
	
	@FindBy(name="order.billCountry")
	private WebElement country;
	
	@FindBy(name="shippingAddressRequired")
	private WebElement checkbox;
	
	@FindBy(name="newOrder")
	private WebElement submit;
	
	@FindBy(name="order.shipAddress1")
	private WebElement Address_1;
	
	@FindBy(name="order.shipAddress2")
	private WebElement Address_2;
	
	@FindBy(name="newOrder")
	private WebElement finalsubmit;
	
	@FindBy(xpath="//a[text()='Confirm']")
	private WebElement confirm;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement SignOut;
	
	public WebElement getProceed() {
		return proceed;
	}

	public WebElement getDropdown() {
		return dropdown;
	}

	public WebElement getCardNumber() {
		return CardNumber;
	}

	public WebElement getExpiryDate() {
		return ExpiryDate;
	}

	public WebElement getFirstName() {
		return FirstName;
	}

	public WebElement getLastName() {
		return LastName;
	}

	public WebElement getAddress1() {
		return Address1;
	}

	public WebElement getAddress2() {
		return Address2;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getZip() {
		return zip;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getCheckbox() {
		return checkbox;
	}
	
	public WebElement getSubmit() {
		return submit;
	}
	public WebElement getAddress_1() {
		return Address_1;
	}

	public WebElement getAddress_2() {
		return Address_2;
	}
	public WebElement getFnalSubmit() {
		return finalsubmit;
	}
	public WebElement getConfirm() {
		return confirm;
	}
	public WebElement getSignout() {
		return SignOut;
	}

}
