# 仓库指南

## 项目结构与模块组织

- `src/main/java/LeetCode_*/`：按算法套路分包的题解（`LeetCode_SlidingWindow`、`LeetCode_EnumRight`、`LeetCode_Queue`、`LeetCode_Stack`），每个文件一个 public 类，命名 `Lc_<题号>_<题名>`，如 `LeetCode_SlidingWindow/Lc_209_MinimumSizeSubarraySum.java`。
- `src/test/java/LeetCode_*/`：对应的 JUnit 4 测试（`Lc_209_MinimumSizeSubarraySumTest.java`）。
- `src/main/java/leetcode/editor/cn/`：力扣 IDE 插件的生成区，请勿重命名或改动其结构。
- `notes/`：按套路的笔记（`00-学习意识.md`、`01-array-two-pointers.md` 等）。
- `problem-set/`：题单与每日打卡记录（`打卡记录.md`）。
- 根目录：`README.md`（进度总表 + 规范）、`TEMPLATE.md`（打卡 + 测试规范）。

## 构建、测试与开发命令

源码是 UTF-8，但 `pom.xml` 未设置 `project.build.sourceEncoding`，`mvn test` 会按 GBK 解码 UTF-8 源码而失败。在修复之前，请手动编译与测试：

- `javac -encoding UTF-8 -cp <junit-4.13.1.jar> -d target/classes src/main/java/LeetCode_SlidingWindow/Lc_209_*.java`
- `javac -encoding UTF-8 -cp target/classes;<junit-4.13.1.jar> -d target/test-classes src/test/java/LeetCode_SlidingWindow/Lc_209_*Test.java`
- `java -cp target/classes;target/test-classes;<junit-4.13.1.jar>;<hamcrest-core-1.3.jar> org.junit.runner.JUnitCore LeetCode_SlidingWindow.Lc_209_MinimumSizeSubarraySumTest`

用 IntelliJ IDEA 直接运行测试最省事（会自动处理每个文件的编码）。

## 编码风格与命名规范

- 新题解与测试按 `Lc_<题号>_<题名>` / `Lc_<题号>_<题名>Test` 命名，放入 `LeetCode_<套路>` 包；特殊题号需净化（如 面试题 16.24 → `Lc_1624_PairsWithSumLCCI`）。
- 与同目录文件风格保持一致：有的解法把方法直接写在类上，有的放在内部 `Solution` 类里。
- 保留现有中文注释——它们是学习痕迹。
- 缩进 4 空格；未配置格式化或 lint 工具。

## 测试规范

- 框架：JUnit 4.13.1。
- 每题完成后必须配套测试，覆盖 ① 全部官方示例 ② 易错/边界用例（空输入、单元素、重复、负数、溢出、边界）——见 `TEMPLATE.md` 的"测试规范"。
- 测试命名 `<SolutionClass>Test.java`，放在 `src/test/java` 同包路径下。

## 提交与 Pull Request 规范

- 提交信息采用约定式前缀 + 简短中文描述：`feat:`、`fix:`、`test:`、`refactor:`、`docs:`、`chore:`（例：`feat: 27.移除元素 快慢指针解法 + 测试全绿（6/6）`）。
- 每次提交只包含一个逻辑变更；题解、测试与登记（README / 打卡记录）应一起提交。
- 这是个人学习仓库，PR 不是常规流程；如需提 PR，请说明改动并注明对应力扣题号。

## Agent 专属说明

- 辅导解题时遵循分级提示协议：L1 套路提示 → L2 思路骨架 → L3 完整题解，L1/L2 阶段不得直接给出完整解法。
- 题目 AC 后，生成对应 JUnit 测试，并更新 `problem-set/打卡记录.md` 与 README 进度总表。
