**Student Name:** Shaik Nusrath  
**Milestone:** 1  


## Project Overview

This project is an **automated login testing suite** for the OrangeHRM demo site using:

- **Selenium WebDriver** – to interact with the browser  
- **TestNG** – to manage and run test cases  
- **Maven** – for dependency management and build  

The automation tests various login scenarios to ensure the application behaves as expected.

---

## Test Cases Implemented

| #  | Test Case Description                      | Expected Result |
|----|-------------------------------------------|----------------|
| 1  | Correct username, correct password        | Login successful, redirect to dashboard |
| 2  | Correct username, wrong password          | Show error “Invalid credentials” |
| 3  | Wrong username, correct password          | Show error “Invalid credentials” |
| 4  | Wrong username, wrong password            | Show error “Invalid credentials” |
| 5  | Blank username, valid password            | Show error “Username cannot be empty” |
| 6  | Valid username, blank password            | Show error “Password cannot be empty” |
| 7  | Blank username, blank password            | Show error “Username cannot be empty” |
| 8  | special characters in username | Show error / input not accepted |
| 9  | special characters in password | Show error / input not accepted |
| 10 | Locked or disabled user credentials       | Show error “User is locked” |



