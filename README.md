# 🚀 Selenium Advanced Framework

## 📌 Overview
This project is a robust Selenium-based test automation framework designed for advanced web application testing. It leverages Java, TestNG, and Maven, and supports features like data-driven testing, custom reporting, and modular page object design.

## ✨ Features
- 📂 Page Object Model (POM) for maintainable test structure  
- 📊 Data-Driven Testing using external data sources  
- 📄 Custom HTML Reporting with screenshots  
- ⚙️ TestNG Integration (parallel execution, grouping, configuration)  
- ♻️ Reusable Utility Classes for common operations  

## 🗂️ Project Structure
```

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

````

## ⚡ Setup Instructions

### 🔧 Prerequisites
- ☕ Java JDK 8 or above  
- 📦 Maven  
- 🌐 ChromeDriver or other browser drivers  

### 📥 Clone the Repository
```bash
git clone <repo-url>
````

### 📦 Install Dependencies

```bash
mvn clean install
```

### ⚙️ Configure TestNG

Update `testng.xml` to define test suites, groups, and parameters.

### 📊 Add Test Data

Place test data files inside the `data/` directory.

## ▶️ Running Tests

### 🧪 Using Maven

```bash
mvn test
```

### ⚙️ Using TestNG XML

```bash
mvn test -DsuiteXmlFile=testng.xml
```

## 📄 Reports

* 📊 HTML reports generated in:

  * `reports/`
  * `test-output/`
* 📸 Screenshots for failed tests stored in `images/` folder

## 🧩 Key Classes

* 🔐 `LoginPage.java` → Handles login functionality
* 📊 `DataLibrary.java` → Manages test data
* 📄 `Reporter.java` → Custom reporting logic
* 📍 `Locator.java` → Centralized locators

## 🎯 Customization

* ➕ Add new Page Classes in `pages/`
* 🧪 Add Test Cases in `testcases/`
* 🔧 Extend utilities in `utils/`

## 🛠️ Troubleshooting

* ⚠️ Ensure browser drivers are configured and added to PATH
* 📦 Verify dependencies in `pom.xml`
* 📄 Check logs and reports for failure details

## 📜 License

Add your license here (MIT / Apache 2.0)

## 👤 Author

Add your name and contact details

## 🏗️ Architecture Diagram

<img width="2967" height="724" alt="mermaid-diagram" src="https://github.com/user-attachments/assets/267d3113-08fc-462d-91f6-f5475bb68241" />


graph TD
   A[User/TestNG] --> B[Main Test Runner]
   B --> C[Page Objects]
   C --> D[Locators]
   B --> E[Utils]
   B --> F[Reporter]
   B --> G[DataLibrary]
   B --> H[Selenium API]
   F --> I[Reports/Images]
   G --> J[Data Files]
   B --> K[Target/Test Output]
   K --> L[HTML Reports]
   K --> M[JUnit Reports]
   K --> N[Logs]
   B --> O[Browser Drivers]
   O --> P[Web Browser]

📝 Notes

This framework follows industry best practices and is suitable for scalable and maintainable automation projects.
