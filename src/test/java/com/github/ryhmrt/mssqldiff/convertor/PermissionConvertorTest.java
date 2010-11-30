package com.github.ryhmrt.mssqldiff.convertor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.github.ryhmrt.mssqldiff.csv.SchemaCsv;
import com.github.ryhmrt.mssqldiff.data.Permission;


public class PermissionConvertorTest {

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

        PermissionConvertor target = new PermissionConvertor();

        Permission permission = target.convert(csv);
        assertEquals("tableName", permission.getTableName());
        assertEquals("userName", permission.getUserName());
        assertEquals(true, permission.isCanSelect());
        assertEquals(true, permission.isCanInsert());
        assertEquals(true, permission.isCanUpdate());
        assertEquals(true, permission.isCanDelete());
        
    }

    @Test
    public void testConvertEmptyUserName() {
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

        PermissionConvertor target = new PermissionConvertor();

        Permission permission = target.convert(csv);
        assertNull(permission);
        
    }

    @Test
    public void testConvertNullUserName() {
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

        PermissionConvertor target = new PermissionConvertor();

        Permission permission = target.convert(csv);
        assertNull(permission);
        
    }
}
