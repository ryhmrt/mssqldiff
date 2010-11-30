package com.github.ryhmrt.mssqldiff.differ;

import com.github.ryhmrt.mssqldiff.data.Column;
import com.github.ryhmrt.mssqldiff.data.ColumnDiff;
import com.github.ryhmrt.mssqldiff.data.Diff;
import com.github.ryhmrt.mssqldiff.data.Permission;
import com.github.ryhmrt.mssqldiff.data.PermissionDiff;
import com.github.ryhmrt.mssqldiff.data.Table;
import com.github.ryhmrt.mssqldiff.data.TableDiff;

public class TableDiffer extends AbstractDiffer<Table, TableDiff> {

    private ColumnDiffer columnDiffer = new ColumnDiffer();
    private ListDiffer<Column, ColumnDiff, ColumnDiffer> columnListDiffer = new ListDiffer<Column, ColumnDiff, ColumnDiffer>();
    private PermissionDiffer permissionDiffer = new PermissionDiffer();
    private ListDiffer<Permission, PermissionDiff, PermissionDiffer> permissionListDiffer = new ListDiffer<Permission, PermissionDiff, PermissionDiffer>();
    
    @Override
    protected TableDiff detailDiff(Table from, Table to) {
        TableDiff diff = createDiff();
        diff.setColumnDiffs(columnListDiffer.diff(columnDiffer, from.getColumns(), to.getColumns()));
        diff.setPermissionDiffs(permissionListDiffer.diff(permissionDiffer, from.getPermissions(), to.getPermissions()));
        return setDiffData(diff, diff.getColumnDiffs().isEmpty() && diff.getPermissionDiffs().isEmpty() ? Diff.Type.EQUAL : Diff.Type.MODIFIED, from, to);
    }

    @Override
    protected TableDiff createDiff() {
        return new TableDiff();
    }
}
