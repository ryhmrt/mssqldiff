package com.github.ryhmrt.mssqldiff.convertor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.ryhmrt.mssqldiff.csv.SchemaCsv;
import com.github.ryhmrt.mssqldiff.data.Column;


public class ColumnConvertorTest {

    @Test
    public void testConvert() {
        SchemaCsv csv = new SchemaCsv();
        csv.setTableName("tableName");
        csv.setObjectType("U");
        csv.setTableDescription("tableDescription");
        csv.setColumnName("columnName");
        csv.setColumnType("columnType");
        csv.setLength(99);
        csv.setPk(true);
        csv.setIdentity(true);
        csv.setNullable(true);
        csv.setDefaultValue("defaultValue");
        csv.setColumnDescription("columnDescription");
        csv.setUserName("userName");
        csv.setCanSelect(true);
        csv.setCanInsert(true);
        csv.setCanUpdate(true);
        csv.setCanDelete(true);

        ColumnConvertor target = new ColumnConvertor();

        Column column = target.convert(csv);
        assertEquals("tableName", column.getTableName());
        assertEquals("columnName", column.getName());
        assertEquals("columnType",column.getType());
        assertEquals(99, column.getLength());
        assertEquals(true, column.isPk());
        assertEquals(true, column.isIdentity());
        assertEquals(true, column.isNullable());
        assertEquals("defaultValue",column.getDefaultValue());
        assertEquals("columnDescription", column.getDescription());
        
    }
}
