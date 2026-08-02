package LeetCode_SlidingWindow;

public class MinimumRecolorsToGetKConsecutiveBlackBlocks {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumRecolors(String blocks, int k) {
            int count_W = 0;
            int minCount = Integer.MAX_VALUE;
            for (int i = 0; i < blocks.length(); i++) {
                if (blocks.charAt(i) == 'W') {
                    count_W++;
                }

                if (i - k + 1 < 0) {
                    continue;
                }

                minCount = Math.min(count_W, minCount);

                if (blocks.charAt(i - k + 1) == 'W') {
                    count_W--;
                }
            }

            return minCount;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MinimumRecolorsToGetKConsecutiveBlackBlocks().new Solution();
        // put your test code here
        String block1 = "WBBWWBBWBW";
        int k = 7;
        System.out.println(solution.minimumRecolors(block1, k));
    }
}