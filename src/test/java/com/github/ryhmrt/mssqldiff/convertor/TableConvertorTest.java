package com.github.ryhmrt.mssqldiff.convertor;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.github.ryhmrt.mssqldiff.csv.SchemaCsv;
import com.github.ryhmrt.mssqldiff.data.Column;
import com.github.ryhmrt.mssqldiff.data.Permission;
import com.github.ryhmrt.mssqldiff.data.Table;

public class TableConvertorTest {

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

        TableConvertor target = new TableConvertor();

        Table table = target.convert(csv);
        assertEquals("tableName", table.getName());
        assertEquals("U", table.getType());
        assertEquals("tableDescription", table.getDescription());
    }

    @Test
    public void testConvertWithColumn() {
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

        TableConvertor target = new TableConvertor();

        Table table = target.convert(csv);
        assertEquals("tableName", table.getName());
        assertEquals("U", table.getType());
        assertEquals("tableDescription", table.getDescription());

        List<Column> columns = table.getColumns();
        assertEquals(1, columns.size());

        Column column = columns.get(0);
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

    @Test
    public void testConvertWithPermission() {
        SchemaCsv csv = new SchemaCsv();
        csv.setTableName("tableName");
        csv.setObjectType("U");
        csv.setTableDescription("tableDescription");
        csv.setColumnName("tableName");
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

        TableConvertor target = new TableConvertor();

        Table table = target.convert(csv);
        assertEquals("tableName", table.getName());
        assertEquals("U", table.getType());
        assertEquals("tableDescription", table.getDescription());

        List<Permission> permissions = table.getPermissions();
        assertEquals(1, permissions.size());

        Permission permission = permissions.get(0);
        assertEquals("tableName", permission.getTableName());
        assertEquals("userName", permission.getUserName());
        assertEquals(true, permission.isCanSelect());
        assertEquals(true, permission.isCanInsert());
        assertEquals(true, permission.isCanUpdate());
        assertEquals(true, permission.isCanDelete());
    }

    @Test
    public void testConvertWithoutPermission1() {
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
        csv.setUserName("");
        csv.setCanSelect(true);
        csv.setCanInsert(true);
        csv.setCanUpdate(true);
        csv.setCanDelete(true);

        TableConvertor target = new TableConvertor();

        Table table = target.convert(csv);
        assertEquals("tableName", table.getName());
        assertEquals("U", table.getType());
        assertEquals("tableDescription", table.getDescription());

        List<Permission> permissions = table.getPermissions();
        assertEquals(0, permissions.size());
    }

    @Test
    public void testConvertWithoutPermission2() {
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
        csv.setUserName(null);
        csv.setCanSelect(true);
        csv.setCanInsert(true);
        csv.setCanUpdate(true);
        csv.setCanDelete(true);

        TableConvertor target = new TableConvertor();

        Table table = target.convert(csv);
        assertEquals("tableName", table.getName());
        assertEquals("U", table.getType());
        assertEquals("tableDescription", table.getDescription());

        List<Permission> permissions = table.getPermissions();
        assertEquals(0, permissions.size());
    }

    @Test
    public void testConvertMultipul() {
        SchemaCsv csv1 = new SchemaCsv();
        csv1.setTableName("tableName1");
        csv1.setObjectType("U");
        csv1.setTableDescription("tableDescription");
        csv1.setColumnName("columnName1A");
        csv1.setColumnType("columnType");
        csv1.setLength(99);
        csv1.setPk(true);
        csv1.setIdentity(true);
        csv1.setNullable(true);
        csv1.setDefaultValue("defaultValue");
        csv1.setColumnDescription("columnDescription");
        csv1.setUserName("userName1");
        csv1.setCanSelect(true);
        csv1.setCanInsert(true);
        csv1.setCanUpdate(true);
        csv1.setCanDelete(true);

        SchemaCsv csv2 = new SchemaCsv();
        csv2.setTableName("tableName1");
        csv2.setObjectType("U");
        csv2.setTableDescription("tableDescription");
        csv2.setColumnName("columnName1A");
        csv2.setColumnType("columnType");
        csv2.setLength(99);
        csv2.setPk(true);
        csv2.setIdentity(true);
        csv2.setNullable(true);
        csv2.setDefaultValue("defaultValue");
        csv2.setColumnDescription("columnDescription");
        csv2.setUserName("userName2");
        csv2.setCanSelect(true);
        csv2.setCanInsert(true);
        csv2.setCanUpdate(true);
        csv2.setCanDelete(true);

        SchemaCsv csv3 = new SchemaCsv();
        csv3.setTableName("tableName1");
        csv3.setObjectType("U");
        csv3.setTableDescription("tableDescription");
        csv3.setColumnName("columnName1B");
        csv3.setColumnType("columnType");
        csv3.setLength(99);
        csv3.setPk(true);
        csv3.setIdentity(true);
        csv3.setNullable(true);
        csv3.setDefaultValue("defaultValue");
        csv3.setColumnDescription("columnDescription");
        csv3.setUserName("userName1");
        csv3.setCanSelect(true);
        csv3.setCanInsert(true);
        csv3.setCanUpdate(true);
        csv3.setCanDelete(true);

        SchemaCsv csv4 = new SchemaCsv();
        csv4.setTableName("tableName2");
        csv4.setObjectType("U");
        csv4.setTableDescription("tableDescription");
        csv4.setColumnName("columnName2A");
        csv4.setColumnType("columnType");
        csv4.setLength(99);
        csv4.setPk(true);
        csv4.setIdentity(true);
        csv4.setNullable(true);
        csv4.setDefaultValue("defaultValue");
        csv4.setColumnDescription("columnDescription");
        csv4.setUserName(null);
        csv4.setCanSelect(true);
        csv4.setCanInsert(true);
        csv4.setCanUpdate(true);
        csv4.setCanDelete(true);

        TableConvertor target = new TableConvertor();

        Table table1 = target.convert(csv1);
        target.convert(csv2);
        target.convert(csv3);
        Table table2 = target.convert(csv4);
        assertEquals("tableName1", table1.getName());
        assertEquals("tableName2", table2.getName());

        List<Column> columns1 = table1.getColumns();
        assertEquals(2, columns1.size());
        List<Column> columns2 = table2.getColumns();
        assertEquals(1, columns2.size());

        Column column1a = columns1.get(0);
        assertEquals("tableName1", column1a.getTableName());
        assertEquals("columnName1A", column1a.getName());
        Column column1b = columns1.get(1);
        assertEquals("tableName1", column1b.getTableName());
        assertEquals("columnName1B", column1b.getName());
        Column column2a = columns2.get(0);
        assertEquals("tableName2", column2a.getTableName());
        assertEquals("columnName2A", column2a.getName());

        List<Permission> permissions1 = table1.getPermissions();
        assertEquals(2, permissions1.size());
        List<Permission> permissions2 = table2.getPermissions();
        assertEquals(0, permissions2.size());

        Permission permission1 = permissions1.get(0);
        assertEquals("tableName1", permission1.getTableName());
        assertEquals("userName1", permission1.getUserName());
        Permission permission2 = permissions1.get(1);
        assertEquals("tableName1", permission2.getTableName());
        assertEquals("userName2", permission2.getUserName());
    }

}
