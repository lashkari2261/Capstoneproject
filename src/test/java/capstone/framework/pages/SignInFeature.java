package capstone.framework.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import capstone.framework.base.BaseStep;

public class SignInFeature extends BaseStep {
	public SignInFeature() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(id = "email")
	public WebElement emailField;

	@FindBy(id = "password")
	public WebElement passwordField;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement loginButton;


	@FindBy(id = "newAccountBtn")
	public WebElement newAccountButton;

	@FindBy(className = "signup__input")
	public WebElement nameInput;

	@FindBy(id = "emailInput")
	public WebElement emailInput;

	@FindBy(id = "passwordInput")
	public WebElement passwordInput;

	@FindBy(id = "confirmPasswordInput")
	public WebElement confirmPasswordInput;

	@FindBy(id = "signupBtn")
	public WebElement signUpButton;

	@FindBy(id = "profileImage")
	public WebElement profileImage;
	@FindBy(id = "nameInput")
	public WebElement changeName;
	@FindBy(id = "personalPhoneInput")
	public WebElement phonenumber;
	@FindBy(id = "personalUpdateBtn")
	public WebElement UpDate;
	@FindBy(id = "previousPasswordInput")
	public WebElement previousPassword;
	@FindBy(id = "newPasswordInput")
	public WebElement newPassword;
	@FindBy(id = "confirmPasswordInput")
	public WebElement confirmPassword;
	@FindBy(id = "credentialsSubmitBtn")
	public WebElement changepassbtn;
	@FindBy(className  = "Toastify") 
	public WebElement PasswordUpdatedSuccessfully;
	@FindBy(className  = "w-full") 
	public WebElement paymentopstion;
	@FindBy(id= "cardNumberInput")
	public WebElement cardnum;
	@FindBy(id= "nameOnCardInput")
	public WebElement cardonthename;
	@FindBy(id= "expirationMonthInput")
	public WebElement expirationMounth;
	@FindBy(id= "expirationYearInput")
	public WebElement expirationyear;
	@FindBy(id= "securityCodeInput")
	public WebElement securityCodeInput;
	@FindBy(id= "paymentSubmitBtn")
	public WebElement paymentSubmitBtn;
	
	@FindBy(className  = "Toastify") 
	public WebElement Paymentmethodaddsuccfully;
	@FindBy (className   ="account__payment__sub-text")
    public List<WebElement> cardEndingNumber;
    @FindBy (xpath ="//button[text()='Edit']")
    public WebElement cardEditButton;
    @FindBy (xpath ="//button[text()='Update Your Card']")
    public WebElement updateYourCardButton;
    @FindBy (className ="Toastify") 
    public WebElement paymentMethodUpdatedSuccessfullyMessage;
	@FindBy(className = "account__address-new")
	public WebElement addaddress;
//	@FindBy(xpath  = "//option[text()='United States']")
	@FindBy(id="countryDropdown")
	public WebElement country;
	@FindBy(id = "fullNameInput")
	public WebElement nameontheaddress;
	@FindBy(id = "phoneNumberInput")
	public WebElement phonenumberaddress;
	@FindBy(id = "streetInput")
	public WebElement streetinput;
	@FindBy(id = "apartmentInput")
	public WebElement apartmentInput;
	@FindBy(id = "cityInput")
	public WebElement cityInput;
//	@FindBy(xpath  = "//select//option[text()='California']")
	@FindBy(xpath ="//select[@name='state']//self::select")
	public WebElement State;
	@FindBy(id  = "zipCodeInput")
	public WebElement zipCodeInput;
	@FindBy(id  = "addressBtn")
	public WebElement addaddressbtn;
	@FindBy(className  = "Toastify") 
	public WebElement AddressAddedSuccessfully;
	@FindBy(xpath = "//button[text()='remove']")
	public WebElement removecard;
	@FindBy (xpath   ="//p[text()='Master Card']")
	public WebElement clickonthecard;
//	@FindBy(className= "text-sm text-blue-700 hover:underline hover:text-red-700")
//	public WebElement addnewcard;
	@FindBy(xpath = "//button[text()='Edit']")
	public WebElement addreaseditedbtn;
	@FindBy(xpath = "//button[text()='Remove']")
	public WebElement removeAddress;
	
}
