# 🚀 AutoVerse

💻 **A Full-Stack Test Automation Framework** for Web, API, Database, and Log Monitoring — powered by **Selenium**, **TestNG**, **REST Assured**, **Docker**, **Selenium Grid**, and **Elastic Stack (Elasticsearch & Kibana)**.

![AutoVerse Demo](docs/demo.gif) <!-- Replace with your actual demo GIF path -->

---

## 🧰 Key Features

- ✅ Web UI Automation with **Selenium + TestNG**
- 🔁 API Testing using **REST Assured**
- 🗃️ Database Validation via **JDBC**
- 📊 Real-Time Log Monitoring with **Elasticsearch & Kibana**
- 🐳 Dockerized Selenium Grid for **Parallel Execution**
- 🔄 CI/CD Ready: **Jenkins & GitHub Actions**
- 📈 Unified Reporting (ExtentReports, HTML, Log4j)
- 🔐 Secure config handling with `.properties`

---

## 🧱 Architecture Overview

```mermaid
graph TD
    LocalMachine[Local Machine / CI Server] --> TestNG
    TestNG --> SeleniumWebDriver[Selenium WebDriver]
    TestNG --> RestAssured[REST Assured]
    TestNG --> JDBC[JDBC]
    SeleniumWebDriver --> WebApp[Web Application]
    RestAssured --> API[REST APIs]
    JDBC --> Database
    TestNG --> LogGen[Log Generator]
    LogGen --> Elasticsearch
    Elasticsearch --> Kibana
    SeleniumWebDriver --> SeleniumGrid[Selenium Grid on Docker]

    TestNGTests[TestNG Test Classes] -->|Calls| PageObjects
    PageObjects -->|Uses| WebElements
    PageObjects --> Utils[Utility Classes]
    PageObjects --> Config[ConfigManager]
    PageObjects --> Actions[Reusable Actions]
    Utils --> Logger[Logging Utility]
    Config --> PropertiesFile[.properties Reader]
    Actions --> WebDriverManager
    WebDriverManager --> DriverFactory
    DriverFactory --> SeleniumGrid[Selenium Grid / Local Driver]

