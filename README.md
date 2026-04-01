🚀 Selenium Advanced Framework
📌 Overview

This project is a robust Selenium-based test automation framework designed for advanced web application testing. It leverages Java, TestNG, and Maven, and supports features like data-driven testing, custom reporting, and modular page object design.

✨ Features
📂 Page Object Model (POM): Organized page classes for maintainable tests
📊 Data-Driven Testing: Uses external data sources for flexible test scenarios
📄 Custom Reporting: Generates detailed HTML reports with screenshots
⚙️ TestNG Integration: Supports parallel execution, grouping, and configuration
♻️ Reusable Utilities: Helper classes for reporting, data handling, and locators
🗂️ Project Structure
pom.xml                # ⚙️ Maven build configuration
testng.xml             # 🧪 TestNG suite configuration
data/                  # 📊 Test data files
reports/               # 📄 Generated test reports
src/
  main/java/com/leafBot/
    locators/          # 📍 Locator definitions
    pages/             # 📄 Page object classes
    selenium/api/      # 🔧 Selenium API wrappers
    testcases/         # 🧪 Test case implementations
    testng/            # ⚙️ TestNG customizations
    utils/             # 🧰 Utility classes
  test/java/           # 🧪 Test source files
target/                # 📦 Build output
⚡ Setup Instructions
🔧 Prerequisites
☕ Java JDK 8 or above
📦 Maven
🌐 ChromeDriver / other browser drivers
📥 Clone the Repository
git clone <repo-url>
📦 Install Dependencies
mvn clean install
⚙️ Configure TestNG

Edit testng.xml to specify test suites, groups, and parameters

📊 Add Test Data

Place your data files in the data/ directory

▶️ Running Tests
🧪 Via Maven
mvn test
⚙️ Via TestNG
mvn test -DsuiteXmlFile=testng.xml
📄 Reports
📊 HTML reports → reports/ and test-output/
📸 Screenshots → images/ folder (for failures)
🧩 Key Classes
🔐 LoginPage.java → Login page actions
📊 DataLibrary.java → Test data handling
📄 Reporter.java → Custom reporting
📍 Locator.java → Centralized locators
🎯 Customization
➕ Add pages → pages/
🧪 Add tests → testcases/
🔧 Extend utilities → utils/
🛠️ Troubleshooting
⚠️ Check browser driver compatibility
📦 Verify dependencies in pom.xml
📄 Review logs in reports/ and test-output/

👤 Author

Vinothkumar-SV

🏗️ Architecture Diagram

<img width="2967" height="724" alt="image" src="https://github.com/user-attachments/assets/183a540e-6a39-4732-85d0-096954f9f430" />

