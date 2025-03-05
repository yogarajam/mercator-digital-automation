# mercator-digital-automation

Mercator Digital Pre-Interview Automation Framework Documentation
Overview
This framework automates the following steps on https://www.saucedemo.com:

Navigate to https://www.saucedemo.com.
Log in with username standard_user and password secret_sauce.
Select the highest-priced item (without using the "Sort By" option).
Add the selected highest-priced item to the cart.
It’s designed to be simple, maintainable, and extensible, using:

Java 1.8 as the programming language.
Selenium WebDriver with WebDriverManager for browser automation (Chrome by default, extensible to other browsers).
JUnit for test execution and assertions.
The framework uses the Page Object Model (POM) pattern for maintainability and follows best practices for QA automation.

Prerequisites
Java 1.8 (JDK 8, also known as Java SE 8).
Maven for dependency management.
IDE (e.g., IntelliJ IDEA, Eclipse).
Internet connection (for WebDriverManager to download ChromeDriver).
Chrome browser installed on the machine (WebDriverManager handles the driver).

mercator-digital-automation/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/mercator/digital/
│   │   │   │   ├── config/              # Configuration and DriverManager setup
│   │   │   │   ├── pages/              # Page Object classes
│   │   │   │   └── util/               # Utilities
│   │   └── resources/
│   │       └── config.properties       # Configuration settings
│   └── test/
│       ├── java/
│       │   ├── com/mercator/digital/
│       │   │   └── tests/              # JUnit test cases
│       └── resources/
├── pom.xml                             # Maven configuration
└── README.md                           # This documentation

Setup
1. Clone this repository or create a new Maven project with the structure above.
2. Add the `pom.xml` dependencies and update `config.properties` if needed.
3. Ensure JDK 1.8 is configured in your IDE or system.
4. Run `mvn clean install` to download dependencies.

Running Tests
- Use your IDE to run `SauceDemoTest.java` as a JUnit test.
- Alternatively, run `mvn test` from the command line.
- The test runs on Chrome by default; change `browser.type` in `config.properties` to `firefox` or `edge` to test with other browsers.


