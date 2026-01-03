# OrangeHRM Demo Login Automation

Student Name: Shaik Nusrath  
Milestone: 1   

## Project Description
This project automates the login functionality of the OrangeHRM demo application using Selenium WebDriver, TestNG, Maven, and Page Object Model (POM).

## Tech Stack
- Java
- Selenium WebDriver
- TestNG
- Maven
- ChromeDriver

## Framework Design
- Page Object Model (POM)
- BaseTest for browser setup & teardown
- Screenshot capture on test failure
- Maven Surefire Plugin for execution

## Test Cases Automated
1. Valid username & valid password
2. Valid username & invalid password
3. Invalid username & valid password
4. Invalid username & invalid password
5. Empty username
6. Empty password
7. Empty username & empty password
8. Username with spaces
9. Password field masked
10. Login button enabled

## Execution
gitbash
mvn clean test
