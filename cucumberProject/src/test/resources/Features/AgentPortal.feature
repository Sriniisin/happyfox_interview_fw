  @sanityTest
Feature: Feature to check the agent portal
	
	@tag1
  Scenario Outline: Check whether agent is able to create a Status
    Given login to <url> with agent <username> and <password>
    And navigate to Status Page
    When I create a new status with <name>,<behaviour> and <description>
    Then the new status with <name> should be available in the list
    And navigate to Priority Page
    When I create a new priority with <PriorityName> and <PriorityDescription>
    Then the new priority with <PriorityName> should be available in the list
    
    Examples:
    |url|username|password|name|behaviour|description|PriorityName|PriorityDescription|
    |https://interview3.supporthive.com/staff/|Agent|Agent@123|Issue created|Pending|Status when a new ticket is created in HappyFox|Assistance required|Priority of the newly created tickets|
    
	Scenario Outline: Create Ticket and reply for it with Canned Response
		Given login to <url> with agent <username> and <password>
		And navigate to Status Page
		When I make created Status with as default
		And I make created Priority with as default
		And create a new ticket with details <name>, <email>, <subject>, <Message>
		Then check the priority value of the ticket
		And Reply with the canned actions
		
		Examples:
    |url|username|password|name|email|subject|Message|
    |https://interview3.supporthive.com/staff/|Agent|Agent@123|Jhon Wick|jhon@gmail.com|Check Ticket|Sample message|
		
	@tag1
	Scenario Outline: Delete Status, Priority and Logout
		Given login to <url> with agent <username> and <password>
		And navigate to Status Page
		When deletes the created status
		And navigate to Priority Page
		And deletes the created priority
		And Logout from the application
		Then User should be logged out
		
	Examples:
    |url|username|password|
    |https://interview3.supporthive.com/staff/|Agent|Agent@123|