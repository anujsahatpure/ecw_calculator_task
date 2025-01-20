# Basic Calculator Project

This is a simple calculator application built using Java and Gradle. It performs basic arithmetic operations such as addition, subtraction, multiplication, and division. The calculator takes user input for two numbers and an operation choice, then displays the result.

## Features

- **Basic Arithmetic Operations**
  - Addition (+)
  - Subtraction (-)
  - Multiplication (*)
  - Division (/)
- Input validation and error handling
- JUnit test coverage
- SonarQube integration for code quality analysis
- Jenkins pipeline integration

## Prerequisites

Before running the project, ensure you have the following tools installed:

- **Java 17** (as configured in `build.gradle`)
- **Gradle** (for building and running the project)
- **SonarQube** (for code quality analysis)
- **Jenkins** (for CI/CD pipeline)

## Project Structure

```
calculator-project/
├── src/
│   ├── main/java/com/calculator/
│   │   └── Calculator.java
│   └── test/java/com/calculator/
│       └── CalculatorTest.java
├── build.gradle
├── Jenkinsfile
└── README.md
```

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/anujsahatpure/ecw_calculator_task.git
cd calculator-project
```

### 2. Build the Project

```bash
gradle clean build
```

### 3. Run Tests

```bash
gradle test
```

### 4. Generate Code Coverage Report

```bash
gradle jacocoTestReport
```

The coverage report will be available at: `build/reports/jacoco/test/html/index.html`

### 5. Run SonarQube Analysis

```bash
gradle sonarqube \
    -Dsonar.projectKey=Java-Calculator-Task \
    -Dsonar.token=your_sonar_token
```

### 6. Run the Calculator

You can run the calculator using the custom Gradle task with arguments:

```bash
gradle calculatorTask -Pnum1=10 -Pnum2=5 -Poperator=+
```

Replace the values for:
- `num1`: First number
- `num2`: Second number
- `operator`: One of +, -, *, /

## Jenkins Pipeline

The project includes a Jenkins pipeline configuration (`Jenkinsfile`) that:
1. Builds the project
2. Runs tests
3. Performs SonarQube analysis
4. Archives build artifacts
5. Runs a sample calculator operation
