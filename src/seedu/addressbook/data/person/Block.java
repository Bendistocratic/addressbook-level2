package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's block address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */

public class Block {
	
    public static final String EXAMPLE = "123";
    public static final String MESSAGE_BLOCK_CONSTRAINTS = "Person block addresses can be in any format";
    public static final String BLOCK_VALIDATION_REGEX = ".+";
    
    public final String blockValue;
    private boolean isPrivate;
    
    public Block(String block, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidBlockAddress(block)) {
        	throw new IllegalValueException(MESSAGE_BLOCK_CONSTRAINTS);
        }
    	this.blockValue = block;
    }
    
    public static boolean isValidBlockAddress(String testBlock) {
    	return testBlock.matches(BLOCK_VALIDATION_REGEX);
    }
    
    @Override
    public String toString() {
    	return this.blockValue;
    }
    
    @Override
    public boolean equals(Object other) {
    	return other == this 
    			|| (other instanceof Block 
    					&& this.blockValue.equals(((Block)other).blockValue));
    }
    
    @Override
    public int hashCode() {
    	return blockValue.hashCode();
    }
    
    public boolean isPrivate() {
    	return this.isPrivate;
    }
}
