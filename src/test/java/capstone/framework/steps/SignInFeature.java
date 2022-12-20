package capstone.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import capstone.framework.pages.POMFactory;
import capstone.framework.utilities.CommonUtility;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInFeature extends CommonUtility {

	POMFactory factory = new POMFactory();

	@When("User click on Sign in option")
	public void userClickOnSignInOption() {
		click(factory.homePage().signIn);
		logger.info("user clicked on Sign In option");
	}

	@And("User enter email {string} and password {string}")
	public void userEnterEmailAndPassword(String email, String password) {
		sendText(factory.signInPage().emailField, email);
		sendText(factory.signInPage().passwordField, password);
		logger.info("user entered email " + email + " and password " + password);
		// slowDown();

	}

	@And("User click on login button")
	public void userClickOnLoginButton() {
		click(factory.signInPage().loginButton);
		logger.info("user clicked on login button");
	}

	@Then("User should be logged in into Account")
	public void userShouldBeLoggedInIntoAccount() {
		Assert.assertTrue(isElementDisplayed(factory.homePage().account));
		logger.info("user logged in into account");
		// slowDown();

	}

	@When("User click on Create New Account button")
	public void userClickOnCreateNewAccountButton() {
		click(factory.signInPage().newAccountButton);
		logger.info("User should get the from to fill up");
	}

	@When("User fill the signUp information with below data")
	public void userFillTheSignUpInformationWithBelowData(DataTable DataTable) {
		List<Map<String, String>> signUpData = DataTable.asMaps(String.class, String.class);
		sendText(factory.signInPage().nameInput, signUpData.get(0).get("name"));
		sendText(factory.signInPage().emailInput, signUpData.get(0).get("email"));
		sendText(factory.signInPage().passwordInput, signUpData.get(0).get("password"));
		sendText(factory.signInPage().confirmPasswordInput, signUpData.get(0).get("confirmPassword"));
		logger.info("user entered required information into sign up from");

	}

	@When("User click on SignUp button")
	public void userClickOnSignUpButton() {
		click(factory.signInPage().signUpButton);
		logger.info("User sould be able to see his account");
	}

	@Then("User should be logged into account page")
	public void userShouldBeLoggedIntoAccountPage() {
//	    Assert.assertTrue(isElementDisplayed(factory.signInPage().profileImage));
		Assert.assertTrue(isElementDisplayed(factory.homePage().account));
		logger.info("User should be able to see the account page");
	}

	@When("User click on Account option")
	public void WhenUserclickonAccountoption() {
		click(factory.homePage().account);
		logger.info("User should be on the account");
	}

	@And("User update Name {string} and Phone {string}")
	public void UserupdateNameAndPhoneNumber(String Name, String Phone) {
		sendText(factory.signInPage().changeName, Name);
		sendText(factory.signInPage().phonenumber, Phone);
		logger.info("User should be able to change the name and phone number");

	}

	@And("User click on Update button")
	public void UseclickonUpdatebutton() {
		click(factory.signInPage().UpDate);
		logger.info("User sould see the Updated value");
	}

	@Then("user profile information should be updated")
	public void userprofileinformationshouldbeupdated() {
		Assert.assertTrue(isElementDisplayed(factory.signInPage().phonenumber));
		logger.info("User sould see the unDated name and phone number");
	}

	@And("User enter below information")
	public void Userenterbelowinformation(DataTable changepassword) throws InterruptedException {

		List<Map<String, String>> password = changepassword.asMaps(String.class, String.class);
		sendText(factory.signInPage().previousPassword, password.get(0).get("previousPassword"));
		sendText(factory.signInPage().newPassword, password.get(0).get("newPassword"));
		sendText(factory.signInPage().confirmPassword, password.get(0).get("confirmPassword"));
		logger.info("User should be able to change password");

		Thread.sleep(2000);

	}

	@And("User click on Change Password button")
	public void UserclickonChangePasswordbutton() throws InterruptedException {
		click(factory.signInPage().changepassbtn);
		logger.info("User should be able to change her password succesfully ");
		Thread.sleep(2000);
	}

	@Then("a message should be displayed ‘Password Updated Successfully’")
	public void amessageshouldbedisplayed() throws InterruptedException {
		Assert.assertTrue(isElementDisplayed(factory.signInPage().PasswordUpdatedSuccessfully));
		logger.info("User should be able to see the that the pass world was changed succsefully");
		Thread.sleep(2000);
	
	}
	@When("User click on Add a payment method link")

	public void userClickOnAddAPaymentMethodLink() {

	click(factory.signInPage().paymentopstion);

	logger.info("User should be able to click on Add Pyment Method Link");

	

	}
	@And("User fill Debit or credit card information")
	public void UserfillDebitorcreditcardinformation(DataTable Paymentinformation) {
		List<Map<String, String>> Payment = Paymentinformation.asMaps(String.class, String.class);
		sendText(factory.signInPage().cardnum, Payment.get(0).get("cardNumber"));
		sendText(factory.signInPage().cardonthename, Payment.get(0).get("nameOnCard"));
		sendText(factory.signInPage().expirationMounth, Payment.get(0).get("expirationMonth"));
		sendText(factory.signInPage().expirationyear, Payment.get(0).get("expirationYear"));
		sendText(factory.signInPage().securityCodeInput, Payment.get(0).get("securityCode"));
		logger.info("User should fill out all the information");
	}
	@And("User click on Add your card button")
	public void UserclickonAddyourcardbutton() {
		click(factory.signInPage().paymentSubmitBtn);
		logger.info("User should be able see the submitbtn");
	}
	
	@Then("a message should be displayed ‘Payment Method added successfully’")
public void amessageshouldbedisplayed3() {
		Assert.assertTrue(isElementDisplayed(factory.signInPage().Paymentmethodaddsuccfully));
		logger.info("User card should be added");
		
}
	@When("User select card with ending {string}")
    public void userSelectCardwithEnding(String cardEndingNumber) {
        List<WebElement> cards = factory.signInPage().cardEndingNumber;
        for (WebElement card : cards) {
            if (card.getText().equals(cardEndingNumber))
            	System.out.println(card.getText() + "======================");
                click(card);
            logger.info(cardEndingNumber + "is selected");
           break;
      
        	
        }
    } 
    @When("User click on Edit option of card section")
    public void userClickOnEditOption0fCardSection() {
        click(factory.signInPage().cardEditButton);
        logger.info("user clicked on Edit Option");
    }
    @When("user edit information with below data")
    public void userEditInformationWithBelowData(DataTable dataTable) {
        List<Map<String, String>> paymentInformation = dataTable.asMaps(String.class, String.class);
        clearTextUsingSendKeys(factory.signInPage().cardnum);
        sendText(factory.signInPage().cardnum, paymentInformation.get(0).get("cardNumber"));
        slowDown();
        clearTextUsingSendKeys(factory.signInPage().cardonthename);
        sendText(factory.signInPage().cardonthename, paymentInformation.get(0).get("nameOnCard"));
        slowDown();
        selectByVisibleText(factory.signInPage().expirationMounth,
                paymentInformation.get(0).get("expirationMonth"));
        slowDown();
        selectByVisibleText(factory.signInPage().expirationyear,
                paymentInformation.get(0).get("expirationYear"));
        slowDown();
        clearTextUsingSendKeys(factory.signInPage().securityCodeInput);
        sendText(factory.signInPage().securityCodeInput, paymentInformation.get(0).get("securityCode"));
        slowDown();
        logger.info("user entered required card information");
    }
    @When("user click on Update Your Card button")
    public void userClickOnUpdateYourCardButton() {
        click(factory.signInPage().updateYourCardButton);
        logger.info("user clicked on Update your card button");
        
    }
    @Then("a message should be displayed ‘Payment Method updated Successfully’")
    public void aMessageShouldBeDisplayedPaymentMethodUpdatedSuccessfully() {
    	Assert.assertTrue(isElementDisplayed(factory.signInPage().paymentMethodUpdatedSuccessfullyMessage));
    	logger.info("User should see that the informantion is update it");
}
    
    @When("User click on Add address option")
    public void userClickOnAddAddressOption() {
        click(factory.signInPage().addaddress);
        logger.info("User should see the form to fill out the information");
    }
    @When("user fill new address form with below information")
    public void userFillNewAddressFormWithBelowInformation(DataTable dataTable) throws InterruptedException {
    	List<Map<String, String>> Addaddress = dataTable.asMaps(String.class, String.class);
    	selectByVisibleText(factory.signInPage().country,Addaddress.get(0).get("country"));
    	click(factory.signInPage().country);
    	slowDown();
//    	sendText(factory.signInPage().nameontheaddress,Addaddress.get(0).get("country"));
//    	slowDown();
    	sendText(factory.signInPage().nameontheaddress,Addaddress.get(0).get("fullName"));
    	slowDown();
    	sendText(factory.signInPage().phonenumberaddress,Addaddress.get(0).get("phoneNumber"));
    	slowDown();
    	sendText(factory.signInPage().streetinput,Addaddress.get(0).get("streetAddress"));
    	slowDown();
    	sendText(factory.signInPage().apartmentInput,Addaddress.get(0).get("apt"));
    	slowDown();
    	sendText(factory.signInPage().cityInput,Addaddress.get(0).get("city"));
    	slowDown();
    	selectByVisibleText(factory.signInPage().State,Addaddress.get(0).get("state"));
    	click(factory.signInPage().State);
    	slowDown();
    	sendText(factory.signInPage().zipCodeInput,Addaddress.get(0).get("zipCode"));
    	slowDown();
    	logger.info("User should see all the information they fill out");
    	slowDown();
    	
    	
    }
    @When("User click Add Your Address button")
    public void userClickAddYourAddressButton() {
       click(factory.signInPage().addaddressbtn);
       logger.info("user should add the address");
    }
    @Then("a message should be displayed ‘Address Added Successfully’")
    public void aMessageShouldBeDisplayedAddressAddedSuccessfully() {
    	Assert.assertTrue(isElementDisplayed(factory.signInPage().AddressAddedSuccessfully));
    	logger.info("User should see the information is added");
    }
    @And("User click on remove option of card section")
    public void Userclickonremoveoptionofcardsection() {
    	click(factory.signInPage().clickonthecard);
    	slowDown();
    	click(factory.signInPage().removecard);
    	slowDown();
    	logger.info("user should click on the remover botton");
    }
    @Then("payment details should be removed")
    public void paymentdetailsshouldberemoved() {
//    	Assert.assertTrue(isElementDisplayed(factory.signInPage().clickonthecard));
    	logger.info("card should not be there");
    }
    @And("User click on edit address option")
    public void Userclickoneditaddressoption() {
    	scrollPageDownWithJS();
    	click(factory.signInPage().addreaseditedbtn);
    	logger.info("User click on the edited btn");
    }
    @And("User fill Upated information below")
    public void UserfillUpatedinformationbelow(DataTable editAddress)  {
    	List<Map<String, String>> EditAddress = editAddress.asMaps(String.class, String.class);
    	selectByVisibleText(factory.signInPage().country,EditAddress.get(0).get("country"));
    	click(factory.signInPage().country);
    	slowDown();
//    	sendText(factory.signInPage().nameontheaddress,Addaddress.get(0).get("country"));
//    	slowDown();
    	clearTextUsingSendKeys(factory.signInPage().nameontheaddress);
    	sendText(factory.signInPage().nameontheaddress,EditAddress.get(0).get("fullName"));
    	slowDown();
    	clearTextUsingSendKeys(factory.signInPage().phonenumberaddress);
    	sendText(factory.signInPage().phonenumberaddress,EditAddress.get(0).get("phoneNumber"));
    	slowDown();
    	clearTextUsingSendKeys(factory.signInPage().streetinput);
    	sendText(factory.signInPage().streetinput,EditAddress.get(0).get("streetAddress"));
    	slowDown();
    	clearTextUsingSendKeys(factory.signInPage().apartmentInput);
    	sendText(factory.signInPage().apartmentInput,EditAddress.get(0).get("apt"));
    	slowDown();
    	clearTextUsingSendKeys(factory.signInPage().cityInput);
    	sendText(factory.signInPage().cityInput,EditAddress.get(0).get("city"));
    	slowDown();
    	selectByVisibleText(factory.signInPage().State,EditAddress.get(0).get("state"));
    	click(factory.signInPage().State);
    	slowDown();
    	clearTextUsingSendKeys(factory.signInPage().zipCodeInput);
    	sendText(factory.signInPage().zipCodeInput,EditAddress.get(0).get("zipCode"));
    	slowDown();
    	logger.info("User should see all the information they fill out");
    	slowDown();
}
   @And("User click update Your Address button")
   public void UserclickupdateYourAddressbutton() {
	   click(factory.signInPage().addaddressbtn);
	   logger.info("User clicked on the update btn");
   }
   @Then("a message should be displayed ‘Address Updated Successfully’")
   public void aMessageShouldBeDisplayedAddressUpdatedSuccessfully() {
	   Assert.assertTrue(isElementDisplayed(factory.signInPage().AddressAddedSuccessfully));
	   logger.info("User information should be upadate it");
   }
   @And("User click on remove option of Address section")
   public void UserclickonremoveoptionofAddresssection() {
	   click(factory.signInPage().removeAddress);
	   logger.info("User click remove address");
   }
   @Then("Address details should be removed")
   public void Addressdetailsshouldberemoved() {
	   logger.info("User should not see the information");
   }
}