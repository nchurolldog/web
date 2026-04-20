# Git & GitHub 团队协作指南

本文档介绍团队协作中常用的 Git 操作和工作流程。

## 目录

- [首次配置](#首次配置)
- [基本操作](#基本操作)
- [分支管理](#分支管理)
- [团队协作流程](#团队协作流程)
- [常见问题](#常见问题)

---

## 首次配置

### 1. 安装 Git

下载并安装 Git: https://git-scm.com/downloads

验证安装：
```bash
git --version
```

### 2. 配置用户信息

```bash
# 设置用户名（换成你自己的名字）
git config --global user.name "Your Name"

# 设置邮箱（换成你自己的邮箱）
git config --global user.email "your.email@example.com"
```

### 3. 配置 SSH Key（推荐）

生成 SSH Key：
```bash
ssh-keygen -t ed25519 -C "your.email@example.com"
```

一路回车即可。

查看公钥：
```bash
# Windows
cat ~/.ssh/id_ed25519.pub

# 或者
type %USERPROFILE%\.ssh\id_ed25519.pub
```

复制公钥内容，添加到 GitHub：
1. 登录 GitHub
2. 点击头像 → `Settings` → `SSH and GPG keys`
3. 点击 `New SSH key`
4. 粘贴公钥，保存

---

## 基本操作

### 克隆仓库

```bash
git clone https://github.com/nchurolldog/web.git
# 或者使用 SSH（推荐）
git clone git@github.com:nchurolldog/web.git
```

### 查看状态

```bash
git status
```

### 添加文件到暂存区

```bash
# 添加指定文件
git add filename

# 添加所有文件
git add .
```

### 提交更改

```bash
git commit -m "提交说明"
```

提交说明规范：
- `feat: 新功能`
- `fix: 修复bug`
- `docs: 文档更新`
- `style: 代码格式调整`
- `refactor: 重构`
- `test: 测试相关`

示例：
```bash
git commit -m "feat: 添加用户登录功能"
git commit -m "fix: 修复首页显示异常"
```

### 推送到远程仓库

```bash
git push
```

### 拉取最新代码

```bash
git pull
```

### 查看提交历史

```bash
git log
git log --oneline  # 简洁显示
```

---

## 分支管理

### 查看分支

```bash
# 查看本地分支
git branch

# 查看所有分支（包括远程）
git branch -a
```

### 创建分支

```bash
# 创建新分支
git branch 分支名

# 创建并切换到新分支
git checkout -b 分支名
# 或者（Git 2.23+）
git switch -c 分支名
```

### 切换分支

```bash
git checkout 分支名
# 或者
git switch 分支名
```

### 合并分支

```bash
# 先切换到目标分支（通常是 main）
git checkout main

# 拉取最新代码
git pull

# 合并指定分支
git merge 分支名
```

### 删除分支

```bash
# 删除本地分支
git branch -d 分支名

# 强制删除（未合并的分支）
git branch -D 分支名

# 删除远程分支
git push origin --delete 分支名
```

---

## 团队协作流程

### 推荐工作流

#### 1. 同步主分支

```bash
git checkout main
git pull
```

#### 2. 创建功能分支

```bash
git checkout -b feature/你的功能名
# 例如: feature/user-login, feature/article-list
```

#### 3. 开发并提交

```bash
# 编写代码...

# 查看修改
git status

# 添加文件
git add .

# 提交
git commit -m "feat: 描述你的修改"
```

#### 4. 推送到远程

```bash
git push -u origin feature/你的功能名
```

#### 5. 创建 Pull Request

1. 打开 GitHub 仓库页面
2. 点击 `Compare & pull request`
3. 填写标题和描述
4. 点击 `Create pull request`
5. 等待团队成员审查

#### 6. 代码审查后合并

审查通过后，点击 `Merge pull request` 合并到主分支。

#### 7. 清理分支

```bash
# 切换到主分支
git checkout main

# 拉取最新代码
git pull

# 删除本地功能分支
git branch -d feature/你的功能名

# 删除远程功能分支（可选，通常 PR 合并后会自动删除）
git push origin --delete feature/你的功能名
```

---

## 常见问题

### 1. 遇到冲突怎么办？

当 Git 无法自动合并时，会提示冲突：

```bash
# 打开有冲突的文件
# 查找 <<<<<<<, =======, >>>>>>> 标记

# 手动解决冲突后
git add .
git commit -m "fix: 解决合并冲突"
```

### 2. 想撤销刚才的提交？

```bash
# 撤销最近一次提交，但保留修改
git reset --soft HEAD~1

# 撤销最近一次提交，并丢弃修改（谨慎使用）
git reset --hard HEAD~1
```

### 3. 想恢复某个文件到之前的版本？

```bash
# 查看文件的提交历史
git log -- filename

# 恢复到指定版本
git checkout 提交哈希 -- filename
```

### 4. 提交后发现写错了提交信息？

```bash
# 修改最近一次提交信息
git commit --amend
```

### 5. 远程仓库有更新，本地有修改怎么办？

```bash
# 先暂存本地修改
git stash

# 拉取远程更新
git pull

# 恢复本地修改
git stash pop
```

---

## 参考资源

- [Git 官方文档](https://git-scm.com/doc)
- [GitHub 官方文档](https://docs.github.com/)
- [Pro Git 中文版](https://git-scm.com/book/zh/v2)
