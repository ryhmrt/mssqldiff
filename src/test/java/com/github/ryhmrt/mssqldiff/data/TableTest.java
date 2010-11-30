package com.github.ryhmrt.mssqldiff.data;

import static org.junit.Assert.*;

import org.junit.Test;

public class TableTest {

    @Test
    public void testToString() {
        Table table = new Table();
        table.setName("myTableName");
        assertEquals("Table[myTableName]", table.toString());
    }

    @Test
    public void testEquals() {
        Table table1 = new Table();
        table1.setName("myTableName");
        Table table2 = new Table();
        table2.setName("myTableName");
        Table table3 = new Table();
        table3.setName("someTableName");
        
        assertTrue(table1.equals(table2));
        assertFalse(table1.equals(table3));
    }
}
