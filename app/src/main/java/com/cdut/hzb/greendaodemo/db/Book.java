package com.cdut.hzb.greendaodemo.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by hans on 2018/2/27 0027.
 * 多表映射关联  一对多：一个人有很多本书
 * 关系描述： 多本书对应一个人， 所以每本书的外键id都是一样的， 并且每本书的外键Id都是老师的Id,这样就构成了1对多的关系。
 */

@Entity
public class Book {
    @Id
    private Long id;

    private Long foreignKeyId;

    private String bookName;

    @Generated(hash = 989836994)
    public Book(Long id, Long foreignKeyId, String bookName) {
        this.id = id;
        this.foreignKeyId = foreignKeyId;
        this.bookName = bookName;
    }

    @Generated(hash = 1839243756)
    public Book() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getForeignKeyId() {
        return this.foreignKeyId;
    }

    public void setForeignKeyId(Long foreignKeyId) {
        this.foreignKeyId = foreignKeyId;
    }

    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
