package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.*;


import java.util.List;

/**
 * Text UI of the application.
 */
public class Formatter {

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";


    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    private static final String COMMENT_LINE_FORMAT_REGEX = "#.*";

    /**
     * Prompts for the command and reads the text entered by the user.
     * Ignores empty, pure whitespace, and comment lines.
     * Echos the command back to the user.
     * @return command (full line) entered by the user
     */
    public String getUserCommandFormatOutput() {
        return LINE_PREFIX + "Enter command: ";
    }
    
    public String getUserCommandFormatInput(String input) {
    	return "[Command entered:" + input + "]";
    }


    public String showWelcomeMessageFormat(String version, String storageFilePath) {
        String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
        String message = showToUserFormat(
                                          DIVIDER,
                                          DIVIDER,
                                          MESSAGE_WELCOME,
                                          version,
                                          MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE,
                                          storageFileInfo,
                                          DIVIDER);
        return message;
    }

    public String showGoodbyeMessageFormat() {
        return showToUserFormat(MESSAGE_GOODBYE, DIVIDER, DIVIDER);
    }


    public String showInitFailedMessageFormat() {
        return showToUserFormat(MESSAGE_INIT_FAILED, DIVIDER, DIVIDER);
    }

    /** Shows message(s) to the user */
    public String showToUserFormat(String... message) {
        StringBuilder sb = new StringBuilder();
    	for (String m : message) {
            sb.append(LINE_PREFIX + m.replace("\n", LS + LINE_PREFIX));
            sb.append('\n');
        }
    	return sb.toString();
    }

    /**
     * Shows the result of a command execution to the user. Includes additional formatting to demarcate different
     * command execution segments.
     */
    public String showResultToUserFormat(String sentence) {
        return showToUserFormat(sentence, DIVIDER);
    }

    /**
     * Shows a list of persons to the user, formatted as an indexed list.
     * Private contact details are hidden.
     */
    public String showPersonListViewFormat(List<String> list) {
        return showToUserAsIndexedListFormat(list);
    }

    /** Shows a list of strings to the user, formatted as an indexed list. */
    public String showToUserAsIndexedListFormat(List<String> list) {
        return showToUserFormat(getIndexedListForViewingFormat(list));
    }

    /** Formats a list of strings as a viewable indexed list. */
    public static String getIndexedListForViewingFormat(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItemFormat(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        formatted.append(LINE_PREFIX + "\n");
        return formatted.toString();
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    public static String getIndexedListItemFormat(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }

}
