# BuyList Mobile app - Testing Framework

This framework contains basic logic with tests for testing native apps.

## Technologies

* [Java 8](https://duckduckgo.com/?t=ffab&q=Java+8) programming language
* [TestNG](https://testng.org/doc/) test framework
* [Appium](https://appium.io/) test automation framework
* [AssertJ](https://assertj.github.io/doc/) java assertions library
* [Selenium](https://www.selenium.dev/documentation/en/) browser automation library
* [Allure](https://github.com/allure-framework/allure2) reporting tool

## Setup development machine

* Install Java JDK 1.8
* Install Maven 3.6.3 or newer
* Install Appium 1.71.1
* Install Android Studio and Create Emulators

## Project dependencies

This is maven project and therefore maven handles all the dependencies.

**If it happens that you have some errors while compiling the project, and you
are sure your code is correct, try reloading maven dependencies and see if that
solves the problem. If reloading does not help, delete everything from .m2 folder
and try again.**

## Tests execution

### Execute tests from InteliJ IDE

#### Preconditions
* Start Appium server and on 4723 port
* Open Android Emulator

#### - Create a TestNG Debug/Run Configuration
* Test kind: `Suite`
* Suite: provide path to the `debug.xml` file
* VM options: `-ea -Dtestng.dtd.http=true -DdeviceName=emulator-5554`
* Add to test annotiation: `groups = {"Debug"}`

#### - Create a TestNG Run All Tests Configuration
* Test kind: `Suite`
* Suite: provide path to the `testng.xml` file
* VM options: `-ea -Dtestng.dtd.http=true -DdeviceName=emulator-5554`

## Test results

Allure test results are stored in the target/allure-results folder.

To see the results run following command from the terminal:
`allure serve target/allure-results`

---

