package com.github.ryhmrt.mssqldiff.differ;

import com.github.ryhmrt.mssqldiff.data.Column;
import com.github.ryhmrt.mssqldiff.data.ColumnDiff;

public class ColumnDiffer extends AbstractDiffer<Column, ColumnDiff> {

    @Override
    protected ColumnDiff detailDiff(Column from, Column to) {
        return null;
    }

    @Override
    protected ColumnDiff createDiff() {
        return new ColumnDiff();
    }

}
