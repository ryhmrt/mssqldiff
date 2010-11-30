package com.github.ryhmrt.mssqldiff.data;

import com.github.ryhmrt.mssqldiff.util.SqlUtil;


public class ColumnDiff extends Diff<Column> {
    
    @Override
    public String getName() {
        return getType() == Type.CREATED ? getTo().getName() : getFrom().getName();
    }

    @Override
    public String toCreateSql() {
        return SqlUtil.addColumn(getTo());
    }

    @Override
    public String toDropSql() {
        Column column = getFrom();
        return SqlUtil.dropColumn(column.getTableName(), column.getName());
    }

    @Override
    public String toModifySql() {
        return "-- different column " + getName() + "\n";
    }
}
