package com.jefftc.engine;

/**
 * A Command has given stems and can detect if it is being called from an input string
 */
public class Command {

    private String[] stems;
    private boolean expectBody;

    /**
     * Create a Command given a list of stems and if it expects a body in the input
     *
     * @param stems      the list of stems
     * @param expectBody if it expects a body
     */
    public Command(String[] stems, boolean expectBody) {
        this.stems = stems;
        this.expectBody = expectBody;
    }

    /**
     * Get the primary stem of the command
     *
     * @return the primary stem
     */
    public String getCommand() {
        if (this.stems != null) {
            if (this.stems.length > 0) {
                return this.stems[0];
            }
        }
        return "";
    }

    /**
     * Checks if a user input matches the required format of the command
     *
     * @param message the user input
     * @return if the command is present
     */
    public boolean matchFormat(String message) {
        String cleanMessage = message.replaceAll("\t", " ");
        cleanMessage = cleanMessage.trim().replaceAll(" +", " ").toLowerCase();

        for (String head : stems) {
            if (this.expectBody) {
                if (cleanMessage.startsWith(head + " ") || cleanMessage.equalsIgnoreCase(head)) {
                    // If a body is expected, either followed by characters or the body is missing
                    return true;
                }
            } else {
                if (cleanMessage.startsWith(head)) {
                    // Flexibly allow commands not requiring bodies to have them
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Get the body of the message if applicable
     *
     * @param fullInput the full command
     */
    public String getBody(String fullInput) {
        String body = fullInput.replaceAll("\t", " ").trim();
        body = body.replaceAll("\n", "");

        if (body.indexOf(" ") > 0) {
            body = body.replaceAll(" +", " ");
            body = body.substring(body.indexOf(" ")).trim();
        } else {
            for (String currentStem : this.stems) {
                if (body.equalsIgnoreCase(currentStem)) {
                    body = "";
                }
            }
        }

        return body;
    }

}