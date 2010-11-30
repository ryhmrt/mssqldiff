package com.github.ryhmrt.mssqldiff.differ;

import com.github.ryhmrt.mssqldiff.data.Diff;

public abstract class AbstractDiffer<DATA, DIFF extends Diff<DATA>> {
    public DIFF diff(DATA from, DATA to) {
        if (from == null) {
            return setDiffData(createDiff(), Diff.Type.CREATED, from, to);
        }
        if (to == null) {
            return setDiffData(createDiff(), Diff.Type.DROPPED, from, to);
        }
        return detailDiff(from, to);
    }

    protected DIFF setDiffData(DIFF diff, Diff.Type type, DATA from, DATA to) {
        diff.setType(type);
        diff.setFrom(from);
        diff.setTo(to);
        return diff;
    }

    protected abstract DIFF detailDiff(DATA from, DATA to);
    protected abstract DIFF createDiff();
}
