Feature: Verifying the anz personal home loan calculators


Scenario Outline: Verifying the anz borrow amount with valid inputs
Given User is on the amz calculator page
When user should enter valid "<AppicationType>" "<dependants>" "<with income of>" "<other Income>" "<living Expenses>" "<Current home loan repayment>" "<Other loan repayments>" "<Other Commitments>" "<total credit card limits>" details
And User should click how much could borrow button
Then User should validate the "<borrowing estimate>" as Expected 

Examples:

|AppicationType|dependants|with income of|other Income|living Expenses|Current home loan repayment|Other loan repayments|Other Commitments|total credit card limits|borrowing estimate|
|single 	       |0       |$80,000       |$10,000     |$500            |$ 0                       |$ 100            | $ 0              |        $ 10,000        |  $ 479,000      |


Scenario Outline:Verifying the Error message with negative inputs
Given User is on the amz calculator page
When user should enter valid "<AppicationType>" "<dependants>" "<with income of>" "<other Income>" "<living Expenses>" "<Current home loan repayment>" "<Other loan repayments>" "<Other Commitments>" "<total credit card limits>" details
And User should click how much could borrow button
Then User should see error message in negative inputs 

Examples:
|AppicationType|dependants|with income of|other Income|living Expenses|Current home loan repayment|Other loan repayments|Other Commitments|total credit card limits|
|single 	       |0         |$0	    |$0          | $1            |$ 0                       |$ 0                   | $ 0              |        $0           | 

