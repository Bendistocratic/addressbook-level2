package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's postal address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidPostalAddress(String)}
 */
public class Postal {
	
    public static final String POSTAL_EXAMPLE = ", some postal";
    public static final String MESSAGE_POSTAL_CONSTRAINTS = "Person postal addresses can be in any format";
    public static final String POSTAL_VALIDATION_REGEX = ".+";

    public final String postalValue;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given postal address string is invalid.
     */
    public Postal(String postal, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidPostalAddress(postal)) {
            throw new IllegalValueException(MESSAGE_POSTAL_CONSTRAINTS);
        }
        this.postalValue = postal;
    }

    /**
     * Returns true if a given string is a valid person postal address.
     */
    public static boolean isValidPostalAddress(String test) {
        return test.matches(POSTAL_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return postalValue;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Postal // instanceof handles nulls
                && this.postalValue.equals(((Postal) other).postalValue)); // state check
    }

    @Override
    public int hashCode() {
        return postalValue.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
