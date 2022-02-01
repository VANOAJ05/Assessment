package org.calci.pages;

import org.calci.helper.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestHomeloan extends BaseClass {
	
	public TestHomeloan() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="application_type_joint")
    private WebElement appicationTypeJoint;

    @FindBy(id="application_type_single")
    private WebElement appicationTypeSingle;

    @FindBy(xpath="//select[@title='Number of dependants']")
    private WebElement numberOfDependents;

    @FindBy(id="borrow_type_home")
    private WebElement homeToLiveInBorrowType;

    @FindBy(id="borrow_type_investment")
    private WebElement residentialInvestmentType;

    @FindBy(xpath="//input[@aria-describedby='q2q1i1 q2q1i2']")
    private WebElement txtBoxAnnualIncome;

    @FindBy(xpath="//input[@aria-describedby='q2q2i1 q2q2i2']")
    private WebElement txtBoxOtherAnnualIncome;

    @FindBy(id="expenses")
    private WebElement txtBoxMonthlyLivingExpenses;

    @FindBy(id="homeloans")
    private WebElement txtBoxCurrentHomeLoanMonthlyRepayments;

    @FindBy(id="otherloans")
    private WebElement txtBoxOtherMonthlyCommitments;

    @FindBy(id="credit")
    private WebElement txtBoxTotalCreditCardLimits;

    @FindBy(id="btnBorrowCalculater")
    private WebElement btnBorrowCalculator;

    @FindBy(id="borrowResultTextAmount")
    private WebElement resultAmount;

    @FindBy(xpath="(//button[@aria-label='Start over'])[1]")
    private WebElement btnStartOver;

    @FindBy(xpath="//div[@class='borrow__error__text']")
    private WebElement errorText;

    @FindBy(xpath = "//input[@aria-labelledby=\"q3q3\"]")
    private WebElement monthlyOtherLoanRepayment;
    
    public WebElement getMonthlyOtherLoanRepayment() {
		return monthlyOtherLoanRepayment;
	}

	@FindBy(xpath = "//button[@id='btnBorrowCalculater']")
    private WebElement borrowBtnCal;
    
    @FindBy(id="borrowResultTextAmount")
    private WebElement borrowResultTextAmount;
    
    @FindBy(xpath = "//div[@class='borrow__error__text']")
    private WebElement borrowErrorText;
    
    
    public WebElement getBorrowErrorText() {
		return borrowErrorText;
	}

	public WebElement getBorrowResultTextAmount() {
		return borrowResultTextAmount;
	}

	public WebElement getBorrowBtnCal() {
		return borrowBtnCal;
	}

	public WebElement getAppicationTypeJoint() {
        return appicationTypeJoint;
    }

    public WebElement getAppicationTypeSingle() {
        return appicationTypeSingle;
    }

    public WebElement getNumberOfDependents() {
        return numberOfDependents;
    }

    public WebElement getHomeToLiveInBorrowType() {
        return homeToLiveInBorrowType;
    }

    public WebElement getResidentialInvestmentType() {
        return residentialInvestmentType;
    }

    public WebElement getTxtBoxAnnualIncome() {
        return txtBoxAnnualIncome;
    }

    public WebElement getTxtBoxOtherAnnualIncome() {
        return txtBoxOtherAnnualIncome;
    }

    public WebElement getTxtBoxMonthlyLivingExpenses() {
        return txtBoxMonthlyLivingExpenses;
    }

    public WebElement getTxtBoxCurrentHomeLoanMonthlyRepayments() {
        return txtBoxCurrentHomeLoanMonthlyRepayments;
    }

    public WebElement getTxtBoxOtherMonthlyCommitments() {
        return txtBoxOtherMonthlyCommitments;
    }

    public WebElement getTxtBoxTotalCreditCardLimits() {
        return txtBoxTotalCreditCardLimits;
    }

    public WebElement getBtnBorrowCalculator() {
        return btnBorrowCalculator;
    }

    public WebElement getResultAmount() {
        return resultAmount;
    }

    public WebElement getBtnStartOver() {
        return btnStartOver;
    }

    public WebElement getErrorText() {
        return errorText;
    }
}



