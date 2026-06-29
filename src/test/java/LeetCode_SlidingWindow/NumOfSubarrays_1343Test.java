package LeetCode_SlidingWindow;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class NumOfSubarrays_1343Test {
    private final NumOfSubarrays_1343 solution = new NumOfSubarrays_1343();

    @Test
    public void numOfSubarraysExample1() {
        int[] arr = {2, 2, 2, 2, 5, 5 ,5, 8};
        int k = 3, threshold = 4;
        int actual = solution.numOfSubarrays(arr, k, threshold);
        int expacted = 3;
        assertEquals(expacted, actual);
    }

    @Test
    public void numOfSubarraysExample2() {
        int[] arr = {11, 13, 17, 23, 29, 31, 7, 5, 2, 3};
        int k = 3, threshold = 5;
        int actual = solution.numOfSubarrays(arr, k, threshold);
        int expacted = 6;
        assertEquals(expacted, actual);
    }
}