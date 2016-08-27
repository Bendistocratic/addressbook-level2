package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's street address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidStreetAddress(String)}
 */

public class Street {
	
    public static final String STREET_EXAMPLE = ", some street";
    public static final String MESSAGE_STREET_CONSTRAINTS = "Person street addresses can be in any format";
    public static final String STREET_VALIDATION_REGEX = ".+";
    
    public final String streetValue;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given street string is invalid.
     */
    public Street(String street, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidStreetAddress(street)) {
            throw new IllegalValueException(MESSAGE_STREET_CONSTRAINTS);
        }
        this.streetValue = street;
    }

    /**
     * Returns true if a given string is a valid person street address.
     */
    public static boolean isValidStreetAddress(String test) {
        return test.matches(STREET_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return streetValue;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Street // instanceof handles nulls
                && this.streetValue.equals(((Street) other).streetValue)); // state check
    }

    @Override
    public int hashCode() {
        return streetValue.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
