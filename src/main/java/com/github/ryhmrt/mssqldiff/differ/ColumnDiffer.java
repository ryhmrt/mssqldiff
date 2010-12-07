package com.github.ryhmrt.mssqldiff.differ;

import com.github.ryhmrt.mssqldiff.data.Column;
import com.github.ryhmrt.mssqldiff.data.ColumnDiff;
import com.github.ryhmrt.mssqldiff.data.Diff.Type;

public class ColumnDiffer extends AbstractDiffer<Column, ColumnDiff> {

    @Override
    protected ColumnDiff detailDiff(Column from, Column to) {
        if (isDifferentIgnoreCase(from.getType(), to.getType()) ||
                isDifferent(from.getLength(), to.getLength()) ||
                isDifferent(from.isNullable(), to.isNullable()) ||
                isDifferent(from.isIdentity(), to.isIdentity()) ||
                isDifferent(from.getDefaultValue(), to.getDefaultValue())) {
            return createDiff(Type.MODIFIED, from, to);
        }
        return createDiff(Type.EQUAL, from, to);
    }

    private boolean isDifferentIgnoreCase(String a, String b) {
        return (a == null) ? (b != null) : (!a.equalsIgnoreCase(b));
    }

    @Override
    protected ColumnDiff createDiff() {
        return new ColumnDiff();
    }

}
