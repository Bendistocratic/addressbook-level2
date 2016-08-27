package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's unit address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidUnitAddress(String)}
 */
public class Unit {

    public static final String UNIT_EXAMPLE = ", some unit";
    public static final String MESSAGE_UNIT_CONSTRAINTS = "Person unit addresses can be in any format";
    public static final String UNIT_VALIDATION_REGEX = ".+";

    public final String unitValue;
    private boolean isPrivate;

    /**
     * Validates given unit address.
     *
     * @throws IllegalValueException if given unit address string is invalid.
     */
    public Unit(String unit, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidUnitAddress(unit)) {
            throw new IllegalValueException(MESSAGE_UNIT_CONSTRAINTS);
        }
        this.unitValue = unit;
    }

    /**
     * Returns true if a given string is a valid person unit address.
     */
    public static boolean isValidUnitAddress(String test) {
        return test.matches(UNIT_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return unitValue;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Unit// instanceof handles nulls
                && this.unitValue.equals(((Unit) other).unitValue)); // state check
    }

    @Override
    public int hashCode() {
        return unitValue.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
