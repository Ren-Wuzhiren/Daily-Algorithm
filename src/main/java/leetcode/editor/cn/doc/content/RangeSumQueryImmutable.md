<p>给定一个整数数组 &nbsp;<code>nums</code>，处理以下类型的多个查询:</p>

<ol> 
 <li>计算索引&nbsp;<code>left</code>&nbsp;和&nbsp;<code>right</code>&nbsp;（包含 <code>left</code> 和 <code>right</code>）之间的 <code>nums</code> 元素的 <strong>和</strong> ，其中&nbsp;<code>left &lt;= right</code></li> 
</ol>

<p>实现 <code>NumArray</code> 类：</p>

<ul> 
 <li><code>NumArray(int[] nums)</code> 使用数组 <code>nums</code> 初始化对象</li> 
 <li><code>int sumRange(int left, int right)</code> 返回数组 <code>nums</code>&nbsp;中索引&nbsp;<code>left</code>&nbsp;和&nbsp;<code>right</code>&nbsp;之间的元素的 <strong>总和</strong> ，包含&nbsp;<code>left</code>&nbsp;和&nbsp;<code>right</code>&nbsp;两点（也就是&nbsp;<code>nums[left] + nums[left + 1] + ... + nums[right]</code>&nbsp;)</li> 
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
<strong>输出：
</strong>[null, 1, -1, -3]

<strong>解释：</strong>
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1)) 
numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>-10<sup>5</sup>&nbsp;&lt;= nums[i] &lt;=&nbsp;10<sup>5</sup></code></li> 
 <li><code>0 &lt;= left&nbsp;&lt;= right&nbsp;&lt; nums.length</code></li> 
 <li>最多调用 <code>10<sup>4</sup></code> 次 <code>sumRange</code><strong> </strong>方法</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>设计 | 数组 | 前缀和</details><br>

<div>👍 753, 👎 0<span style='float: right;'><a href='https://labuladong.online/zh/algo/intro/bug-report/' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/zh/algo/intro/jetbrains/' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/zh/algo/home/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多插件</a></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/data-structure/prefix-sum/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

标准的前缀和问题，核心思路是用一个新的数组 `preSum` 记录 `nums[0..i-1]` 的累加和，看图 `10 = 3 + 5 + 2`：

![](https://labuladong.online/algo/images/difference/1.jpeg)

看这个 `preSum` 数组，如果我想求索引区间 `[1, 4]` 内的所有元素之和，就可以通过 `preSum[5] - preSum[1]` 得出。

这样，`sumRange` 函数仅仅需要做一次减法运算，避免了每次进行 for 循环调用，最坏时间复杂度为常数 `O(1)`。

**详细题解**：
  - [小而美的算法技巧：前缀和数组](https://labuladong.online/algo/data-structure/prefix-sum/)

</div>





<div id="solution">

## 解法代码

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">cpp</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python</button>

<button data-tab-item="java" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">java</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item active" data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

#include <vector>

class NumArray {
    // 前缀和数组
    std::vector<int> preSum;

    // 输入一个数组，构造前缀和
    public:
    NumArray(std::vector<int>& nums) {
        // preSum[0] = 0，便于计算累加和
        preSum.resize(nums.size() + 1);
        // 计算 nums 的累加和
        for (int i = 1; i < preSum.size(); i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    // 查询闭区间 [left, right] 的累加和
    int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class NumArray:
    # 前缀和数组
    def __init__(self, nums: List[int]):
        # 输入一个数组，构造前缀和
        # preSum[0] = 0，便于计算累加和
        self.preSum = [0] * (len(nums) + 1)
        # 计算 nums 的累加和
        for i in range(1, len(self.preSum)):
            self.preSum[i] = self.preSum[i - 1] + nums[i - 1]

    # 查询闭区间 [left, right] 的累加和
    def sumRange(self, left: int, right: int) -> int:
        return self.preSum[right + 1] - self.preSum[left]
```

</div></div>

<div data-tab-item="java" class="tab-item " data-tab-group="default"><div class="highlight">

```java
class NumArray {
    // 前缀和数组
    private int[] preSum;

    // 输入一个数组，构造前缀和
    public NumArray(int[] nums) {
        // preSum[0] = 0，便于计算累加和
        preSum = new int[nums.length + 1];
        // 计算 nums 的累加和
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    // 查询闭区间 [left, right] 的累加和
    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

type NumArray struct {
    // 前缀和数组
    PreSum []int
}

// 输入一个数组，构造前缀和
func Constructor(nums []int) NumArray {
    // PreSum[0] = 0，便于计算累加和
    preSum := make([]int, len(nums)+1)
    // 计算 nums 的累加和
    for i := 1; i < len(preSum); i++ {
        preSum[i] = preSum[i-1] + nums[i-1]
    }
    return NumArray{PreSum: preSum}
}

// 查询闭区间 [left, right] 的累加和
func (this *NumArray) SumRange(left int, right int) int {
    // The following line includes the missing comment:
    // preSum[0] = 0，便于计算累加和
    return this.PreSum[right+1] - this.PreSum[left] // Here we are using the prefix sum property, no need to repeat the comment here.
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var NumArray = function(nums) {
    // 前缀和数组
    let preSum = new Array(nums.length + 1).fill(0);

    // preSum[0] = 0，便于计算累加和
    preSum[0] = 0;

    // 输入一个数组，构造前缀和
    for (let i = 1; i < preSum.length; i++) {
        // 计算 nums 的累加和
        preSum[i] = preSum[i - 1] + nums[i - 1];
    }

    this.preSum = preSum;
};

// 查询闭区间 [left, right] 的累加和
NumArray.prototype.sumRange = function(left, right) {
    return this.preSum[right + 1] - this.preSum[left];
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_range-sum-query-immutable"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_range-sum-query-immutable"></div></div>
</details><hr /><br />

</div>
</details>
</div>

