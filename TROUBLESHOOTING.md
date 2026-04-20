# 404 问题排查指南

如果遇到 404 错误，请按以下步骤排查：

## 第一步：确认 Tomcat 启动成功

查看 IDEA 控制台输出，确认没有严重错误：
- 应该看到 `Server startup in [xxxx] ms`
- 如果有 Exception，请把错误信息发给团队

## 第二步：检查 Deployment 配置

1. 点击右上角的 Tomcat 配置下拉框 → `Edit Configurations...`
2. 切换到 `Deployment` 标签页
3. 检查：
   - 是否有 `teamwork-web:war exploded`
   - **Application context** 必须是 `/`（如果是其他值，访问时要加上）

## 第三步：尝试不同的访问路径

根据 Application context 的值，尝试以下路径：

| Application context | 访问 URL |
|-------------------|---------|
| `/` | http://localhost:8080/ |
| `/teamwork-web` | http://localhost:8080/teamwork-web/ |
| 其他值 | http://localhost:8080/你的值/ |

## 第四步：检查部署的文件

Tomcat 启动后，查看控制台的 "Artifact is deployed successfully" 信息之后，尝试：

1. 访问 http://localhost:8080/index.html
2. 访问 http://localhost:8080/hello
3. 访问 http://localhost:8080/test.txt

## 第五步：重新构建项目

如果以上都不行：

1. 停止 Tomcat
2. 点击菜单 `Build` → `Rebuild Project`
3. 重新启动 Tomcat

## 截图示例

如果还是不行，请截图以下界面发给团队：
1. Tomcat 配置的 Deployment 标签页
2. 浏览器地址栏和 404 页面
3. IDEA 控制台的启动日志
