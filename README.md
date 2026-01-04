# 🚀 Selenium Web Automation Framework

This repository contains a **complete Selenium Web Automation Framework** implemented in Java, built using **Maven, TestNG, WebDriver & best-practice automation architecture**.

It enables scalable and maintainable automated web testing with logging, reporting, configuration management, and reusable utilities.

---

## 🔍 Table of Contents

1. ⭐ About the Project  
2. 🚀 Features  
3. 🧱 Folder Structure  
4. 🛠 Tech Stack  
5. 🎯 Prerequisites  
6. 🚀 Setup & Installation  
7. 🧪 Running Tests  
8. 📊 Reports & Logs  
9. 💡 Framework Design  
10. 📘 Example Usage  
11. 🔧 Configuration  
12. 🤝 Contributing  
13. 📄 License  
14. 📬 Contact

---

## ⭐ About the Project

This is a **Web UI automation framework** that uses **Selenium WebDriver** to automate web applications.  
The framework is structured for clarity and extendibility and includes support for logging, reporting, configuration management, screenshots, and more.

It is built to help testers and engineers quickly write stable automated UI tests with minimal setup.

---

## 🚀 Features

✔ Selenium WebDriver integration  
✔ TestNG orchestration & test suites  
✔ Maven project with dependency management  
✔ Configurable browser launch setup  
✔ Logging via Log4j  
✔ Detailed test reports (HTML)  
✔ Screenshots capture for failures  
✔ Reusable utilities & helpers  
✔ Supports parallel test execution  

---

## 🧱 Folder Structure

Selenium_FrameWork_Web/
├── .settings/ # IDE settings
├── Configuration/ # Config files (e.g., environment, browser)
├── Drivers/ # Driver executables (chromedriver, geckodriver)
├── Screenshots/ # Test screenshots (on fail/pass)
├── logs/ # Log files
├── src/
│ ├── main/java/ # Core utilities & framework logic
│ └── test/java/ # Test classes
├── target/ # Maven build output
├── test-output/ # TestNG output
├── test-reports/ # Test report files
├── pom.xml # Maven dependencies & build
├── TestNG.xml # TestNG suite file
├── extent-config.xml # Test report configuration
├── log4j.properties # Logging configuration
└── README.md # This file


---

## 🛠 Tech Stack

- **Language:** Java  
- **Automation:** Selenium WebDriver  
- **Test Execution:** TestNG  
- **Build Tool:** Maven  
- **Logging:** Log4j  
- **Reporting:** HTML / Extent Reports  
- **Version Control:** Git / GitHub

---

## 🎯 Prerequisites

Before running tests, ensure the following are installed:

- **Java 8+ / OpenJDK 11+**
- **Maven 3.6+**
- IDE like **IntelliJ IDEA** or **Eclipse**
- Browser drivers (ChromeDriver, GeckoDriver, etc.)

---

## 🚀 Setup & Installation

1. **Clone the Repo**

```bash
git clone https://github.com/ProfessionalTiger/Selenium_FrameWork_Web.git
cd Selenium_FrameWork_Web

2. **Build the Project**
mvn clean install

Running Tests
▶ From Command Line
mvn test -DsuiteXmlFile=TestNG.xml

💡 Framework Design
📌 Config Management

All environment, browser, and data settings are kept in the Configuration/ directory. This allows easy switching between environments and browsers.

📌 Logging

The framework uses Log4j configuration (log4j.properties) to log test steps, errors, and important diagnostic information.

📌 Reporting

TestNG integrates with Extent Reports to provide rich, interactive HTML reports.

Reports include screenshots captured at failure.

📌 Error Handling

Screenshots are automatically taken on test failure.
Logs provide structured and timestamped execution details.

🔧 Configuration
File	Purpose
pom.xml	Manage dependencies & build plugins
TestNG.xml	Defines suites & test execution flow
log4j.properties	Logging behavior & levels
extent-config.xml	Test report layout

