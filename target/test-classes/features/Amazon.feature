Feature: Compare iPhone price between Amazon and Flipkart

Scenario: Validate price difference
Given user launches browser
When user searches iPhone XR 64GB Yellow in Amazon
And user captures price from Amazon
And user searches iPhone XR 64GB Yellow in Flipkart
And user captures price from Flipkart
Then user compares both prices


Scenario: Invalid price comparison due to wrong price capture
Given user launches browser
When user searches iPhone in Amazon
And user captures incorrect price element
And user searches iPhone in Flipkart
And user captures correct price
Then comparison result should be invalid