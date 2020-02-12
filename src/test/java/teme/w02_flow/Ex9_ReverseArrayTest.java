package teme.w02_flow;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotSame;
import static teme.w02_flow.Ex9_ReverseArray.reverse;
import static teme.w02_flow.Ex9_ReverseArray.reversedCopy;

/**
 * MAX GRADE: 16p
 */
@RunWith(GradeRunner.class)
public class Ex9_ReverseArrayTest {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(10); // max running time allowed per each test method

    @Test
    @Grade(3)
    public void testReverse_basicArray() {
        String[] arr1 = {};
        String[] arr2 = {"aa"};

        reverse(arr1);
        reverse(arr2);

        assertArrayEquals(new String[]{}, arr1);
        assertArrayEquals(new String[]{"aa"}, arr2);
    }

    @Test
    @Grade(5)
    public void testReverse_longerArrays() {
        String[] arr3 = {"aa", "bb", "cc"};
        String[] arr4 = {"aa", "bb", "cc", "dd"};
        String[] arr5 = {"aa", "bb", "cc", "dd", "ee"};

        reverse(arr3);
        reverse(arr4);
        reverse(arr5);

        assertArrayEquals(new String[]{"cc", "bb", "aa"}, arr3);
        assertArrayEquals(new String[]{"dd", "cc", "bb", "aa"}, arr4);
        assertArrayEquals(new String[]{"ee", "dd", "cc", "bb", "aa"}, arr5);
    }

    @Test
    @Grade(4)
    public void testReversedCopy_reverseWorks() {
        String[] arr1 = {};
        String[] arr2 = {"aa"};
        String[] arr3 = {"aa", "bb", "cc"};
        String[] arr4 = {"aa", "bb", "cc", "dd"};
        String[] arr5 = {"aa", "bb", "cc", "dd", "ee"};

        assertArrayEquals(new String[]{}, reversedCopy(arr1));
        assertArrayEquals(new String[]{"aa"}, reversedCopy(arr2));
        assertArrayEquals(new String[]{"cc", "bb", "aa"}, reversedCopy(arr3));
        assertArrayEquals(new String[]{"dd", "cc", "bb", "aa"}, reversedCopy(arr4));
        assertArrayEquals(new String[]{"ee", "dd", "cc", "bb", "aa"}, reversedCopy(arr5));
    }

    @Test
    @Grade(2)
    public void testReversedCopy_alwaysReturnsACopy() {
        String[] arr1 = {};
        String[] arr2 = {"aa"};
        String[] arr3 = {"aa", "bb", "cc"};
        String[] arr4 = {"aa", "bb", "cc", "dd"};
        String[] arr5 = {"aa", "bb", "cc", "dd", "ee"};

        //check that we get a copy (new array), not a reference to the initial array
        assertNotSame(reversedCopy(arr1), arr1);
        assertNotSame(reversedCopy(arr2), arr2);
        assertNotSame(reversedCopy(arr3), arr3);
        assertNotSame(reversedCopy(arr4), arr4);
        assertNotSame(reversedCopy(arr5), arr5);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    @Grade(2)
    public void testReversedCopy_originalRemainsUnchanged() {
        String[] arr1 = {};
        String[] arr2 = {"aa"};
        String[] arr3 = {"aa", "bb", "cc"};
        String[] arr4 = {"aa", "bb", "cc", "dd"};
        String[] arr5 = {"aa", "bb", "cc", "dd", "ee"};

        //ok to ignore result here
        reversedCopy(arr1);
        reversedCopy(arr2);
        reversedCopy(arr3);
        reversedCopy(arr4);
        reversedCopy(arr5);

        //check that the original arrays remained unchanged
        assertArrayEquals(new String[]{}, arr1);
        assertArrayEquals(new String[]{"aa"}, arr2);
        assertArrayEquals(new String[]{"aa", "bb", "cc"}, arr3);
        assertArrayEquals(new String[]{"aa", "bb", "cc", "dd"}, arr4);
        assertArrayEquals(new String[]{"aa", "bb", "cc", "dd", "ee"}, arr5);
    }
}
