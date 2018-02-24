package com.jefftc.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * An input layer shielding the Game allowing for user and bot input
 */
public class InputLayer {

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
     * Initialize the InputLayer with an array of Commands
     *
     * @param commands the array of Command
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
                System.out.println("\t> " + cleanMessage);
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
                    System.out.print("\t> ");
                }
                for (String col : columns) {
                    System.out.printf(format, col);
                }
                System.out.print("\n");
            }
        }
    }

    /**
     * Detect a command stem from an entire input
     *
     * @param input the entire input
     * @return the command stem
     */
    public String detectCommand(String input) {
        String cleanInput = input.trim().replaceAll(" +", " ").toLowerCase();
        for (Command cmd : this.commands) {
            if (cmd.matchFormat(cleanInput)) {
                return cmd.getCommand();
            }
        }
        return "";
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