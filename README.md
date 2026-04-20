# Web 大作业 - 团队协作项目

基于 JSP + Servlet + MySQL 的 Web 应用项目。

## 技术栈

- **Java**: OpenJDK 17.0.15
- **Web**: JSP + Servlet 4.0
- **数据库**: MySQL 8.0
- **连接池**: Druid 1.2.20
- **构建工具**: Maven
- **开发工具**: IntelliJ IDEA

## 环境要求

- JDK 17+
- Maven 3.6+
- MySQL 8.0+
- IntelliJ IDEA (推荐)

## 快速开始

### 1. 克隆项目

```bash
git clone https://github.com/nchurolldog/web.git
cd web
```

### 2. 配置数据库

复制数据库配置示例文件并修改：

```bash
cp src/main/resources/db.properties.example src/main/resources/db.properties
```

编辑 `db.properties`，填入你的数据库配置：

```properties
db.url=jdbc:mysql://localhost:3306/teamwork_db?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai
db.username=root
db.password=你的密码
```

### 3. 创建数据库

```sql
CREATE DATABASE teamwork_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### 4. 导入项目到 IDEA

1. 打开 IntelliJ IDEA
2. 选择 `File` → `Open`
3. 选择项目根目录下的 `pom.xml`
4. 点击 `Open as Project`

### 5. 运行项目

1. 配置 Tomcat 服务器
2. 部署 `teamwork-web:war exploded`
3. 启动服务器
4. 访问 http://localhost:8080/

## 项目结构

```
web/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── nchu/
│   │   │           ├── servlet/      # Servlet 控制器
│   │   │           ├── service/      # 业务逻辑层
│   │   │           ├── dao/          # 数据访问层
│   │   │           ├── model/        # 实体类
│   │   │           └── util/         # 工具类
│   │   ├── resources/                # 配置文件
│   │   └── webapp/
│   │       ├── WEB-INF/
│   │       ├── jsp/                  # JSP 页面
│   │       └── static/               # 静态资源
│   └── test/                          # 测试代码
└── pom.xml
```

## 团队协作

请查看 [GIT_GUIDE.md](./GIT_GUIDE.md) 了解 Git 基本操作和团队协作规范。

## 许可证

本项目仅供学习使用。
