package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = Block.BLOCK_EXAMPLE + 
    		                                     Street.STREET_EXAMPLE +
    		                                     Unit.UNIT_EXAMPLE +
    		                                     Postal.POSTAL_EXAMPLE;
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    
    private static final int BLOCK = 0;
    private static final int STREET = 1;
    private static final int UNIT = 2;
    private static final int POSTAL = 3;
    
    public final String value;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String[] breakAddress = addressSplitToGroups(address);
        try {
        	new Block(breakAddress[BLOCK]);
        	new Street(breakAddress[STREET]);
        	new Unit(breakAddress[UNIT]);
        	new Postal(breakAddress[POSTAL]);
        } catch (IllegalValueException e) {
        	throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        } catch (ArrayIndexOutOfBoundsException e) {
        	throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = String.join(", ", breakAddress);
    }
    
    private String[] addressSplitToGroups(String address) {
    	return address.split(", ");
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}