package org.calci.stepdefnition;

import org.calci.helper.BaseClass;
import org.calci.pages.TestHomeloan;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Stepdef extends BaseClass {

	@Given("User is on the amz calculator page")
	public void user_is_on_the_amz_calculator_page() throws Exception {
		launchURL("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
	}

	@When("user should enter valid {string} {string} {string} {string} {string} {string} {string} {string} {string} details")
	public void user_should_enter_valid_details(String string, String string2, String string3, String string4,
			String string5, String string6, String string7, String string8, String string9) throws Throwable {

		TestHomeloan th = new TestHomeloan();
		if (string.equals("single")) {
			elementClick(th.getAppicationTypeSingle());
		} else {
			elementClick(th.getAppicationTypeJoint());
		}

		selectDropDown(th.getNumberOfDependents(), "visibletext", string2);
		elementClick(th.getHomeToLiveInBorrowType());

		elementSendKeys(th.getTxtBoxAnnualIncome(), string3);

		elementSendKeys(th.getTxtBoxOtherAnnualIncome(), string4);

		elementSendKeys(th.getTxtBoxMonthlyLivingExpenses(), string5);

		elementSendKeys(th.getTxtBoxCurrentHomeLoanMonthlyRepayments(), string6);

		elementSendKeys(th.getMonthlyOtherLoanRepayment(), "10");
		elementSendKeys(th.getTxtBoxOtherMonthlyCommitments(), string8);

		elementSendKeys(th.getTxtBoxTotalCreditCardLimits(), string9);

	}

	@When("User should click how much could borrow button")
	public void user_should_click_how_much_could_borrow_button() throws Exception {
		TestHomeloan th = new TestHomeloan();
		elementClick(th.getBorrowBtnCal());
		Thread.sleep(10000);
	}

	@Then("User should validate the {string} as Expected")
	public void user_should_validate_the_as_expected(String string) {
		TestHomeloan th = new TestHomeloan();
		org.junit.Assert.assertEquals(th.getBorrowResultTextAmount().getText(), string);
	}

	@Then("User should see error message in negative inputs")
	public void user_should_see_error_message_in_negative_inputs() {
		TestHomeloan th = new TestHomeloan();
		org.junit.Assert.assertTrue(th.getBorrowErrorText().isDisplayed());
	}

}
