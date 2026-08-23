package LeetCode_EnumRight;

public class Lc_1128_NumberEquivDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        /*
            给你一组多米诺骨牌 dominoes 。

            形式上，dominoes[i] = [a, b] 与 dominoes[j] = [c, d]
            等价 当且仅当 (a == c 且 b == d) 或者 (a == d 且 b == c) 。
            即一张骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌。

            在 0 <= i < j < dominoes.length 的前提下，找出
            满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。

            示例 1：
            输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
            输出：1

            示例 2：
            输入：dominoes = [[1,2],[1,2],[1,1],[1,2],[2,2]]
            输出：3
        */

        //以测试样例 1 为例：
        //1. 定义一个用于计入骨牌数量的数组，将 4 组数据放置在二维数组内
        int[][] count = new int[10][10];
        //2. 将相同骨牌的数量初始化为 0
        int answer = 0;
        //3. 写入一个增强for循环，实现 "枚举右" 的效果
        for (int[] d: dominoes) {
            //第 4 步实现 "维护左" 的效果
            //4.1.1 令 a 在 [1, 2] 取得最小值，a 取 0 索引的值 1 作为最小值
            //4.1.2 令 a 在 [2, 1] 取得最小值，a 取 1 索引的值 1 作为最小值
            int a = Math.min(d[0], d[1]);
            //4.2.1 令 a 在 [1, 2] 取得最小值，a 取 0 索引的值 2 作为最小值
            //4.2.2 令 a 在 [2, 1] 取得最小值，a 取 1 索引的值 2 作为最小值
            int b = Math.max(d[0], d[1]);
            //5. 无论 [1, 2] 和 [2, 1]，最后都会转化为 count[1][2]
            answer += count[a][b]++;
        }
        //6. 返回答案
        return answer;

        /*
            以测试样例 2 为例：
            1. 定义一个用于计入骨牌数量的数组，将 5 组数据放置在二维数组内
            int[][] count = new int[10][10];

            2. 将相同骨牌的数量初始化为 0
            int answer = 0;

            3. 写入一个增强for循环，实现 "枚举右" 的效果
            for (int[] d: dominoes) {
                4. 实现 "维护左" 的效果
                int a = Math.min(d[0], d[1]);
                int b = Math.max(d[0], d[1]);

                难点：answer 的计数规则运用到了组合数 C (3, 2) = 3! / ( 1! * 2! ) = 3

                4.1 第一次遇到 {1, 2} 时
                count[a][b] 为 0，answer 不自增
                所以 0 + 0 = 0

                /4.2 第二次遇到 {1, 2} 时
                count[a][b] 为 1，answer 由 0 自增至 1
                所以 0 + 1 == 1

                4.3 第三次遇到 {1, 2} 时
                count[a][b] 为 2，answer 由 1 自增至 3
                所以 1 + 2 == 3

                answer += count[a][b]++;
            }
            //5. 返回答案
            return answer;
        */

        //该算法的时间复杂度：O(n)，n为骨牌数
        //该算法的空间复杂度：O(n)，n为骨牌数
    }
}
