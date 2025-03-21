package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateCartPF {
	WebDriver driver;
	
	public UpdateCartPF(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='EST-18']")   
	private WebElement Quantity1;

	@FindBy(xpath="//input[@name='EST-14']")   
	private WebElement Quantity2;

	
	@FindBy(xpath="(//a[@class='Button'])[3]")
	private WebElement Remove;
	
	@FindBy(name="updateCartQuantities")
	private WebElement UpdateCart;
	
	public WebElement getQuantity1() {
		return Quantity1;	
	}
	public WebElement getQuantity2() {
		return Quantity2;	
	}
	public WebElement getRemove() {
		return Remove;	
	}
	public WebElement getUpdateCart() {
		return UpdateCart;	
	}
}
