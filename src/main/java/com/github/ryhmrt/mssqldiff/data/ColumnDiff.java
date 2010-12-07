package com.github.ryhmrt.mssqldiff.data;

import com.github.ryhmrt.mssqldiff.util.SqlUtil;


public class ColumnDiff extends Diff<Column> {
    
    @Override
    public String getName() {
        return getType() == Type.CREATED ? getTo().getName() : getFrom().getName();
    }

    @Override
    public String toCreateSql() {
        return "-- missing column [" + getTo().getName() + "]\n" + SqlUtil.addColumn(getTo());
    }

    @Override
    public String toDropSql() {
        Column column = getFrom();
        return "-- unnecessary column: " + SqlUtil.columnDefine(getFrom()) + "\n" + SqlUtil.dropColumn(column.getTableName(), column.getName());
    }

    @Override
    public String toModifySql() {
        return "-- modified column from: " + SqlUtil.columnDefine(getFrom()) + "\n" + "-- to: " + SqlUtil.columnDefine(getTo()) + "\n";
    }
}
