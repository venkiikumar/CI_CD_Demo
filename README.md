# Simple Maven Project

A simple Java Maven project with basic calculator functionality and comprehensive test coverage. This project is designed to demonstrate CI/CD practices and can be executed both locally and in Jenkins.

## Project Structure

```
POC_CI_CD/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── example/
│   │               └── Calculator.java
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── CalculatorTest.java
├── .github/
│   └── copilot-instructions.md
├── pom.xml
└── README.md
```

## Features

- **Calculator Class**: Basic arithmetic operations (add, subtract, multiply, divide)
- **Comprehensive Tests**: JUnit 5 test cases covering all functionality
- **Maven Build**: Standard Maven project structure with proper dependencies
- **CI/CD Ready**: Configured for both local development and Jenkins execution

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher

## Running Tests Locally

### Using Maven Command Line

1. **Run all tests:**
   ```bash
   mvn test
   ```

2. **Run a specific test class:**
   ```bash
   mvn test -Dtest=CalculatorTest
   ```

3. **Run tests with detailed output:**
   ```bash
   mvn test -Dtest=CalculatorTest -Dmaven.test.redirectTestOutputToFile=false
   ```

### Using VS Code

1. Open the project in VS Code
2. Install the "Extension Pack for Java" if not already installed
3. Use the Testing view or run tests directly from the editor

## Building the Project

1. **Compile the project:**
   ```bash
   mvn compile
   ```

2. **Package the project:**
   ```bash
   mvn package
   ```

3. **Clean and rebuild:**
   ```bash
   mvn clean package
   ```

## Jenkins Integration

### Jenkinsfile Example

Create a `Jenkinsfile` in the project root for Jenkins pipeline:

```groovy
pipeline {
    agent any
    
    tools {
        maven 'Maven-3.9'
        jdk 'JDK-11'
    }
    
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'your-repository-url'
            }
        }
        
        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        
        stage('Package') {
            steps {
                bat 'mvn package'
            }
            post {
                success {
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }
    }
}
```

### Jenkins Setup Steps

1. **Create a new Pipeline job** in Jenkins
2. **Configure SCM** to point to your repository
3. **Set up Maven and JDK tools** in Jenkins Global Tool Configuration
4. **Run the pipeline** to execute tests and build

## Test Reports

After running tests, you can find:
- **Surefire reports**: `target/surefire-reports/`
- **JUnit XML reports**: `target/surefire-reports/TEST-*.xml`

## Development

To add new functionality:

1. **Add new methods** to the `Calculator` class
2. **Write corresponding tests** in `CalculatorTest`
3. **Run tests locally** to ensure everything works
4. **Commit and push** to trigger Jenkins build

## Troubleshooting

### Common Issues

1. **Java version mismatch**: Ensure Java 11+ is installed and JAVA_HOME is set
2. **Maven not found**: Install Maven and add to PATH
3. **Test failures**: Check test output for specific error details

### Useful Maven Commands

- `mvn dependency:tree` - Show project dependencies
- `mvn help:effective-pom` - Display the effective POM
- `mvn clean` - Clean build artifacts
- `mvn verify` - Run integration tests
