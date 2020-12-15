## BBS 论坛

## 资料
- [Spring 文档](https://spring.io/guides)
- [Spring Web](https://spring.io/guides/gs/serving-web-content/)
- [es](https://elasticsearch.cn/explore)
- [bootstrap](https://v3.bootcss.com/getting-started/)
- [Github OAuth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)
- [GitHub第三方登录新方法](https://niter.cn/p/115)
- [okhttp异常java.lang.IllegalStateException: closed](https://blog.csdn.net/zhanghegang/article/details/78173034)
- [thymeleaf 条件判断语句if else](https://blog.csdn.net/leftfist/article/details/105611752)
- [Spring-boot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#setting-attribute-values)
## 工具
- git 
- [Visual Paradigm](https://www.visual-paradigm.com)
- [H2数据库](http://www.h2database.com/html/main.html)
- [Flyway](https://flywaydb.org/documentation/getstarted/firststeps/maven)
- [Project Lombok](https://projectlombok.org/)

## 脚本
```sql
create table USER
(
	ID INT auto_increment,
	ACCOUNT_ID VARCHAR(100),
	NAME VARCHAR(50),
	TOKEN VARCHAR(36),
	GMT_CREATE BIGINT,
	GMT_MODIFIED BIGINT,
	constraint USER_PK
		primary key (ID)
);
```

```bash
mvn flyway:migrate
```