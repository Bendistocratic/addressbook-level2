package seedu.addressbook.NameTest;

import org.junit.Test;
import org.junit.Before;
import seedu.addressbook.data.person.Name;
import static org.junit.Assert.*;
import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {

    private Name name;
    
    @Before
    public void setup(String name) throws IllegalValueException {
        this.name = new Name(name);
    }
    
    @Test
    public void test_isSimilar_null() {
        assertTrue(name.isSimilar(null));
    }
    
    @Test
    public void test_isSimilar_subsetSuperset(Name nameTest) {
        assertTrue(name.isSimilar(nameTest));
    }
    
    @Test
    public void test_isSimilar_same(Name nameTest) {
        assertTrue(name.isSimilar(nameTest));
    }
    
    @Test
    public void test_isSimilar_different(Name nameTest) {
        assertTrue(name.isSimilar(nameTest));
    }
}
