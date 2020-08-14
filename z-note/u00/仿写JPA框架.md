> 放入JDBC章节

# 2. 仿写JPA框架

**需求：** 通过注解加反射，我们来设计一个可以通过对pojo的注解的指定，来完成SQL造表的工具类。
1. 设计注解类 `@Table`：运行期有效，作用在类上，参数 `value` 对应数据库表名，必填。
2. 设计注解类 `@Id`：运行期有效，作用在属性上，空注解，对应数据库主键，主键名即字段名，固定 `INTEGER(11)`。
3. 设计注解类 `@Column`：运行期有效，作用在属性上：
    - 参数 `name` 对应数据库字段名，必填。
    - 参数 `type` 对应数据库字段类型，默认varchar
    - 参数 `length` 对应数据库字段大小，默认50
4. 设计实体类 `User.java`，其中需要有 `id`、`userName` 和 `userAge` 这个三个私有属性。
5. 设计工具类 `CreateTableTool.java`：
    - `CreateTableTool(Class<?> instance)`：构造时传入User类对象作为参数。
    - `void build()`：根据建表SQL语句执行建表操作。
    - `String getCreateTableSql()`：获取建表SQL语句。
    - `String getTableName()`：获取 `@Table` 注解中的name值作为表名。
    - `String getColumns()`：获取 `@Column` 注解中的name，type和length值，并进行字符串组装：
        - `user_name varchar(50),` 
        - `user_age integer(10), ` 
    - `String getIdName()`：获取 `@Id` 注解所在的字段名作为数据库普通字段名。

**SQL：** 最终生成的SQL字符串内容
```sql
CREATE TABLE `userInfo` (
    `id` INTEGER(11) AUTO_INCREMENT NOT NULL, 
    `user_name` varchar(50), 
    `user_age` integer(10), 
    PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
```

## 2.1 设计注解类@Table

**源码：**
```java
/**
 * @author JoeZhou
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Table {
    String value();
}
```

## 2.2 设计注解类@Id

**源码：**
```java
/**
 * @author JoeZhou
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Id { }
```

## 2.3 设计注解类@Column

**源码：**
```java
/**
 * @author JoeZhou
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Column {
    String name();
    String type() default "varchar";
    int length() default 50;
}
```

## 2.4 设计实体类User

**源码：** User.java
```java
/**
 * @author JoeZhou
 */
@Table("userInfo")
public class User implements Serializable {
    @Id
    private Integer id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_age", type = "integer", length = 10)
    private String userAge;
}
```

## 2.5 设计工具类CreateTableTool

**源码：** CreateTableTool.java
```java
/**
 * @author JoeZhou
 */
public class CreateTableTool {

    private Class<?> instance;

    public CreateTableTool(Class<?> instance) {
        this.instance = instance;
    }

    public void build() {
        System.out.println(this.getCreateTableSql());
        //TODO 调用JDBC的executeUpdate方法发送这个SQL即可完成造表
    }

    private String getCreateTableSql() {
        String tableName = this.getTableName();
        String columns = this.getColumns();
        String idName = this.getIdName();
        String sqlFormat =
                "CREATE TABLE `%s` ("
                        + "`%s` INTEGER(11) AUTO_INCREMENT NOT NULL"
                        + "%s "
                        + "PRIMARY KEY(`%s`)"
                        + ") ENGINE=InnoDB DEFAULT CHARSET=utf8";
        return String.format(sqlFormat, tableName, idName, columns, idName);
    }

    private String getTableName() {
        return instance.getAnnotation(Table.class).value();
    }

    private String getColumns() {
        StringBuilder columns = new StringBuilder();
        for (Field field : instance.getDeclaredFields()) {
            Column columnAnnotation = field.getAnnotation(Column.class);
            if (columnAnnotation != null) {
                String name = columnAnnotation.name();
                String type = columnAnnotation.type();
                int length = columnAnnotation.length();
                // ", user_name varchar(50)"
                columns.append(String.format(", `%s` %s(%d)", name, type, length));
            }
        }
        columns.append(",");
        return columns.toString();
    }

    private String getIdName() {
        String idName = null;
        for (Field field : instance.getDeclaredFields()) {
            Id idAnnotation = field.getAnnotation(Id.class);
            if (idAnnotation != null) {
                idName = field.getName();
                break;
            }
        }
        return idName;
    }
}
```

## 2.6 设计测试类JpaTest

**测试：** JpaTest.java
```java
/**@author Joe*/
public class JpaTest {
    @Test
    public void createTable() {
        new CreateTableTool(User.class).build();
    }
}
```
