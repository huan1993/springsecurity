# springsecurity
springboot整合spring security的学习工程

项目采用jdk8
使用spring io 管理jar包
父项目中的依赖

```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>io.spring.platform</groupId>
      <artifactId>platform-bom</artifactId>
      <version>Brussels-SR1</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>
```