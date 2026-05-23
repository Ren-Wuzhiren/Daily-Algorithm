package LeetCode_Stack;

public class BackSpaceStringCompare {
    /*
        给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。

        注意：如果对空文本输入退格字符，文本继续为空。

        示例 1：
        输入：s = "ab#c", t = "ad#c"
        输出：true
        解释：s 和 t 都会变成 "ac"。

        示例 2：
        输入：s = "ab##", t = "c#d#"
        输出：true
        解释：s 和 t 都会变成 ""。

        示例 3：
        输入：s = "a#c", t = "b"
        输出：false
        解释：s 会变成 "c"，但 t 仍然是 "b"。
    */

    public static boolean backspaceCompare(String s, String t) {
        //将StringBuilder与栈的知识建立直觉
        StringBuilder ssb = new StringBuilder();
        StringBuilder tsb = new StringBuilder();
        //用toCharArray()对字符串s做拆解处理
        for (char c: s.toCharArray()) {
            if (c != '#') {
                //将不是'#'的字符追加至集合ssb中
                ssb.append(c);
            } else if (ssb.length() > 0) {
                //对集合ssb做非空判断，长度大于0，即可删除索引为(集合长度 - 1)的元素
                ssb.deleteCharAt(ssb.length() - 1);
            }
        }

        //用toCharArray()对字符串t做拆解处理
        for (char c: t.toCharArray()){
            if (c != '#') {
                //将不是'#'的字符追加至集合tsb中
                tsb.append(c);
            } else if (tsb.length() > 0) {
                //对集合tsb做非空判断，长度大于0，即可删除索引为(集合长度 - 1)的元素
                tsb.deleteCharAt(tsb.length() - 1);
            }
        }

        //对拼接后的ssb和拼接后的tsb做字符串对等判断，如果对等返回true，如果不对等返回false
        return ssb.toString().equals(tsb.toString());
    }

    //时间复杂度：O(s.length() + t.length())
    //空间复杂度：O(s.length() + t.length())
}
