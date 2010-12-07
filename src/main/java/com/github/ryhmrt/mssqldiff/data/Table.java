package com.github.ryhmrt.mssqldiff.data;

import java.util.List;

public class Table {

    private String name;
    private String type;
    private String description;
    private List<Column> columns;
    private List<Permission> permissions;

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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Column> getColumns() {
        return columns;
    }
    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }
    public List<Permission> getPermissions() {
        return permissions;
    }
    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Table) {
            Table t = (Table)o;
            return name.equalsIgnoreCase(t.name);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Table[" + name + "]";
    }
}
