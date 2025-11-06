# 🧩 Framework

A **modular test automation framework** designed to streamline Selenium-based testing using **Java**, **TestNG**, and **Maven**.  
This project provides a reusable, scalable, and maintainable structure for UI automation — ideal for professional QA engineers and testers who want to accelerate test execution and reporting.

---

## 🚀 Overview

The Framework is built to simplify the setup, execution, and maintenance of automated tests.  
It integrates seamlessly with Selenium WebDriver and TestNG, offering pre-defined configuration management, reporting, and browser handling capabilities.

### ✨ Key Features

- 🧠 **Reusable Base Class** – Centralized browser initialization and configuration loading  
- 🧾 **Configurable Properties** – Flexible configuration via `Config.properties`  
- 📸 **Screenshot Capture** – Automatic screenshot on test failures  
- 🧮 **Extent Reports Integration** – Beautiful HTML reports for every run  
- ⚙️ **TestNG Integration** – Manage test suites and parallel execution easily  
- 🧩 **Modular Structure** – Well-organized project hierarchy for scalability  
- 🔄 **CI/CD Ready** – Compatible with Jenkins and other CI tools  

---

## 📂 Project Structure

```
Framework/
├── src/
│   ├── main/java/
│   │   ├── base/                # Core framework setup and browser initialization
│   │   ├── listeners/           # TestNG listeners (screenshot, report integration)
│   │   ├── utilities/           # Helper and reusable utility classes
│   └── test/java/
│       └── tests/               # Test classes organized by functionality
│
├── screenshot/                  # Failure screenshots
├── test-output/                 # TestNG HTML reports
├── target/                      # Compiled artifacts
├── pom.xml                      # Maven dependencies and build configuration
├── testng.xml                   # Test suite configuration
├── report.html                  # Custom test report output
└── README.md                    # Project documentation
```

---

## ⚙️ Tech Stack

| Category         | Technology Used |
|------------------|-----------------|
| Language         | Java            |
| Build Tool       | Maven           |
| Testing Framework| TestNG          |
| Automation Tool  | Selenium WebDriver |
| Reporting        | Extent Reports  |
| CI/CD            | Jenkins (supported) |

---

## 🧩 Prerequisites

Before running the project, make sure you have:

- **Java 17 or 21** installed  
- **Maven 3.8+** configured in your system PATH  
- **Google Chrome** (or any supported browser)  
- An IDE such as **Eclipse** or **IntelliJ IDEA**

---

## ⚙️ Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/hariharan-16/Framework.git
cd Framework
```

### 2. Install Dependencies
```bash
mvn clean install
```

### 3. Configure the Environment
Open the file:
```
src/main/java/config/Config.properties
```
Set your application URL, browser type, and other runtime configurations:
```properties
browser=chrome
url=https://example.com
```

### 4. Run Tests
You can execute your test suite via:
```bash
mvn test
```
or run a specific suite:
```bash
mvn test -DsuiteXmlFile=testng.xml
```

---

## 🧠 Example Test Flow

1. The Base class reads configurations and launches the selected browser.  
2. Tests execute using TestNG with logging and reporting.  
3. On failure, screenshots are automatically captured and attached to Extent Reports.  
4. Reports are generated in:
   ```
   test-output/
   report.html
   ```

---

## 📊 Reporting

- **Extent Reports** generate detailed HTML output with logs, screenshots, and execution details.  
- Default location:  
  ```
  /test-output/ or /report.html
  ```

---

## 🧱 Continuous Integration (Jenkins)

You can easily integrate this project into Jenkins:

1. In Jenkins, create a new **Freestyle** or **Pipeline** project.  
2. Point the **Git repository URL** to your GitHub link.  
3. Add a **Build Step**:  
   ```bash
   mvn clean test
   ```
4. Post-build: archive `test-output/` and `report.html` as build artifacts.

---

## 🔧 How to Extend

- Add more test cases in `src/test/java/tests/`  
- Create new page object classes under `src/main/java/pages/`  
- Introduce reusable helper methods in `utilities/`  
- Enhance logging and reporting using listeners and TestNG annotations  
- Connect to external test data sources (Excel, JSON, DB)

---

## 🤝 Contribution Guidelines

If you plan to expand this framework:
1. Fork the repository  
2. Create a feature branch  
3. Commit and push your changes  
4. Open a Pull Request  

---

## 🪪 License

Currently not licensed.  
If you plan to make this open-source, consider adding a `LICENSE` file (MIT, Apache 2.0, etc.)

---

## 👨‍💻 Author

**Hariharan R**  
*Software Tester & QA Automation Enthusiast*  
📍 Passionate about building robust testing solutions and exploring innovative automation approaches.

[GitHub Profile](https://github.com/hariharan-16)

---

## 🌟 Acknowledgements

Special thanks to:
- **Selenium** and **TestNG** communities  
- **Extent Reports** for powerful reporting  
- **Open Source QA Ecosystem** for continuous innovation

---

> “Quality is never an accident; it is always the result of intelligent effort.”  
> — *John Ruskin*
