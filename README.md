# 🧮 Personal Calculator

A modern, sleek JavaFX-based desktop calculator application. This project features a fully functional calculator with a beautiful dark theme, intuitive user interface, and smooth interactive elements like hover effects and drop shadows.

---

## ✨ Features

- **Basic Arithmetic Operations**: Addition (+), Subtraction (-), Multiplication (×), and Division (÷)
- **Advanced Operations**: Percentage calculation (%) and Sign toggle (±)
- **Smart Input Handling**: Decimal number support, backspace functionality (⌫), and prevention of invalid inputs (e.g., multiple decimal points)
- **Chained Operations**: Supports continuous calculations (e.g., `5 + 3 - 2 =`)
- **Error Handling**: Graceful division by zero error handling
- **Modern UI/UX**:
  - Deep dark theme with card-style containers and subtle drop shadows
  - Custom styled buttons with visual feedback (hover, click, and press states)
  - Interactive "Identity Pane" featuring a circular profile photo mask with glowing effects
  - Clean `Consolas` font for mathematical expressions

---

## 🛠️ Tech Stack

- **Language**: Java 25
- **UI Framework**: JavaFX
- **Build Tool**: Maven

---

## 🚀 Getting Started

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

---

## 📁 Project Structure

```text
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

---

## 📝 Key Highlights for Code Quality
- **Clean Code Architecture**: UI creation is broken down into modular methods (`createIdentityPane`, `createCalculatorPane`, `createButtonGrid`).
- **Scalable Event Handling**: Centralized event dispatcher routing clicks to specific helper methods (`handleNumber`, `handleOperator`, `handleEquals`).
- **Comprehensive Documentation**: JavaDoc comments for all classes, fields, and UI construction methods.

---

## 🤝 Contributing
Contributions, issues, and feature requests are welcome!

## 📄 License
This project is open-source and available under the MIT License.
