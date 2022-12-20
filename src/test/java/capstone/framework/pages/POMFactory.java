package capstone.framework.pages;

import java.util.List;
import java.util.Map;

import capstone.framework.base.BaseStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;


public class POMFactory extends BaseStep {

	private RetailHomePage homePage;
	private SignInFeature signInPage;


	public POMFactory() {
		this.homePage = new RetailHomePage();
		this.signInPage = new SignInFeature();
		
	}

	public RetailHomePage homePage() {
		return this.homePage;

	}

	public SignInFeature signInPage() {
		return this.signInPage;

	}
	

}
