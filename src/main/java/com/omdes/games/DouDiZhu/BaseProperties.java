package com.omdes.games.doudizhu;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Solitary.Wang
 * Date: 2017/6/22
 * Time: 20:21
 */
public class BaseProperties implements Serializable {
    protected long id;
    protected String flag;
    protected String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
