package com.joezhou.jpa;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class MyJpaTest {
    @Test
    public void jpa(){
        new CreateTableTool(User.class).build();
        /**
         * CREATE TABLE `userInfo` (
         *  `id` INTEGER(11) AUTO_INCREMENT NOT NULL ,
         *  `user_name` varchar(50),
         *  `user_age` integer(10),
         *  PRIMARY KEY(`id`)
         * ) ENGINE=InnoDB DEFAULT CHARSET=utf8
         */
    }
}
