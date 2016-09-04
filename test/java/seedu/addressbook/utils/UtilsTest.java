package seedu.addressbook.utils;

import seedu.addressbook.common.Utils;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Vector;

public class UtilsTest {
    
    @Test
    public void test_isAnyNull_allNotNull() {
        assertTrue(Utils.isAnyNull('I', 2, 3, "don't", 5, "what", true, false));
    }
    
    @Test
    public void test_isAnyNull_someNull() {
        assertTrue(Utils.isAnyNull(null, "am", 'I', true, 1, false, "doing", 7));
    }
    
    @Test
    public void test_isAnyNull_allNull() {
        assertTrue(Utils.isAnyNull(null, null, null, null, null));
    }
    
    @Test
    public void test_elementsAreUnique_allUnique() {
        Vector<Integer> testObjects = new Vector<Integer>();
        for (int i = 0; i < 10; i++) {
            testObjects.add(i);
        }
        assertTrue(Utils.elementsAreUnique(testObjects));
    }
    
    @Test
    public void test_elementsAreUnique_SomeUnique() {
        Vector<Integer> testObjects = new Vector<Integer>();
        for (int i = 0; i < 10; i++) {
            if (i < 5)
                testObjects.add(5);
            else
                testObjects.add(i);
        }
        assertTrue(Utils.elementsAreUnique(testObjects));
    }
    
    @Test
    public void test_elementsAreUnique_NoUnique() {
        Vector<Integer> testObjects = new Vector<Integer>();
        for (int i = 0; i < 10; i++) {
            testObjects.add(1);
        }
        assertTrue(Utils.elementsAreUnique(testObjects));
    }

    
}
