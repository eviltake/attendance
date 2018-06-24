package com.zzu.network.attendance.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Student {
    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "name")
    private String name;
    @Property(nameInDb = "sid")
    private String sid;
    @Property(nameInDb = "sclass")
    private String sclass;
    @Property(nameInDb = "noclass")
    private int noclass;
    @Property(nameInDb = "leava")
    private int leava;



    @Generated(hash = 335246205)
    public Student(Long id, String name, String sid, String sclass, int noclass, int leava) {
        this.id = id;
        this.name = name;
        this.sid = sid;
        this.sclass = sclass;
        this.noclass = noclass;
        this.leava = leava;
    }
    @Generated(hash = 1556870573)
    public Student() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSid() {
        return this.sid;
    }
    public void setSid(String sid) {
        this.sid = sid;
    }
    public String getSclass() {
        return this.sclass;
    }
    public void setSclass(String sclass) {
        this.sclass = sclass;
    }
    public int getNoclass() {return this.noclass;}
    public void setNoclass(int noclass) {
        this.noclass = noclass;
    }
    public int getLeava() {return this.leava;}
    public void setLeava(int leava) {
        this.leava = leava;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sid='" + sid + '\'' +
                ", sclass='" + sclass + '\'' +
                ", noclass=" + noclass +
                ",leava="+leava+
                '}';
    }
}
