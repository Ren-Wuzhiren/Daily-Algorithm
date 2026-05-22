package LeetCode_Stack;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

import static LeetCode_Stack.BuildAnArrayWithStackOperations.buildArray;

public class BuildAnArrayWithStackOperationsTest extends TestCase {
    public void testBuildArray01() {
        int[] target = {1, 3};
        int n = 3;
        List<String> answer = buildArray(target, n);
        System.out.println("answer = " + answer);
    }


    public void testBuildArray02() {
        int[] target = {1, 2, 3};
        int n = 3;
        List<String> answer = buildArray(target, n);
        System.out.println("answer = " + answer);
    }

    public void testBuildArray03() {
        int[] target = {1, 2};
        int n = 4;
        List<String> answer = buildArray(target, n);
        System.out.println("answer = " + answer);
    }
}