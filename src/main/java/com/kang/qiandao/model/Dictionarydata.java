package com.kang.qiandao.model;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "dictionarydata")
public class Dictionarydata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private Integer dictValue;
    private String dictdataName;
    private Integer dictdataValue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getDictValue() {
        return dictValue;
    }

    public void setDictValue(Integer dictValue) {
        this.dictValue = dictValue;
    }

    public String getDictdataName() {
        return dictdataName;
    }

    public void setDictdataName(String dictdataName) {
        this.dictdataName = dictdataName;
    }

    public Integer getDictdataValue() {
        return dictdataValue;
    }

    public void setDictdataValue(Integer dictdataValue) {
        this.dictdataValue = dictdataValue;
    }

    @Override
    public String toString() {
        return "Dictionarydata{" +
                "id='" + id + '\'' +
                ", dictValue=" + dictValue +
                ", dictdataName='" + dictdataName + '\'' +
                ", dictdataValue=" + dictdataValue +
                '}';
    }
}
