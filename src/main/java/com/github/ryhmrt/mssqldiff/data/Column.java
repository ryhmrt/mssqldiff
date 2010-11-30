package com.github.ryhmrt.mssqldiff.data;

public class Column {

    private String tableName;
    private String name;
    private String type;
    private int length;
    private boolean pk;
    private boolean identity;
    private boolean nullable;
    private String defaultValue;
    private String description;

    public String getTableName() {
        return tableName;
    }
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public boolean isPk() {
        return pk;
    }
    public void setPk(boolean pk) {
        this.pk = pk;
    }
    public boolean isIdentity() {
        return identity;
    }
    public void setIdentity(boolean identity) {
        this.identity = identity;
    }
    public boolean isNullable() {
        return nullable;
    }
    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }
    public String getDefaultValue() {
        return defaultValue;
    }
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Column) {
            Column c = (Column)o;
            return tableName.equals(c.tableName) && name.equals(c.name);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Column[" + name + "] of Table[" + tableName + "]";
    }
}
