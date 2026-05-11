# Selenium WebDriver BDD Test Automation Framework - SauceDemo

This project implements a Behavior-Driven Development (BDD) test automation framework for the SauceDemo web application using Selenium WebDriver, Java, Cucumber, and TestNG, applying design patterns, Page Object Model (POM), and SOLID principles.

The framework supports multi-browser execution, logging, screenshot capturing, environment-based configuration, and Smoke / Regression execution through Cucumber tags.

---

# 🚀 Features

* Selenium WebDriver automation
* Cucumber BDD implementation
* Gherkin feature files
* TestNG test runner
* Page Object Model (POM)
* Design Patterns implementation
* WebDriverManager for driver handling
* Multi-browser support (Chrome & Edge)
* Environment-based configuration (dev / qa)
* Logging with Log4j2 (console + file)
* Screenshot capture on scenario failure
* Smoke & Regression execution using tags
* Parallel execution support
* Externalized configuration via properties files
* Scenario logging with Hooks
* Scenario Outline & Examples support
* Background steps support

---

# 📋 Test Scenarios

✅ Login functionality

Login with empty credentials
* Open login page
* Enter credentials
* Clear fields
* Validate error message
  
Login with username but no password
* Enter username
* Leave password empty
* Validate error message
  
Login with valid credentials
* Login using multiple users with Scenario Outline
* Validate successful navigation to homepage
  
🛒 Cart functionality

* Add product to cart
* Login with valid credentials
* Add product to cart
* Validate cart badge count

💳 Checkout functionality

* Complete checkout process
* Login with valid credentials
* Add product to cart
* Navigate to cart
* Complete checkout form
* Finish purchase
* Validate confirmation message

---

# 🏗️ Project Architecture
```
src
├── main
│   └── java
│       └── com.epam.training.student_ulises_lara
│           ├── decorator
│           │   ├── BaseElementActions.java
│           │   ├── ElementActions.java
│           │   └── LoggingDecorator.java
│           │
│           ├── driver
│           │   ├── DriverSingleton.java
│           │   └── factory
│           │       ├── WebDriverFactory.java
│           │       ├── ChromeDriverFactory.java
│           │       └── EdgeDriverFactory.java
│           │
│           ├── model
│           │   ├── CheckoutData.java
│           │   └── User.java
│           │
│           ├── page
│           │   ├── BasePage.java
│           │   ├── HomePage.java
│           │   └── LoginPage.java
│           │
│           ├── service
│           │   └── TestDataReader.java
│           │
│           └── utils
│               └── ScreenshotUtils.java
│
├── test
│   └── java
│       ├── runners
│       │   └── CucumberTestRunner.java
│       │
│       ├── steps
│       │   ├── LoginSteps.java
│       │   ├── CartSteps.java
│       │   └── CheckoutSteps.java
│       │
│       └── test
│           └── Hooks.java
│
├── resources
│   ├── features
│   │   ├── login.feature
│   │   ├── cart.feature
│   │   └── checkout.feature
│   │
│   ├── dev.properties
│   ├── qa.properties
│   └── log4j2.xml
│
├── testng-smoke.xml
├── testng-regression.xml
├── pom.xml
└── README.md

```

# ⚙️ Configuration

### Environments

The framework supports multiple environments using properties files:

* `dev.properties` → Chrome
* `qa.properties` → Edge

---

# ▶️ How to Run Tests

### Run all tests

```bash
mvn clean test
```

---

### Run Smoke tests

```bash
mvn clean test -DsuiteXmlFile=testng-smoke.xml
```

---

### Run Regression tests

```bash
mvn clean test -DsuiteXmlFile=testng-regression.xml
```

---

### Run with specific environment

```bash
mvn clean test -Denvironment=qa
```

---

---

# 📊 Logging

* Implemented using **Log4j2**
* Logs include:

  * Test start/end
  * Step execution (Page Objects)
  * Validation results
  * Errors

Logs are written to:

* Console
* File (daily logs in `/logs`)

---

# 📸 Screenshots

* Automatically captured on test failure
* Stored in `/screenshots` folder
* Path is logged in test output

---

# 🧪 Test Suites

### Smoke Suite

* Basic functionality
* Fast execution

### Regression Suite

* Full test coverage
* Includes checkout flow

---

# 🧠 Design Patterns Used

* Page Object Model (POM)
* Singleton (Driver management)
* ThreadLocal (parallel execution ready)
* Factory Method (Implemented via WebDriverFactory interface to encapsulate browser creation logic and support extensibility without modifying existing code)
* Decorator (Implemented via ElementActions interface to enhance element interactions with logging and highlighting without modifying base functionality)
* Builder (Implemented in CheckoutData to provide a flexible and readable way to create test data objects)

---

# 👨‍💻 Author

- Student: Ulises Lara
- Program: EPAM Java Automation Specialization
- Project: Module 13 BDD TA Frameworks
