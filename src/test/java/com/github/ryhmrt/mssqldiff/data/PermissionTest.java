package com.github.ryhmrt.mssqldiff.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class PermissionTest {

    @Test
    public void testToString() {
        Permission permission = new Permission();
        permission.setTableName("myTableName");
        permission.setUserName("myUserName");
        assertEquals("Permission[myUserName] of Table[myTableName]", permission.toString());
    }

    @Test
    public void testEquals() {
        Permission permission1 = new Permission();
        permission1.setTableName("myTableName");
        permission1.setUserName("myUserName");
        Permission permission2 = new Permission();
        permission2.setTableName("myTableName");
        permission2.setUserName("myUserName");
        Permission permission3 = new Permission();
        permission3.setTableName("someTableName");
        permission3.setUserName("myUserName");
        Permission permission4 = new Permission();
        permission4.setTableName("myTableName");
        permission4.setUserName("someUserName");
        
        assertTrue(permission1.equals(permission2));
        assertFalse(permission1.equals(permission3));
        assertFalse(permission1.equals(permission4));
    }
}
