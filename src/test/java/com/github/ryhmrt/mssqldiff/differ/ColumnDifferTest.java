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

    @Test
    public void testDiffModified() {
        ColumnDiffer target = new ColumnDiffer();
        Column from = new Column();
        Column to = new Column();

        from.setType("int");
        ColumnDiff diff = target.diff(from, to);
        assertEquals(Diff.Type.MODIFIED, diff.getType());
        assertSame(from, diff.getFrom());
        assertSame(to, diff.getTo());
        from.setType(null);

        to.setType("int");
        diff = target.diff(from, to);
        assertEquals(Diff.Type.MODIFIED, diff.getType());
        to.setType(null);

        from.setType("bigint");
        to.setType("int");
        diff = target.diff(from, to);
        assertEquals(Diff.Type.MODIFIED, diff.getType());
        from.setType(null);
        to.setType(null);
}

    @Test
    public void testDiffEqual() {
        ColumnDiffer target = new ColumnDiffer();
        Column from = new Column();
        Column to = new Column();

        ColumnDiff diff = target.diff(from, to);
        assertEquals(Diff.Type.EQUAL, diff.getType());
        assertSame(from, diff.getFrom());
        assertSame(to, diff.getTo());

        from.setType("int");
        to.setType("INT");
        diff = target.diff(from, to);
        assertEquals(Diff.Type.EQUAL, diff.getType());
    }
}
