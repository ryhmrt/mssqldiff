package com.github.ryhmrt.mssqldiff.differ;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import com.github.ryhmrt.mssqldiff.data.Diff;
import com.github.ryhmrt.mssqldiff.data.Table;
import com.github.ryhmrt.mssqldiff.data.TableDiff;
import com.github.ryhmrt.mssqldiff.differ.TableDiffer;


public class TableDifferTest {

    @Test
    public void testDiffDropped() {
        TableDiffer target = new TableDiffer();
        Table from = new Table();
        Table to = null;

        TableDiff diff = target.diff(from, to);
        assertEquals(Diff.Type.DROPPED, diff.getType());
        assertSame(from, diff.getFrom());
        assertSame(to, diff.getTo());
    }

    @Test
    public void testDiffCreated() {
        TableDiffer target = new TableDiffer();
        Table from = null;
        Table to = new Table();

        TableDiff diff = target.diff(from, to);
        assertEquals(Diff.Type.CREATED, diff.getType());
        assertSame(from, diff.getFrom());
        assertSame(to, diff.getTo());
    }
}
