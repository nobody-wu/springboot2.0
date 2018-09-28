package com.example.springboot2docker.util;

import java.io.Serializable;

public class Column implements Serializable {
    private String columnCode;
    private Object columnValue;

    public Column() {
    }

    public Column(String columnCode, Object columnValue) {
        this.columnCode = columnCode;
        this.columnValue = columnValue;
    }

    public String getColumnCode() {
        return this.columnCode;
    }

    public Column setColumnCode(String columnCode) {
        this.columnCode = columnCode;
        return this;
    }

    public Object getColumnValue() {
        return this.columnValue;
    }

    public Column setColumnValue(Object columnValue) {
        this.columnValue = columnValue;
        return this;
    }
}
