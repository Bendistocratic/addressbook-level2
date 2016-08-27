package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's block address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidBlockAddress(String)}
 */

public class Block {
	
    public static final String BLOCK_EXAMPLE = "123";
    public static final String MESSAGE_BLOCK_CONSTRAINTS = "Person block addresses can be in any format";
    public static final String BLOCK_VALIDATION_REGEX = ".+";
    
    public final String blockValue;
    
    /**
     * Validates given block address.
     *
     * @throws IllegalValueException if given block string is invalid.
     */
    public Block(String block) throws IllegalValueException {
        if (!isValidBlockAddress(block)) {
        	throw new IllegalValueException(MESSAGE_BLOCK_CONSTRAINTS);
        }
    	this.blockValue = block;
    }
    
    /**
     * Returns true if a given string is a valid person block address.
     */
    public static boolean isValidBlockAddress(String testBlock) {
    	return testBlock.matches(BLOCK_VALIDATION_REGEX);
    }
    
    @Override
    public String toString() {
    	return this.blockValue;
    }
    
    @Override
    public boolean equals(Object other) {
    	return other == this // short circuit if same object
    			|| (other instanceof Block  // instanceof handles nulls
    					&& this.blockValue.equals(((Block)other).blockValue)); // state check
    }
    
    @Override
    public int hashCode() {
    	return blockValue.hashCode();
    }
}
