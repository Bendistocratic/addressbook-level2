package seedu.addressbook.utils;

import seedu.addressbook.common.Utils;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Vector;

public class UtilsTest {
    
    @Test
    public void test_isAnyNull_allNotNull() {
        assertEquals(Utils.isAnyNull('I', 2, 3, "don't", 5, "what", true, false), false);
    }
    
    @Test
    public void test_isAnyNull_someNull() {
        assertEquals(Utils.isAnyNull(null, "am", 'I', true, 1, false, "doing", 7), true);
    }
    
    @Test
    public void test_isAnyNull_allNull() {
        assertEquals(Utils.isAnyNull(null, null, null, null, null), true);
    }
    
    @Test
    public void test_elementsAreUnique_allUnique() {
        Vector<Integer> testObjects = new Vector<Integer>();
        for (int i = 0; i < 10; i++) {
            testObjects.add(i);
        }
        assertEquals(Utils.elementsAreUnique(testObjects), true);
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
        assertEquals(Utils.elementsAreUnique(testObjects), false);
    }
    
    @Test
    public void test_elementsAreUnique_NoUnique() {
        Vector<Integer> testObjects = new Vector<Integer>();
        for (int i = 0; i < 10; i++) {
            testObjects.add(1);
        }
        assertEquals(Utils.elementsAreUnique(testObjects), false);
    }

    
}
