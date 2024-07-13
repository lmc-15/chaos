### IDE 安装
 > 使用 [JetBrains IntelliJ IDEA](https://www.jetbrains.com/idea/) 

### 必备插件
 - [Alibaba Java Coding Guidelines](https://plugins.jetbrains.com/plugin/10046-alibaba-java-coding-guidelines/)
 - [Git Commit Template](https://plugins.jetbrains.com/plugin/9861-git-commit-template/)
 - [Lombok](https://projectlombok.org/)

### 常用插件
 - [Grep Console](https://plugins.jetbrains.com/plugin/index?xmlId=GrepConsole)
 - [Package Search](https://plugins.jetbrains.com/plugin/12507-package-search/)
 - [Translation](https://plugins.jetbrains.com/plugin/8579-translation/)
 - [GitLab Integration plugin](https://plugins.jetbrains.com/plugin/index?xmlId=com.neon.intellij.plugins.gitlab)
 - [GitLab Projects Plugin](https://plugins.jetbrains.com/plugin/index?xmlId=com.failfast)

### 配置Maven

```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                          https://maven.apache.org/xsd/settings-1.0.0.xsd">
    <servers>
        <server>
            <id>releases</id>
            <username>user</username>
            <password>password</password>
        </server>
        <server>
            <id>snapshots</id>
            <username>user</username>
            <password>password</password>
        </server>
    </servers>
		<localRepository>~/.m2/repository</localRepository>
    <mirrors>
		<mirror>
	      <name>aliyun maven</name>
	      <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
	      <mirrorOf>central</mirrorOf>
	    </mirror>
        <mirror>
            <id>nexus</id>
            <mirrorOf>*</mirrorOf>
            <url>http://192.168.1.111:8081/repository/maven-public/</url>
        </mirror>
    </mirrors>


    <profiles>
        <profile>
            <id>dev</id>
            <repositories>
                <repository>
                    <id>Nexus</id>
                    <url>http://192.168.1.111:8081/repository/maven-public/</url>
                    <releases>
                        <enabled>true</enabled>
                    </releases>
                    <snapshots>
                        <enabled>true</enabled>
                    </snapshots>
                </repository>
            </repositories>
            <activation>
                <activeByDefault>true</activeByDefault>
                <jdk>1.8</jdk>
            </activation>
            <properties>
                <maven.compiler.source>1.8</maven.compiler.source>
                <maven.compiler.target>1.8</maven.compiler.target>
                <maven.compiler.compilerVersion>1.8</maven.compiler.compilerVersion>
            </properties>
        </profile>
    </profiles>
    <activeProfiles>
        <activeProfile>dev</activeProfile>
    </activeProfiles>
</settings>

```



###### 本页编辑      [@gongshiwen](http://192.168.1.23/gongshiwen) <img src="http://192.168.1.23/uploads/-/system/user/avatar/10/avatar.png?width=100" style="zoom:10%;" />

