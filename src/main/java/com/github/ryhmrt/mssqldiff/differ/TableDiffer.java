package com.github.ryhmrt.mssqldiff.differ;

import java.util.List;

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
        List<ColumnDiff> columnDiffs = columnListDiffer.diff(columnDiffer, from.getColumns(), to.getColumns());
        List<PermissionDiff> permissionDiffs = permissionListDiffer.diff(permissionDiffer, from.getPermissions(), to.getPermissions());
        TableDiff diff = createDiff(columnDiffs.isEmpty() && permissionDiffs.isEmpty() ? Diff.Type.EQUAL : Diff.Type.MODIFIED, from, to);
        diff.setColumnDiffs(columnDiffs);
        diff.setPermissionDiffs(permissionDiffs);
        return diff;
    }

    @Override
    protected TableDiff createDiff() {
        return new TableDiff();
    }
}
