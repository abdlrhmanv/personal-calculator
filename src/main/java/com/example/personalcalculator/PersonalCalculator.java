package com.example.personalcalculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * PersonalCalculator - A modern JavaFX-based calculator application.
 * <p>
 * This application provides a fully functional calculator with a sleek,
 * modern dark theme user interface. It supports basic arithmetic operations
 * including addition, subtraction, multiplication, and division, along with
 * additional features such as percentage calculation, sign toggle, and backspace.
 * </p>
 *
 * <h2>Features:</h2>
 * <ul>
 *   <li>Basic arithmetic operations (+, -, ×, ÷)</li>
 *   <li>Percentage calculation</li>
 *   <li>Sign toggle (positive/negative)</li>
 *   <li>Decimal number support</li>
 *   <li>Backspace functionality</li>
 *   <li>Chained operations support</li>
 *   <li>Division by zero error handling</li>
 * </ul>
 *
 * @author Abdlrhman Hisham Ismail
 * @version 1.0
 * @since 202
 */
public class PersonalCalculator extends Application {

    // ==================== UI COMPONENTS ====================
    
    /** Text field displaying the current input/result */
    private TextField displayField;
    
    /** Label showing the current expression (e.g., "5 + 3 =") */
    private Label expressionLabel;

    // ==================== CALCULATOR STATE ====================
    
    /** First operand stored for binary operations */
    private double num1 = 0;
    
    /** Current operator being applied (+, -, *, /) */
    private String operator = "";
    
    /** Flag indicating whether the next digit should start a new number */
    private boolean startNewInput = true;
    
    /** Flag tracking if current number already contains a decimal point */
    private boolean hasDecimal = false;

    // ==================== THEME CONSTANTS ====================
    
    /** Primary background color - Darkest blue/black */
    private static final String BG_DARK = "#000000";
    
    /** Card/container background color - Very dark blue */
    private static final String BG_CARD = "#142f44";
    
    /** Primary accent color - Dark blue */
    private static final String ACCENT_PRIMARY = "#1d3849";
    
    /** Highlight accent color - Medium blue */
    private static final String ACCENT_HIGHLIGHT = "#205b7a";
    
    /** Primary text color - Light grayish blue */
    private static final String TEXT_PRIMARY = "#a2bbcf";
    
    /** Secondary text color - Muted blue */
    private static final String TEXT_SECONDARY = "#a2bbcf";
    
    /** Number button background color - Dark blue */
    private static final String BTN_NUMBER = "#1d3849";
    
    /** Operator button background color - Medium blue */
    private static final String BTN_OPERATOR = "#205b7a";
    
    /** Function button background color - Very dark blue */
    private static final String BTN_FUNCTION = "#142f44";
    
    /** Equals button background color - Light blue */
    private static final String BTN_EQUALS = "#a2bbcf";

    // ==================== APPLICATION LIFECYCLE ====================

    /**
     * The main entry point for the JavaFX application.
     * <p>
     * Initializes and displays the calculator window with the identity
     * pane at the top and the calculator pane in the center.
     * </p>
     *
     * @param stage The primary stage for this application
     */
    @Override
    public void start(Stage stage) {
        // Create root layout container
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: " + BG_DARK + ";");

        // Add identity/header section at the top
        VBox identityPane = createIdentityPane();
        root.setTop(identityPane);

        // Add calculator section in the center
        VBox calculatorPane = createCalculatorPane();
        root.setCenter(calculatorPane);
        BorderPane.setMargin(calculatorPane, new Insets(20, 0, 0, 0));

        // Configure and display the scene
        Scene scene = new Scene(root, 380, 680);
        stage.setTitle("Personal Calculator");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // ==================== UI CREATION METHODS ====================

    /**
     * Creates the identity/header pane displaying personal information.
     * <p>
     * This pane includes a profile photo (circular with glow effect)
     * and personal details such as name and student ID.
     * </p>
     *
     * @return VBox containing the identity card layout
     */
    private VBox createIdentityPane() {
        VBox container = new VBox(0);
        container.setAlignment(Pos.CENTER);

        // Create horizontal layout for image and text
        HBox hbox = new HBox(20);
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.setPadding(new Insets(20));
        hbox.setStyle(
                "-fx-background-color: " + BG_CARD + ";" +
                "-fx-background-radius: 16;"
        );

        // Apply drop shadow effect to the card
        hbox.setEffect(createCardDropShadow());

        // Configure profile image with circular clip
        ImageView imageView = new ImageView();
        try {
            Image image = new Image(Objects.requireNonNull(
                    getClass().getResourceAsStream("/images/my_photo.jpg")));
            imageView.setImage(image);
            imageView.setFitHeight(90);
            imageView.setFitWidth(90);
            imageView.setPreserveRatio(true);

            // Apply circular clipping mask
            javafx.scene.shape.Circle clip = new javafx.scene.shape.Circle(45, 45, 45);
            imageView.setClip(clip);

            // Add colored glow effect around the image
            DropShadow imgShadow = new DropShadow();
            imgShadow.setColor(Color.web(ACCENT_HIGHLIGHT, 0.5));
            imgShadow.setRadius(10);
            imageView.setEffect(imgShadow);
        } catch (Exception e) {
            System.out.println("Image not found: " + e.getMessage());
        }

        // Create information labels container
        VBox infoBox = new VBox(8);
        
        Label nameLabel = new Label("Abdlrhman Hisham Ismail");
        nameLabel.setTextFill(Color.web(TEXT_PRIMARY));
        nameLabel.setFont(Font.font("Segoe UI", FontWeight.BOLD, 18));

        Label idLabel = new Label("ID: 2300343");
        idLabel.setTextFill(Color.web(TEXT_SECONDARY));
        idLabel.setFont(Font.font("Segoe UI", FontWeight.NORMAL, 14));

        Label titleLabel = new Label("Personal Calculator");
        titleLabel.setTextFill(Color.web(ACCENT_HIGHLIGHT));
        titleLabel.setFont(Font.font("Segoe UI", FontWeight.SEMI_BOLD, 12));

        infoBox.getChildren().addAll(titleLabel, nameLabel, idLabel);
        infoBox.setAlignment(Pos.CENTER_LEFT);

        hbox.getChildren().addAll(imageView, infoBox);
        container.getChildren().add(hbox);
        return container;
    }

    /**
     * Creates the main calculator pane containing the display and button grid.
     * <p>
     * The calculator pane includes:
     * <ul>
     *   <li>Expression label showing the current operation</li>
     *   <li>Display field showing the current number/result</li>
     *   <li>Grid of calculator buttons</li>
     * </ul>
     * </p>
     *
     * @return VBox containing the complete calculator interface
     */
    private VBox createCalculatorPane() {
        VBox vbox = new VBox(15);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        vbox.setStyle(
                "-fx-background-color: " + BG_CARD + ";" +
                "-fx-background-radius: 16;"
        );

        // Apply drop shadow effect to the calculator card
        vbox.setEffect(createCardDropShadow());

        // Configure expression label (shows operation history)
        expressionLabel = new Label("");
        expressionLabel.setTextFill(Color.web(TEXT_SECONDARY));
        expressionLabel.setFont(Font.font("Consolas", 14));
        expressionLabel.setMaxWidth(Double.MAX_VALUE);
        expressionLabel.setAlignment(Pos.CENTER_RIGHT);
        expressionLabel.setPadding(new Insets(0, 10, 0, 0));

        // Configure main display field
        displayField = new TextField("0");
        displayField.setEditable(false);
        displayField.setPrefHeight(70);
        displayField.setFont(Font.font("Consolas", FontWeight.BOLD, 36));
        displayField.setAlignment(Pos.CENTER_RIGHT);
        displayField.setStyle(
                "-fx-background-color: " + ACCENT_PRIMARY + ";" +
                "-fx-text-fill: " + TEXT_PRIMARY + ";" +
                "-fx-background-radius: 12;" +
                "-fx-border-radius: 12;" +
                "-fx-padding: 10 15;"
        );

        // Create button grid
        GridPane grid = createButtonGrid();

        vbox.getChildren().addAll(expressionLabel, displayField, grid);
        return vbox;
    }

    /**
     * Creates and configures the grid of calculator buttons.
     * <p>
     * Button types and their corresponding colors:
     * <ul>
     *   <li>"num" - Number buttons (0-9, .)</li>
     *   <li>"op" - Operator buttons (+, -, *, /)</li>
     *   <li>"func" - Function buttons (⌫, %, ±)</li>
     *   <li>"eq" - Equals button</li>
     *   <li>"clear" - Clear button (C)</li>
     * </ul>
     * </p>
     *
     * @return GridPane containing all calculator buttons
     */
    private GridPane createButtonGrid() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(15, 0, 0, 0));

        // Button layout definition: [buttonText, buttonType, ...]
        String[][] buttons = {
                {"C", "clear", "⌫", "func", "%", "func", "/", "op"},
                {"7", "num", "8", "num", "9", "num", "*", "op"},
                {"4", "num", "5", "num", "6", "num", "-", "op"},
                {"1", "num", "2", "num", "3", "num", "+", "op"},
                {"±", "func", "0", "num", ".", "num", "=", "eq"}
        };

        // Iterate through button definitions and add to grid
        for (int row = 0; row < buttons.length; row++) {
            for (int col = 0; col < buttons[row].length; col += 2) {
                String text = buttons[row][col];
                String type = buttons[row][col + 1];
                Button btn = createStyledButton(text, type);
                grid.add(btn, col / 2, row);
            }
        }

        return grid;
    }

    /**
     * Creates a styled calculator button with hover and press effects.
     * <p>
     * Each button type has distinct styling:
     * <ul>
     *   <li>Number buttons: Dark blue background</li>
     *   <li>Operator buttons: Pink/red background</li>
     *   <li>Function buttons: Navy blue background</li>
     *   <li>Equals button: Green background</li>
     *   <li>Clear button: Pink/red background (highlighted)</li>
     * </ul>
     * </p>
     *
     * @param text The text to display on the button
     * @param type The button type ("num", "op", "func", "eq", "clear")
     * @return Fully styled and configured Button instance
     */
    private Button createStyledButton(String text, String type) {
        Button btn = new Button(text);
        btn.setPrefSize(70, 60);
        btn.setFont(Font.font("Segoe UI", FontWeight.SEMI_BOLD, 20));

        // Determine colors based on button type
        String bgColor;
        String textColor = TEXT_PRIMARY;
        String hoverColor;

        switch (type) {
            case "clear" -> {
                bgColor = ACCENT_HIGHLIGHT;
                hoverColor = "#3a7595";
            }
            case "op" -> {
                bgColor = BTN_OPERATOR;
                hoverColor = "#3a7595";
            }
            case "func" -> {
                bgColor = BTN_FUNCTION;
                hoverColor = "#1d3849";
            }
            case "eq" -> {
                bgColor = BTN_EQUALS;
                textColor = "#000000";
                hoverColor = "#c4d4e2";
            }
            default -> {
                bgColor = BTN_NUMBER;
                hoverColor = "#205b7a";
            }
        }

        // Define button styles for different states
        String baseStyle = String.format(
                "-fx-background-color: %s;" +
                "-fx-text-fill: %s;" +
                "-fx-background-radius: 12;" +
                "-fx-cursor: hand;",
                bgColor, textColor
        );

        String hoverStyle = String.format(
                "-fx-background-color: %s;" +
                "-fx-text-fill: %s;" +
                "-fx-background-radius: 12;" +
                "-fx-cursor: hand;" +
                "-fx-scale-x: 1.05;" +
                "-fx-scale-y: 1.05;",
                hoverColor, textColor
        );

        String pressedStyle = String.format(
                "-fx-background-color: %s;" +
                "-fx-text-fill: %s;" +
                "-fx-background-radius: 12;" +
                "-fx-cursor: hand;" +
                "-fx-scale-x: 0.95;" +
                "-fx-scale-y: 0.95;",
                bgColor, textColor
        );

        // Apply base style
        btn.setStyle(baseStyle);

        // Configure mouse event handlers for visual feedback
        btn.setOnMouseEntered(_ -> btn.setStyle(hoverStyle));
        btn.setOnMouseExited(_ -> btn.setStyle(baseStyle));
        btn.setOnMousePressed(_ -> btn.setStyle(pressedStyle));
        btn.setOnMouseReleased(_ -> btn.setStyle(hoverStyle));

        // Set action handler
        btn.setOnAction(_ -> handleButtonClick(text));

        return btn;
    }

    // ==================== EVENT HANDLERS ====================

    /**
     * Routes button clicks to appropriate handler methods.
     * <p>
     * Acts as a central dispatcher for all button actions, delegating
     * to specific handler methods based on the button text.
     * </p>
     *
     * @param text The text of the clicked button
     */
    private void handleButtonClick(String text) {
        switch (text) {
            case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" -> handleNumber(text);
            case "." -> handleDecimal();
            case "C" -> handleClear();
            case "⌫" -> handleBackspace();
            case "±" -> handleSignToggle();
            case "%" -> handlePercentage();
            case "+", "-", "*", "/" -> handleOperator(text);
            case "=" -> handleEquals();
        }
    }

    /**
     * Handles numeric digit input (0-9).
     * <p>
     * Behavior:
     * <ul>
     *   <li>If starting new input, replaces display with the digit</li>
     *   <li>Prevents leading zeros (except for decimals like "0.5")</li>
     *   <li>Appends digit to existing number otherwise</li>
     * </ul>
     * </p>
     *
     * @param digit The digit character to input ("0"-"9")
     */
    private void handleNumber(String digit) {
        if (startNewInput) {
            displayField.setText(digit);
            startNewInput = false;
            hasDecimal = false;
        } else {
            String current = displayField.getText();
            // Replace leading zero with new digit (except for decimal numbers)
            if (current.equals("0") && !digit.equals("0")) {
                displayField.setText(digit);
            } else if (!current.equals("0")) {
                displayField.setText(current + digit);
            }
        }
    }

    /**
     * Handles decimal point input.
     * <p>
     * Ensures only one decimal point per number. If starting new input,
     * automatically prepends "0" before the decimal point.
     * </p>
     */
    private void handleDecimal() {
        if (startNewInput) {
            displayField.setText("0.");
            startNewInput = false;
            hasDecimal = true;
        } else if (!hasDecimal) {
            displayField.setText(displayField.getText() + ".");
            hasDecimal = true;
        }
    }

    /**
     * Clears all calculator state and resets to initial values.
     * <p>
     * Resets:
     * <ul>
     *   <li>Display to "0"</li>
     *   <li>Expression label to empty</li>
     *   <li>Stored operand to 0</li>
     *   <li>Operator to empty</li>
     *   <li>All input flags</li>
     * </ul>
     * </p>
     */
    private void handleClear() {
        displayField.setText("0");
        expressionLabel.setText("");
        num1 = 0;
        operator = "";
        startNewInput = true;
        hasDecimal = false;
    }

    /**
     * Removes the last character from the current input.
     * <p>
     * If removing brings the display to empty, resets to "0".
     * Also updates the decimal flag if removing a decimal point.
     * </p>
     */
    private void handleBackspace() {
        if (!startNewInput) {
            String current = displayField.getText();
            if (current.length() > 1) {
                // Update decimal flag if removing the decimal point
                if (current.endsWith(".")) {
                    hasDecimal = false;
                }
                displayField.setText(current.substring(0, current.length() - 1));
            } else {
                // Reset to zero if removing last digit
                displayField.setText("0");
                startNewInput = true;
            }
        }
    }

    /**
     * Toggles the sign of the current number between positive and negative.
     * <p>
     * Does not affect zero values.
     * </p>
     */
    private void handleSignToggle() {
        String current = displayField.getText();
        if (!current.equals("0") && !current.isEmpty()) {
            if (current.startsWith("-")) {
                displayField.setText(current.substring(1));
            } else {
                displayField.setText("-" + current);
            }
        }
    }

    /**
     * Converts the current number to its percentage value (divides by 100).
     */
    private void handlePercentage() {
        String current = displayField.getText();
        if (!current.isEmpty() && !current.equals("Error")) {
            double value = Double.parseDouble(current);
            value = value / 100;
            displayField.setText(formatResult(value));
            startNewInput = true;
        }
    }

    /**
     * Handles arithmetic operator input (+, -, *, /).
     * <p>
     * If there's a pending operation (chained calculation), evaluates it first
     * before storing the new operator. Updates the expression label to show
     * the current operand and operator.
     * </p>
     *
     * @param op The operator symbol ("+", "-", "*", "/")
     */
    private void handleOperator(String op) {
        String current = displayField.getText();
        if (!current.isEmpty() && !current.equals("Error")) {
            // Handle chained operations (e.g., 5 + 3 + 2)
            if (!operator.isEmpty() && !startNewInput) {
                handleEquals();
            }
            num1 = Double.parseDouble(displayField.getText());
            operator = op;
            expressionLabel.setText(formatResult(num1) + " " + getOperatorSymbol(op));
            startNewInput = true;
            hasDecimal = false;
        }
    }

    /**
     * Evaluates the pending operation and displays the result.
     * <p>
     * Performs the calculation based on the stored operand, operator,
     * and current display value. Handles division by zero with an error message.
     * The result becomes the new first operand for potential chained operations.
     * </p>
     */
    private void handleEquals() {
        String current = displayField.getText();
        if (!current.isEmpty() && !current.equals("Error") && !operator.isEmpty()) {
            double num2 = Double.parseDouble(current);
            double result;

            // Handle division by zero error
            if (operator.equals("/") && num2 == 0) {
                displayField.setText("Error");
                expressionLabel.setText("Cannot divide by zero");
                startNewInput = true;
                operator = "";
                return;
            }

            // Perform the calculation
            result = switch (operator) {
                case "+" -> num1 + num2;
                case "-" -> num1 - num2;
                case "*" -> num1 * num2;
                case "/" -> num1 / num2;
                default -> 0;
            };

            // Update display with result and expression
            expressionLabel.setText(formatResult(num1) + " " + getOperatorSymbol(operator) 
                    + " " + formatResult(num2) + " =");
            displayField.setText(formatResult(result));
            
            // Store result for potential chained operations
            num1 = result;
            operator = "";
            startNewInput = true;
            hasDecimal = displayField.getText().contains(".");
        }
    }

    // ==================== UTILITY METHODS ====================

    /**
     * Creates a standardized drop shadow effect for card-style containers.
     * <p>
     * The shadow provides depth and visual separation from the background
     * with a subtle offset and semi-transparent black color.
     * </p>
     *
     * @return Configured DropShadow effect for card elements
     */
    private DropShadow createCardDropShadow() {
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.rgb(0, 0, 0, 0.3));
        shadow.setRadius(15);
        shadow.setOffsetY(5);
        return shadow;
    }

    /**
     * Converts internal operator symbols to display-friendly Unicode characters.
     *
     * @param op The internal operator symbol ("*" or "/")
     * @return The display symbol ("×" for multiply, "÷" for divide, unchanged otherwise)
     */
    private String getOperatorSymbol(String op) {
        return switch (op) {
            case "*" -> "×";
            case "/" -> "÷";
            default -> op;
        };
    }

    /**
     * Formats a numeric result for display.
     * <p>
     * Formatting rules:
     * <ul>
     *   <li>Whole numbers display without decimal point (e.g., 5.0 → "5")</li>
     *   <li>Decimal numbers limited to 10 decimal places</li>
     *   <li>Trailing zeros are removed (e.g., 3.140 → "3.14")</li>
     * </ul>
     * </p>
     *
     * @param value The numeric value to format
     * @return Formatted string representation of the value
     */
    private String formatResult(double value) {
        // Check if value is a whole number
        if (value == (long) value) {
            return String.format("%d", (long) value);
        } else {
            // Format with up to 10 decimal places and remove trailing zeros
            String formatted = String.format("%.10f", value);
            formatted = formatted.replaceAll("0+$", "").replaceAll("\\.$", "");
            return formatted;
        }
    }
}
