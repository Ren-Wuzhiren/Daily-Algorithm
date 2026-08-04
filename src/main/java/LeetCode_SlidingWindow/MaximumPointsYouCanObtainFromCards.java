package LeetCode_SlidingWindow;

public class MaximumPointsYouCanObtainFromCards {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxScore(int[] cardPoints, int k) {

            int windowSliding = cardPoints.length - k;
            int sum = 0;

            for (int i = 0; i < cardPoints.length; i++) {
                // System.out.println("滑窗长度：" + windowSliding);
                // System.out.println("累加sum：" + sum);
                sum += cardPoints[i];
            }


            int total = sum;
            int minSum = sum;

            for (int i = windowSliding; i < cardPoints.length; i++) {
                total += cardPoints[i];
                // System.out.println("自增total：" + total);
                sum += cardPoints[i] - cardPoints[i - windowSliding];
                // System.out.println("累加sum：" + sum);
                minSum = Math.min(minSum, sum);
                // System.out.println("最小总和minSum：" + minSum);
            }


            return total - minSum;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        // put your test code here
        testExample1();
        testExample2();
        testExample3();
        testExample4();
        testExample5();
    }

    public static void testExample1() {
        Solution solution = new MaximumPointsYouCanObtainFromCards().new Solution();
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
        int result = solution.maxScore(cardPoints, k);
        System.out.println(result);
    }

    public static void testExample2() {
        Solution solution = new MaximumPointsYouCanObtainFromCards().new Solution();
        int[] cardPoints = {2,2,2};
        int k = 2;
        int result = solution.maxScore(cardPoints, k);
        System.out.println(result);
    }

    public static void testExample3() {
        Solution solution = new MaximumPointsYouCanObtainFromCards().new Solution();
        int[] cardPoints = {9,7,7,9,7,7,9};
        int k = 7;
        int result = solution.maxScore(cardPoints, k);
        System.out.println(result);
    }

    public static void testExample4() {
        Solution solution = new MaximumPointsYouCanObtainFromCards().new Solution();
        int[] cardPoints = {1,1000,1};
        int k = 1;
        int result = solution.maxScore(cardPoints, k);
        System.out.println(result);
    }

    public static void testExample5() {
        Solution solution = new MaximumPointsYouCanObtainFromCards().new Solution();
        int[] cardPoints = {1,79,80,1,1,1,200,1};
        int k = 3;
        int result = solution.maxScore(cardPoints, k);
        System.out.println(result);
    }
}