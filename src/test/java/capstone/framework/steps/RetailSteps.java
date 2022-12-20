package capstone.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import capstone.framework.pages.POMFactory;
import capstone.framework.utilities.CommonUtility;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RetailSteps extends CommonUtility {
	private POMFactory factory = new POMFactory();

	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
		String expectedTitle = "React App";
		String actualTitle = getTitle();// wrote this one in CommonUtility
		Assert.assertEquals(expectedTitle, actualTitle);
		logger.info(actualTitle + " is equal to " + expectedTitle);
	}

	@Then("assert application title {string}")
	public void assertApplicationTitle(String expectedTitle) {

	}

	public POMFactory getFactory1() {
		return factory;
	}

	public void setFactory1(POMFactory factory) {
		this.factory = factory;
	}

//	@When("User click on All section")
//	public void UserclickonAllsection() {
//		click(factory.homePage().allElement);
//		logger.info("User click on all");
//	}

	@Then("below options are present in Shop by Department sidebar")
	public void belowoptionsarepresentinShopbyDepartmentsidebar(DataTable DataTable) {
		List<Map<String, String>> Visable = DataTable.asMaps(String.class, String.class);
		Assert.assertTrue(isElementDisplayed(factory.homePage().electronics));
		Assert.assertTrue(isElementDisplayed(factory.homePage().computers));
		Assert.assertTrue(isElementDisplayed(factory.homePage().smartHome));
		Assert.assertTrue(isElementDisplayed(factory.homePage().sports));
		Assert.assertTrue(isElementDisplayed(factory.homePage().automative));
		logger.info("user should see all the element");
	}
	@When("User click on All section")
    public void UserClickOnAllSectionBtn() {
        click(factory.homePage().allDep);
        slowDown();
        Assert.assertTrue(isElementDisplayed(factory.homePage().allDep));
        logger.info("user click on all section");
    }
    @When("User on Electronics")
    public void userOnElectronics() {
        click(factory.homePage().Electronics);
        Assert.assertTrue(isElementDisplayed(factory.homePage().TVAndVideo));
        Assert.assertTrue(isElementDisplayed(factory.homePage().videoGames));
        logger.info("user On Electronics");
    }
    @When("User on Computers")
    public void userOnComputers() {
        click(factory.homePage().Computers);
        slowDown();
        Assert.assertTrue(isElementDisplayed(factory.homePage().Accessiries));
        Assert.assertTrue(isElementDisplayed(factory.homePage().Networking));
        logger.info("user On Computers");
    }
    @When("User on Smart Home")
    public void userOnSmartHome() {
        click(factory.homePage().SmartHome);
        slowDown();
        Assert.assertTrue(isElementDisplayed(factory.homePage().SmartHomeLighting));
        Assert.assertTrue(isElementDisplayed(factory.homePage().PlugsAndOultlets));
        logger.info("user On Smart Home");
    }
    @When("User on Sports")
    public void userOnSports() {
        click(factory.homePage().sports);
        slowDown();
        Assert.assertTrue(isElementDisplayed(factory.homePage().AtheticClothing));
        Assert.assertTrue(isElementDisplayed(factory.homePage().ExerciseFitness));
        logger.info("user On Sports");
    }
    @When("User on Automotive")
    public void userOnAutomotive() {
        click(factory.homePage().automative);
        slowDown();
        Assert.assertTrue(isElementDisplayed(factory.homePage().AutomativePartsAccessoriecs));
        Assert.assertTrue(isElementDisplayed(factory.homePage().MotorCyclePowerSports));
        logger.info("user On Automotive");
    }
    @Then("below options are present in department")
    public void belowOptionsArePresentInDepartment(DataTable dataTable) {
        List<List<String>> department = dataTable.asLists();
        switch (department.toString()) {
        case "Electronics":
            click(factory.homePage().Electronics);
            String video = getText(factory.homePage().videoGames);
            String TVAndVideo = getText(factory.homePage().TVAndVideo);
            Assert.assertEquals(TVAndVideo, department.get(0).get(0));
            Assert.assertEquals(video, department.get(0).get(1));
            logger.info(video + " options are present in department" + TVAndVideo);
            break;
        case "Computers":
            click(factory.homePage().Computers);
            String Accessories = getText(factory.homePage().Accessiries);
            String Networking = getText(factory.homePage().Networking);
            Assert.assertEquals(Accessories, department.get(0).get(0));
            Assert.assertEquals(Networking, department.get(0).get(1));
            logger.info(Accessories + " options are present in department" + Networking);
            break;
        case "Sports":
            click(factory.homePage().sports);
            String AthleticClothing = getText(factory.homePage().AtheticClothing);
            String ExerciseFitness = getText(factory.homePage().ExerciseFitness);
            Assert.assertEquals(AthleticClothing, department.get(0).get(0));
            Assert.assertEquals(ExerciseFitness, department.get(0).get(1));
            logger.info(AthleticClothing + " options are present in department" + ExerciseFitness);
            break;
        case "Automotive":
            click(factory.homePage().automative);
            String AutomativePartsAccessories = getText(factory.homePage().AutomativePartsAccessoriecs);
            String MotorCyclePowersports = getText(factory.homePage().MotorCyclePowerSports);
            Assert.assertEquals(AutomativePartsAccessories, department.get(0).get(0));
            Assert.assertEquals(MotorCyclePowersports, department.get(0).get(1));
            logger.info(MotorCyclePowersports + " options are present in department" + AutomativePartsAccessories);
            break;
        }
    }
	@When("User change the category to {string}")

	public void userChangeTheCategoryTo(String value) {

		selectByVisibleText(factory.homePage().allDepartments, value);

		logger.info(value + " was selected from the drop down");
		slowDown();
	}

	@And("User search for an item {string}")
	public void Usersearchforanitemkasaoutdoorsmartplug(String value) {
		sendText(factory.homePage().searchInputField, value);
		logger.info("User should write the item they need");
		slowDown();
	}

	@And("User click on Search icon")
	public void UserclickonSearchicon() {
		click(factory.homePage().searchButton);
		logger.info("user should see the item");
		slowDown();
	}

	@And("User click on item")
	public void Userclickonitem() {
		click(factory.homePage().itemkassaoutdoor);
		logger.info("User should click on the item");
		slowDown();
	}

	@And("User select quantity ‘2’")
	public void Userselectquantity() {
		click(factory.homePage().qtyTwo);
		logger.info("User should change quintidy to two");
		slowDown();
	}

	@And("User click add to Cart button")
	public void UserclickaddtoCartbutton() {
		click(factory.homePage().addToTheCard);
		logger.info("user Should see that the it add to the card");
		slowDown();
	}

	@Then("the cart icon quantity should change to ‘2’")
	public void thecartconquantityshouldchangeto() {
		Assert.assertTrue(isElementDisplayed(factory.homePage().cart));
		logger.info("User should it added");
		slowDown();
	}

	@Then("User click on Cart option")
	public void userClickOnCartOption() {
		waitTillPresence(factory.homePage().cart);
		click(factory.homePage().cart);
		logger.info("User should be able to click on cart option");
		slowDown();
	}

	@Then("User click on Proceed to Checkout button")
	public void userClickOnProceedToCheckoutButton() {
		waitTillPresence(factory.homePage().proccedBtn);
		click(factory.homePage().proccedBtn);
		logger.info("User click on Proceed to Checkout button");
		slowDown();
	}

	@Then("User click Add a new address link for shipping address")
	public void userClickAddANewAddressLinkForShippingAddress() {
		waitTillPresence(factory.homePage().addAddressBtn);
		slowDown();
		click(factory.homePage().addAddressBtn);
		logger.info("User should be able to click on add a new address button");
	}

	@Then("User fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation(DataTable dataTable) {
		List<Map<String, String>> Addaddress = dataTable.asMaps(String.class, String.class);
		selectByVisibleText(factory.homePage().country, Addaddress.get(0).get("country"));
		click(factory.homePage().country);
		sendText(factory.signInPage().nameontheaddress, Addaddress.get(0).get("fullName"));
		sendText(factory.signInPage().phonenumberaddress, Addaddress.get(0).get("phoneNumber"));
		sendText(factory.signInPage().streetinput, Addaddress.get(0).get("streetAddress"));
		sendText(factory.signInPage().apartmentInput, Addaddress.get(0).get("apt"));
		sendText(factory.homePage().cityInput, Addaddress.get(0).get("city"));
		selectByVisibleText(factory.homePage().state, Addaddress.get(0).get("state"));
		click(factory.homePage().state);
		sendText(factory.homePage().zipCodeInput, Addaddress.get(0).get("zipCode"));
		logger.info("User should see all the information they fill out");
		slowDown();
	}

//	@Then("User click Add Your Address button")
//	public void userClickAddYourAddressButton() {
//	click(factory.signInPage().addaddressbtn);
//	logger.info("User click on Add Your Address Buttn");
//	}

	@Then("User click Add a credit card or Debit Card for Payment method")
	public void userClickAddACreditCardOrDebitCardForPaymentMethod() {
		slowDown();
		click(factory.homePage().addPaymentBtn);
		slowDown();
		logger.info("User should be able to click on Add Your payment Buttn");
		slowDown();
		click(factory.signInPage().paymentSubmitBtn);
	}

	@Then("User click on Place Your Order")
	public void userClickOnPlaceYourOrder() {
		click(factory.homePage().placeOrderBtn);
		logger.info("User click on Add Your Address Buttn");
		slowDown();
	}

	@Then("a message should be displayed ‘Order Placed, Thanks’")
	public void amessageshouldbedisplayed() {
		Assert.assertTrue(isElementDisplayed(factory.signInPage().paymentMethodUpdatedSuccessfullyMessage));
	}

	@When("User select quantity ‘5’")

	public void userSelectQuantity() {
		click(factory.homePage().qty5);
		logger.info("user should select 5");
		slowDown();
	}

	@Then("the cart icon quantity should change to ‘5’")
	public void theCartIconQuantityShouldChangeTo() {
		Assert.assertTrue(isElementDisplayed(factory.homePage().qtyFive));
		logger.info("User should see the card icon is 5");
		slowDown();
	}

	@And("User click on Orders section")
	public void UserclickonOrderssection() {
		click(factory.homePage().ORDERS);
		logger.info("user should click on orders");
		slowDown();
	}

	@And("User click on first order in list")
	public void Userclickonfirstorderinlist() {
		logger.info("user should see the first order");
		slowDown();
	}

	@And("User click on Cancel The Order button")
	public void UserclickonCancelTheOrderbutton() {
		click(factory.homePage().cancelorder);
		logger.info("User should cancel order");
		slowDown();
	}

	@And("User select the cancelation Reason ‘Bought wrong item’")
	public void UserselectthecancelationReason() {
		click(factory.homePage().reasonforreturn);
		logger.info("user should see the option for return");
		slowDown();
	}

	@And("User click on Cancel Order button")
	public void UserclickonCancelOrderbutton() {
		click(factory.homePage().cancel);
		logger.info("user should click on the cancel");
		slowDown();
	}

	@Then("a cancelation message should be displayed ‘Your Order Has Been Cancelled’")
	public void acancelationmessageshouldbedisplayed() {
		Assert.assertTrue(isElementDisplayed(factory.homePage().YourOrderHasBeenCancelled));
		logger.info("user should see the message");
		slowDown();
	}
	@And("User click on Return Items button")
	public void UserclickonReturnItemsbutton() {
		click(factory.homePage().returnitem);
		logger.info("User should click on the return order");
	}
	@And("User select the Return Reason ‘Item damaged’")
	public void UserselecttheReturnReason() {
		click(factory.homePage().Itemdamaged);
		logger.info("User should select the opotion for item damaged");
	}
	@And("User select the drop off service ‘FedEx’")
	public void Userselectthedropoffservice() {
		click(factory.homePage().FedEX);
		logger.info("User should select the opotion for Fedex");
	}
	@And("User click on Return Order button")
	public void UserclickonReturnOrderbutton() {
		click(factory.homePage().Returnorder);
		logger.info("User should select the opotion for Fedex");
	}
	@Then("a cancelation message should be displayed ‘Return was successful’")
	public void acancelationmessageshouldbedisplayed2() {
		Assert.assertTrue(isElementDisplayed(factory.homePage().Returnwassuccessfull));
		logger.info("user should see the message");
		slowDown();	
	}
	@And("User click on Review button")
	public void UserclickonReviewbutton() {
		click(factory.homePage().reviewBtn);
		logger.info("user click at the reviewBtn ");
		slowDown();
	}
	@When("User write Review headline {string} and {string}")
	public void UserwriteReviewheadlineand(String headline,String review) {
		sendText(factory.homePage().headlineInput, headline);
		slowDown();
		sendText(factory.homePage().descriptionInput, review);
		logger.info("User should fill out the informatin");
		slowDown();
	}
	@And("User click Add your Review button")
	public void UserclickAddyourReviewbutton() {
		click(factory.homePage().reviewSubmitBtn);
		logger.info("User click on submit");
		slowDown();
	}
	
	@Then("a review message should be displayed ‘Your review was added successfully’")
	public void areviewmessageshouldbedisplayed() {
		Assert.assertTrue(isElementDisplayed(factory.homePage().Yourreviewwasaddedsuccessfully));
		logger.info("User should see the message");
		slowDown();
	}
}
