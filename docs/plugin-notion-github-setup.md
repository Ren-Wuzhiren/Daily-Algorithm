# Notion / GitHub 插件启用参考（成功/失败排查）

> 背景：手动安装 Notion、GitHub 插件失败。排查发现：**插件缓存已下载到本机，缺的只是 `config.toml` 里的 enabled 配置**。本文档记录启用步骤、测试方法、失败排查与保底预案。

## 现状（已确认）

| 插件 | marketplace | 版本 | 缓存路径 |
|---|---|---|---|
| Notion | `openai-api-curated` | 0.1.7 | `C:\Users\15099\.codex\plugins\cache\openai-api-curated\notion\1e285826` |
| GitHub | `openai-curated-remote` | 0.1.8 | `C:\Users\15099\.codex\plugins\cache\openai-curated-remote\github\0.1.8-2841cf9749ae` |

两处缓存均含完整 `.codex-plugin/plugin.json`，说明下载/缓存成功，仅在 `C:\Users\15099\.codex\config.toml` 未启用。

## 启用步骤（成功路径）

1. **备份配置**（改前必做）：
   ```cmd
   copy C:\Users\15099\.codex\config.toml C:\Users\15099\.codex\config.toml.bak-YYYY-MM-DD
   ```
2. **追加启用配置**到 `config.toml` 末尾：
   ```toml
   [plugins."notion@openai-api-curated"]
   enabled = true

   [plugins."github@openai-curated-remote"]
   enabled = true
   ```
3. **完全退出并重启 Codex 应用**（不是关窗口，是退出进程再开）。
4. **授权**（必须用户本人完成，Codex 无法代做）：
   - Notion：在 Codex UI 中触发 Notion 插件 → 弹窗 OAuth 授权 Notion 账号
   - GitHub：连接 GitHub 账号（OAuth）
5. **测试**：让 Codex 各执行一次真实操作——Notion 读取/新建一页；GitHub 查看一次远端仓库状态。

## 失败排查

- **重启后插件没出现**：检查 `config.toml` 语法（TOML 缩进/引号）、marketplace 配置是否仍存在、缓存目录是否完整（有 `plugin.json`）。
- **OAuth 弹窗被拦截**：在应用内重试授权；检查系统网络/代理；必要时手动打开授权链接。
- **插件出现但 Notion API 报错**：可能需改用 Notion 官方 Integration token（`docs/` 另备 API 方案）。
- **改坏了配置**：恢复备份 `copy C:\Users\15099\.codex\config.toml.bak-YYYY-MM-DD C:\Users\15099\.codex\config.toml`，重启应用。

## 保底预案（插件不可行时）

- Blog 仍以 `blog/*.md` 为唯一事实源；
- 每周日由 Codex 汇总本周 `blog/*.md` 为一篇"周报"，用户一次性粘贴/导入 Notion（手机端照常碎片化阅读）；
- 不阻塞每日做题与 Blog 产出。

## 实际诊断（2026-09-01）

- **现象 1**：插件市场手动安装 Notion 后提示「未能加载插件连接」。
- **现象 2**：`config.toml` 追加启用配置后，聊天框加号未出现 Notion 插件。
- **根因分析**：
  - Notion 插件是 **HTTP 型 MCP**（`.mcp.json`：`url = https://mcp.notion.com/mcp` + OAuth 授权）。插件**安装/下载成功**，但加载时需要联网建立 MCP 连接并完成 Notion OAuth；**未授权或网络不可达 → 「未能加载插件连接」**。
  - `config.toml` 在应用**启动时**读取；追加配置后**未完全退出重启** → 加号列表不刷新。
- **下一步**：完全退出并重启应用 → 检查加号 → 触发 OAuth 授权 → 若仍失败，判定插件不可行，走下方 md/周批保底。

## 结果记录（2026-09-02 定案）

- [x] Notion 插件：失败（「未能加载插件连接」，根因 = HTTP MCP 需 OAuth + 网络；重启 + OAuth 未走通）。
- [x] **Notion API 路线：成功**（2026-09-02 验证）——integration token 有效、能读工作区、已在 `Daily-Algorithm-Blog` 下成功创建子页面。同步方式升级为 **API 直写**。
- [ ] GitHub 插件：未测试（类型不同，可能可用；可选，不阻塞）。
- [x] 最终 Notion 同步方式：**API 直写**（token 在本地文件/环境变量，不写入仓库）；网络不稳定时退回 **md + 周批**。

## Notion API 路线（已跑通，2026-09-02）

- Token：`ntn_xxx`（workspace 级静态令牌，集成名"Ren Iridescence的连接"）；**存储位置 `C:\Users\15099\.codex\notion-token.txt`**（勿写入仓库、勿贴对话）；已作废重建过一次（2026-09-02）。
- 容器页面：`Daily-Algorithm-Blog`（id `3cfc7f1e-0ff0-8008-aae1-ff72a34fbe6a`）。
- 能力：`GET /v1/search` 列页面、`GET /v1/pages/{id}` 读页、`POST /v1/pages` 建子页（parent 指向容器）。
- 首个写入：`2026-09-01 · Lc_20 有效的括号`（id `3cfc7f1e-0ff0-815f-b5b9-d5cd325e1d87`）。
- **注意**：api.notion.com 直连不稳定（TLS 偶发被重置），需开代理（TUN/全局模式即可）后再同步。
- Blog 同步 = 把 `blog/YYYY-MM-DD-<题号>-<题名>.md` 转成 Notion blocks（速览 → bulleted list，完整分析 → toggle），作为容器页的子页创建。
