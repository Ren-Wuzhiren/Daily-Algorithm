package LeetCode_Stack;

import java.util.ArrayList;
import java.util.List;

public class BuildAnArrayWithStackOperations {
    /*
        给你一个数组 target 和一个整数 n。

        给你一个空栈和两种操作：

                "Push"：将一个整数加到栈顶。
                "Pop"：从栈顶删除一个整数。
        同时给定一个范围 [1, n] 中的整数流。

        使用两个栈操作使栈中的数字（从底部到顶部）等于 target。你应该遵循以下规则：

        如果整数流不为空，从流中选取下一个整数并将其推送到栈顶。
        如果栈不为空，弹出栈顶的整数。
        如果，在任何时刻，栈中的元素（从底部到顶部）等于 target，则不要从流中读取新的整数，也不要对栈进行更多操作。
        请返回遵循上述规则构建 target 所用的操作序列。如果存在多个合法答案，返回 任一 即可。

        示例 1：
        输入：target = [1,3], n = 3
        输出：["Push","Push","Pop","Push"]
        解释：一开始栈为空。最后一个元素是栈顶。
        从流中读取 1 并推入数组。s = [1]。
        从流中读取 2 并推入数组。s = [1,2]。
        从栈顶删除整数。s = [1]。
        从流中读取 3 并推入数组。s = [1,3]。

        示例 2：
        输入：target = [1,2,3], n = 3
        输出：["Push","Push","Push"]
        解释：一开始栈为空。最后一个元素是栈顶。
        从流中读取 1 并推入数组。s = [1]。
        从流中读取 2 并推入数组。s = [1,2]。
        从流中读取 3 并推入数组。s = [1,2,3]。

        示例 3：
        输入：target = [1,2], n = 4
        输出：["Push","Push"]
        解释：一开始栈为空。最后一个元素是栈顶。
        从流中读取 1 并推入数组。s = [1]。
        从流中读取 2 并推入数组。s = [1,2]。
        由于栈（从底部到顶部）等于 target，我们停止栈操作。
        从流中读取整数 3 的答案不被接受。
    */

    public static List<String> buildArray(int[] target, int n) {
        //思路：将ArrayList<>()与栈的知识建立直觉
        //应用知识：ArrayList(add)，for循环，if-else判断，关键词static，调用数组长度关键词length
        ArrayList<String> answer = new ArrayList<>();
        //target.length - 1是数组target的下标，max应为数组target中的元素个数
        int max = target[target.length - 1];
        //设定数组target的循环边界i从0开始自增
        int i = 0;
        //设定整数流循环变量x从1开始自增至max
        for (int x = 1; x <= max; x++) {
            answer.add("Push");
            //若整数x和数组target下标i对应的元素相等
            if (x == target[i]) {
                //数组target循环变量i自增
                i++;
                //反之需要将栈顶元素弹出
            } else answer.add("Pop");
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] target = {1, 2};
        int n = 4;
        List<String> answer = buildArray(target, n);
        System.out.println("answer = " + answer);
    }
}
