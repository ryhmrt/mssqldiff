package com.github.ryhmrt.mssqldiff.differ;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import com.github.ryhmrt.mssqldiff.data.Column;
import com.github.ryhmrt.mssqldiff.data.ColumnDiff;
import com.github.ryhmrt.mssqldiff.data.Diff;
import com.github.ryhmrt.mssqldiff.differ.ColumnDiffer;


public class ColumnDifferTest {

    @Test
    public void testDiffDropped() {
        ColumnDiffer target = new ColumnDiffer();
        Column from = new Column();
        Column to = null;

        ColumnDiff diff = target.diff(from, to);
        assertEquals(Diff.Type.DROPPED, diff.getType());
        assertSame(from, diff.getFrom());
        assertSame(to, diff.getTo());
    }

    @Test
    public void testDiffCreated() {
        ColumnDiffer target = new ColumnDiffer();
        Column from = null;
        Column to = new Column();

        ColumnDiff diff = target.diff(from, to);
        assertEquals(Diff.Type.CREATED, diff.getType());
        assertSame(from, diff.getFrom());
        assertSame(to, diff.getTo());
    }
}
