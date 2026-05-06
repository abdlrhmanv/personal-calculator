# Personal Calculator

A modern, sleek JavaFX-based desktop calculator application built with Java 25. This project features a fully functional calculator with a beautiful dark theme, intuitive user interface, and smooth interactive elements like hover effects and drop shadows.

## About Me

I'm Abdlrhman Ismail, a Senior Computer Engineering student at Ain Shams University (ASU). This repository documents my personal project building a polished desktop calculator using JavaFX and Maven.

## Repository Structure

```
PersonalCalculator/
├── src/main/
│   ├── java/com/example/personalcalculator/
│   │   ├── Launcher.java             # Entry point bypassing JavaFX modules check
│   │   └── PersonalCalculator.java   # Main application logic and UI construction
│   └── resources/
│       ├── images/my_photo.jpg       # Profile photo for identity pane
│       └── META-INF/MANIFEST.MF
└── pom.xml                           # Maven configuration
```

## Features

| #   | Feature              | Description                                                           | Status  |
| --- | -------------------- | --------------------------------------------------------------------- | ------- |
| 01  | Basic Arithmetic     | Addition (+), Subtraction (−), Multiplication (×), Division (÷)       | ✅ Done |
| 02  | Advanced Operations  | Percentage calculation (%) and sign toggle (±)                        | ✅ Done |
| 03  | Smart Input Handling | Decimal support, backspace (⌫), prevention of invalid inputs          | ✅ Done |
| 04  | Chained Operations   | Continuous calculations (e.g., `5 + 3 − 2 =`)                         | ✅ Done |
| 05  | Error Handling       | Graceful division by zero handling                                    | ✅ Done |
| 06  | Modern UI/UX         | Dark theme, card-style containers, drop shadows, hover & press states | ✅ Done |
| 07  | Identity Pane        | Circular profile photo mask with glowing effect                       | ✅ Done |

## Tech Stack & Tools

| Category     | Tools                               |
| ------------ | ----------------------------------- |
| Language     | Java 25 ☕                          |
| UI Framework | JavaFX                              |
| Build Tool   | Maven 3.9+                          |
| Font         | Consolas (mathematical expressions) |

## Getting Started

### Prerequisites

- JDK 25 or later
- Maven 3.9+

### Installation & Running

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/personal-calculator.git
   cd personal-calculator
   ```

2. Build and run using Maven:
   ```bash
   mvn clean compile
   mvn javafx:run
   ```

## Key Highlights for Code Quality

- **Clean Code Architecture**: UI creation is broken down into modular methods (`createIdentityPane`, `createCalculatorPane`, `createButtonGrid`)
- **Scalable Event Handling**: Centralized event dispatcher routing clicks to specific helper methods (`handleNumber`, `handleOperator`, `handleEquals`)
- **Comprehensive Documentation**: JavaDoc comments for all classes, fields, and UI construction methods

## Contributing

Contributions, issues, and feature requests are welcome!

## License

This project is open-source and available under the MIT License.

## Contact

Always happy to chat about Software Engineering or UI Design — feel free to reach out!

|             |                                              |
| ----------- | -------------------------------------------- |
| 📧 Email    | abdlrhmanv@icloud.com                        |
| 💼 LinkedIn | [Abdlrhman Ismail](https://linkedin.com)     |
| 🐙 GitHub   | [@abdlrhmanv](https://github.com/abdlrhmanv) |

Made with ❤️ by Abdlrhman Ismail
