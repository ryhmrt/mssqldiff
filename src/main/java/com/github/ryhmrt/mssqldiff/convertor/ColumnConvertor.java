package com.github.ryhmrt.mssqldiff.convertor;

import com.github.ryhmrt.mssqldiff.csv.SchemaCsv;
import com.github.ryhmrt.mssqldiff.data.Column;

public class ColumnConvertor {

    public Column convert(SchemaCsv csv) {
        return csvToColumn(csv);
    }

    private Column csvToColumn(SchemaCsv csv) {
        Column column = new Column();
        column.setTableName(csv.getTableName());
        column.setName(csv.getColumnName());
        column.setType(csv.getColumnType());
        column.setLength(csv.getLength());
        column.setPk(csv.isPk());
        column.setIdentity(csv.isIdentity());
        column.setNullable(csv.isNullable());
        column.setDefaultValue(csv.getDefaultValue());
        column.setDescription(csv.getColumnDescription());
        return column;
    }
}
