package com.github.ryhmrt.mssqldiff.differ;

import com.github.ryhmrt.mssqldiff.data.Diff;

public abstract class AbstractDiffer<DATA, DIFF extends Diff<DATA>> {
    public DIFF diff(DATA from, DATA to) {
        if (from == null) {
            return createDiff(Diff.Type.CREATED, from, to);
        }
        if (to == null) {
            return createDiff(Diff.Type.DROPPED, from, to);
        }
        return detailDiff(from, to);
    }

    protected boolean isDifferent(Object a, Object b) {
        return (a != b) && (a == null ^ b == null) && (!a.equals(b));
    }

    protected DIFF createDiff(Diff.Type type, DATA from, DATA to) {
        DIFF diff = createDiff();
        diff.setType(type);
        diff.setFrom(from);
        diff.setTo(to);
        return diff;
    }

    protected abstract DIFF detailDiff(DATA from, DATA to);
    protected abstract DIFF createDiff();
}
