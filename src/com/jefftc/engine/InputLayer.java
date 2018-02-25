package com.jefftc.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * An input layer shielding the Game allowing for user and bot input
 */
public class InputLayer {

    private static final double CONVERT_TO_PERCENT = 100.0;
    private static final double BASE_VALUE = 1.0;
    private static final int STATUS_SIZE = 50;
    private static final int MESSAGE_PADDING = 2;

    private boolean isUser;
    private Scanner scanner;
    private Command[] commands;

    public ArrayList<String> inputHistory = new ArrayList<>();
    public ArrayList<String> outputHistory = new ArrayList<>();

    /**
     * For testing with automated input
     */
    public ArrayList<String> predefinedInput = new ArrayList<>();
    private int inputIndex = 0;

    public boolean waitingForInput = false;

    /**
     * Create an input layer to either accept data from the user or from the test
     *
     * @param isUser if the input layer uses the user input or bot
     */
    public InputLayer(boolean isUser) {
        this.isUser = isUser;
        if (isUser) {
            scanner = new Scanner(System.in);
        }
    }

    /**
     * Initialize the InputLayer with an array of Command objects
     *
     * @param commands the Command objects
     */
    public void init(Command[] commands) {
        this.commands = commands;
    }

    /**
     * Get input, automatically chooses from the user scanner or selects predefined data
     * Store all queries to the input log
     *
     * @return the filtered and chosen input
     */
    public String receiveInput() {
        String input;
        if (isUser) {
            input = scanner.nextLine().trim();
        } else {
            if (inputIndex < predefinedInput.size()) {
                input = predefinedInput.get(inputIndex).trim();
                inputIndex++;
            } else {
                // If out of inputs, quit
                input = "quit";
            }
        }

        if (input.length() > 0) {
            inputHistory.add(input);
            return input;
        }
        return "";
    }

    /**
     * Detect a command stem from an entire input
     *
     * @param input the entire input
     * @return the command
     */
    public Command detectCommand(String input) {
        String cleanInput = input.trim().replaceAll(" +", " ").toLowerCase();
        for (Command cmd : this.commands) {
            if (cmd.matchFormat(cleanInput)) {
                return cmd;
            }
        }
        return null;
    }

    /**
     * Requests the user for a true or false answer
     *
     * @return if the user said yes or no
     */
    public boolean expectBoolean() {
        String response = this.receiveInput().toLowerCase();
        if (response.equals("true") || response.equals("t")
                || response.equals("yes") || response.equals("y")) {
            // True aka Yes
            return true;
        } else if (response.equals("false") || response.equals("f")
                || response.equals("no") || response.equals("n")) {
            // False aka No
            return false;
        } else if (response.equals("quit")) {
            // Quit the program
            System.exit(0);
        }

        this.println("You must supply a yes or no answer, please try again");
        return this.expectBoolean();
    }

    /**
     * Request the user for an integer in an inclusive range
     *
     * @param min the minimum acceptable value
     * @param max the maximum acceptable value
     * @return the value the user supplied
     */
    public int expectInt(int min, int max) {
        String response = this.receiveInput();
        if (response.equalsIgnoreCase("quit")) {
            System.exit(0);
        }

        try {
            int value = Integer.parseInt(response);
            if (value >= min && value <= max) {
                return value;
            }
        } catch (Exception ignored) {
        }

        this.println("You must supply a valid integer between " + min + " and " + max);
        return this.expectInt(min, max);
    }

    /**
     * Print to the output log as well as the console if user input is on
     *
     * @param message the message to print
     */
    public void println(String message) {
        String cleanMessage = message.trim().replaceAll(" +", " ");
        if (cleanMessage.length() > 0) {
            outputHistory.add(cleanMessage);
            if (isUser) {
                System.out.println(cleanMessage);
            }
        }
    }

    /**
     * Print to the output log as well as the console if user input is on, indented
     *
     * @param message the message to print
     */
    public void printlnIndented(String message) {
        String cleanMessage = message.trim().replaceAll(" +", " ");
        if (cleanMessage.length() > 0) {
            outputHistory.add(cleanMessage);
            if (isUser) {
                System.out.println("\t" + cleanMessage);
            }
        }
    }

    /**
     * Prints to the output log using printf
     *
     * @param colWidth width of columns
     * @param message  formatted message
     */
    public void printFormatted(int colWidth, boolean indented, String message) {
        String cleanMessage = message.trim().replaceAll(" +", " ");
        if (cleanMessage.length() > 0) {
            outputHistory.add(cleanMessage);

            if (isUser) {
                String[] columns = cleanMessage.split(", ");
                String format = "%-" + colWidth + "s";

                if (indented) {
                    System.out.print("\t");
                }
                for (String col : columns) {
                    System.out.printf(format, col);
                }
                System.out.print("\n");
            }
        }
    }

    /**
     * Print out a bar graph section with the label
     *
     * @param message the message label
     * @param width the width of the columns
     * @param percentage the percentage of the bar
     */
    private void printBar(String message, int width, double percentage) {
        this.printFormatted(width, true,
                message + ":, " + printableStatus(percentage, BASE_VALUE));
    }

    /**
     * Print out a list of bars
     *
     * @param messages the list of messages
     * @param percentages the list of percentages
     */
    public void printAllBars(List<String> messages, List<Double> percentages) {
        int maxWidth = 0;
        for (String message : messages) {
            if (message.length() > maxWidth) {
                maxWidth = message.length();
            }
        }
        maxWidth += MESSAGE_PADDING;

        for (int i = 0; i < messages.size() && i < percentages.size(); i++) {
            this.printBar(messages.get(i), maxWidth, percentages.get(i));
        }
    }

    /**
     * Get the status bar for a given value
     *
     * @param value the double value
     * @return the string value
     */
    private static String printableStatus(double value, double baseValue) {
        StringBuilder status = new StringBuilder();
        int bars = (int) Math.floor(STATUS_SIZE * (value / baseValue));

        for (int i = 0; i < STATUS_SIZE; i++) {
            if (i < bars) {
                status.append("█");
            } else {
                status.append("░");
            }
        }

        String percentage = printableDouble((value * CONVERT_TO_PERCENT) / baseValue);
        percentage = percentage.substring(0, percentage.indexOf(".")) + "%";
        status.append(" ");
        status.append(percentage);

        return status.toString();
    }

    /**
     * Get a truncated double
     *
     * @param value the double value
     * @return the string value
     */
    private static String printableDouble(double value) {
        return String.format("%.2f", value);
    }

    /**
     * Compare an array with a list
     *
     * @param comparisonList  the list of strings
     * @param comparisonArray the array of strings
     * @return if they are equal
     */
    public static boolean compareWithList(List<String> comparisonList, String[] comparisonArray) {
        if (comparisonList != null && comparisonArray != null) {
            if (comparisonList.size() == comparisonArray.length) {
                // Verify each item matches
                for (int i = 0; i < comparisonList.size(); i++) {
                    if (!comparisonList.get(i).equals(comparisonArray[i])) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            return (comparisonList == null || comparisonList.isEmpty()) && comparisonArray == null;
        }
    }

}