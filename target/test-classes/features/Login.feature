Feature: Application  Login

Scenario Outline: Test with positive scenario
Given ititialize the browser with chrome
And navigate to "http://www.qaclickacademy.com/" site
Given click on sing in link in home page to land on sing in page
When User enters <username> and <password> and logs in
Then verify that user sucessfully logged in 

Examples:
|username          |password     |
|Kavitha@gmail.com |123456       |
|savitha@gmail.com |45689        |
  
