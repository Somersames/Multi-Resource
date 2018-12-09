package com.somersames.dto.mongo;

import com.somersames.constant.MongoConstant;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author szh
 * @create 2018-12-09 22:47
 **/
@Document(MongoConstant.MongoDB2)
public class MongoDB2 {
    private String id;

    private Date now;

    private String content;


    public MongoDB2() {
        this.now = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
