package com.joezhou.jpa;

import java.lang.reflect.Field;

/**@author Joe*/
public class CreateTableTool {
    private Class<?> instance;

    public CreateTableTool(Class<?> instance) {
        this.instance = instance;
    }

    public void build() {
        String sql = this.getCreateTableSql();
        System.out.println(sql);
        //TODO 调用JDBC的executeUpdate方法发送这个SQL即可完成造表
    }

    private String getCreateTableSql() {
        String tableName = this.getTableName();
        String columnsFormatString = this.getColumnsFormatString();
        String idName = this.getIdName();
        String sqlFormat =
                "CREATE TABLE `%s` ( "
                        + "`%s` INTEGER(11) AUTO_INCREMENT NOT NULL "
                        + "%s, "
                        + "PRIMARY KEY(`%s`) "
                        + ") ENGINE=InnoDB DEFAULT CHARSET=utf8";
        return String.format(sqlFormat, tableName, idName, columnsFormatString, idName);
    }

    private String getTableName() {
        return instance.getAnnotation(Table.class).value();
    }

    private String getColumnsFormatString() {
        StringBuilder columns = new StringBuilder();
        Field[] fields = instance.getDeclaredFields();
        for (Field field : fields) {

            // 获取每个属性上的@Column注解
            Column columnAnnotation = field.getAnnotation(Column.class);

            // 只要属性上存在@Column注解，就获取其中的name、type和length
            if (columnAnnotation != null) {
                String name = columnAnnotation.name();
                String type = columnAnnotation.type();
                int length = columnAnnotation.length();

                // ", user_name varchar(50)"
                String line = String.format(", `%s` %s(%d)", name, type, length);
                columns.append(line);
            }
        }
        return columns.toString();
    }

    private String getIdName() {
        String idName = "";
        Field[] fields = instance.getDeclaredFields();
        for (Field field : fields) {
            // 获取每个属性上的@Id注解
            Id idAnnotation = field.getAnnotation(Id.class);

            // 只要属性上存在@Id注解，就获取属性名
            if (idAnnotation != null) {
                idName = field.getName();
                break;
            }
        }
        return idName;
    }

}