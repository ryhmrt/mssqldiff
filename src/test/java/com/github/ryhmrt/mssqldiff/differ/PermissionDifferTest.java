package com.github.ryhmrt.mssqldiff.differ;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import com.github.ryhmrt.mssqldiff.data.Diff;
import com.github.ryhmrt.mssqldiff.data.Permission;
import com.github.ryhmrt.mssqldiff.data.PermissionDiff;
import com.github.ryhmrt.mssqldiff.differ.PermissionDiffer;


public class PermissionDifferTest {

    @Test
    public void testDiffDropped() {
        PermissionDiffer target = new PermissionDiffer();
        Permission from = new Permission();
        Permission to = null;

        PermissionDiff diff = target.diff(from, to);
        assertEquals(Diff.Type.DROPPED, diff.getType());
        assertSame(from, diff.getFrom());
        assertSame(to, diff.getTo());
    }

    @Test
    public void testDiffCreated() {
        PermissionDiffer target = new PermissionDiffer();
        Permission from = null;
        Permission to = new Permission();

        PermissionDiff diff = target.diff(from, to);
        assertEquals(Diff.Type.CREATED, diff.getType());
        assertSame(from, diff.getFrom());
        assertSame(to, diff.getTo());
    }
}
