package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a Person's name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}
 */
public class Name {

    public static final String EXAMPLE = "John Doe";
    public static final String MESSAGE_NAME_CONSTRAINTS = "Person names should be spaces or alphabetic characters";
    public static final String NAME_VALIDATION_REGEX = "[\\p{Alpha} ]+";

    public final String fullName;

    /**
     * Validates given name.
     *
     * @throws IllegalValueException if given name string is invalid.
     */
    public Name(String name) throws IllegalValueException {
        name = name.trim();
        if (!isValidName(name)) {
            throw new IllegalValueException(MESSAGE_NAME_CONSTRAINTS);
        }
        this.fullName = name;
    }

    /**
     * Returns true if a given string is a valid person name.
     */
    public static boolean isValidName(String test) {
        return test.matches(NAME_VALIDATION_REGEX);
    }
    
    /**
     * Returns true if the other name is very similar to this name
     * Two names are considered similar: 1. Same alphabets w/o caps
     *                                   2. Any number of spaces between names
     *                                   3. Name in any sequence
     *                                   4. Is a subset of a another
     */
    public boolean isSimilar(Name other) throws NullPointerException {
        boolean isInName = false;
        String[] one = fullName.toLowerCase().split("\\s+");
        if (other.equals(null))
            return false;
        String[] two = other.fullName.toLowerCase().split("\\s+");
        for (int x = 0; x < one.length; x++) {
            isInName = false;
            for (int y = 0; y < two.length; y++) {
                if (one[x].equals(two[y])) {
                    isInName = true;
                    break;
                }
            }
        }
        
        for (int x = 0; x < two.length; x++) {
            isInName = false;
            for (int y = 0; y < one.length; y++) {
                if (one[y].equals(two[x])) {
                    isInName = true;
                    break;
                }
            }
        }
        
        if (!isInName) {
            return false;
        }
        
        return true;
    }

    /**
     * Retrieves a listing of every word in the name, in order.
     */
    public List<String> getWordsInName() {
        return Arrays.asList(fullName.split("\\s+"));
    }

    @Override
    public String toString() {
        return fullName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Name // instanceof handles nulls
                && this.fullName.equals(((Name) other).fullName)); // state check
    }

    @Override
    public int hashCode() {
        return fullName.hashCode();
    }

}
