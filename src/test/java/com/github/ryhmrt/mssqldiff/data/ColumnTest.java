package com.github.ryhmrt.mssqldiff.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class ColumnTest {

    @Test
    public void testToString() {
        Column column = new Column();
        column.setTableName("myTableName");
        column.setName("myColumnName");
        assertEquals("Column[myColumnName] of Table[myTableName]", column.toString());
    }

    @Test
    public void testEquals() {
        Column column1 = new Column();
        column1.setTableName("myTableName");
        column1.setName("myColumnName");
        Column column2 = new Column();
        column2.setTableName("myTableName");
        column2.setName("myColumnName");
        Column column3 = new Column();
        column3.setTableName("someTableName");
        column3.setName("myColumnName");
        Column column4 = new Column();
        column4.setTableName("myTableName");
        column4.setName("someColumnName");
        
        assertTrue(column1.equals(column2));
        assertFalse(column1.equals(column3));
        assertFalse(column1.equals(column4));
    }
}
