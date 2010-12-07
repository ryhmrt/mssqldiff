package com.github.ryhmrt.mssqldiff.data;

import java.util.Collections;
import java.util.List;

import com.github.ryhmrt.mssqldiff.util.SqlUtil;

public class TableDiff extends Diff<Table> {

    private List<ColumnDiff> columnDiffs = Collections.emptyList();
    private List<PermissionDiff> permissionDiffs = Collections.emptyList();

    public void setColumnDiffs(List<ColumnDiff> columnDiffs) {
        this.columnDiffs = columnDiffs;
    }

    public List<ColumnDiff> getColumnDiffs() {
        return columnDiffs;
    }

    public void setPermissionDiffs(List<PermissionDiff> permissionDiffs) {
        this.permissionDiffs = permissionDiffs;
    }

    public List<PermissionDiff> getPermissionDiffs() {
        return permissionDiffs;
    }

    @Override
    public String getName() {
        return getType() == Type.CREATED ? getTo().getName() : getFrom().getName();
    }

    @Override
    public String toCreateSql() {
        return toCreateSql(true);
    }

    protected String toCreateSql(boolean withPermission) {
        Table table = getTo();
        StringBuilder sb = new StringBuilder();
        if (table.getType().equals("U")) {
            sb.append("-- missing table [");
            sb.append(getName());
            sb.append("]");
            sb.append("\n");
            sb.append(SqlUtil.createTable(getTo()));
        } else if (table.getType().equals("V")) {
            sb.append("-- missing view [");
            sb.append(getName());
            sb.append("]");
            sb.append("\n");
        }
        if (withPermission) {
            for (PermissionDiff p : getPermissionDiffs()) {
                sb.append(p.toSql());
            }
        }
        return sb.toString();
    }

    @Override
    public String toDropSql() {
        Table table = getFrom();
        StringBuilder sb = new StringBuilder();
        if (table.getType().equals("U")) {
            sb.append("-- unnecessary table [");
            sb.append(getName());
            sb.append("]");
            sb.append("\n");
            sb.append("DROP TABLE [");
            sb.append(getName());
            sb.append("]");
            sb.append("\n");
        } else if (table.getType().equals("V")) {
            sb.append("-- unnecessary view [");
            sb.append(getName());
            sb.append("]");
            sb.append("\n");
            sb.append("DROP VIEW [");
            sb.append(getName());
            sb.append("]");
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toModifySql() {
        return toModifySql(true);
    }

    protected String toModifySql(boolean withPermission) {
        Table table = getFrom();
        StringBuilder sb = new StringBuilder();
        if (table.getType().equals("U")) {
            sb.append("-- different table [");
            sb.append(getName());
            sb.append("]");
            sb.append("\n");
            for (ColumnDiff c : getColumnDiffs()) {
                sb.append(c.toSql());
            }
        } else if (table.getType().equals("V")) {
            sb.append("-- different view [");
            sb.append(getName());
            sb.append("]");
            sb.append("\n");
        }
        if (withPermission) {
            for (PermissionDiff p : getPermissionDiffs()) {
                sb.append(p.toSql());
            }
        }
        return sb.toString();
    }

    public String toSqlWithoutPermissions() {
        switch (getType()) {
        case CREATED:
            return toCreateSql(false);
        case DROPPED:
            return toDropSql();
        case MODIFIED:
            return toModifySql(false);
        }
        return null;
    }


}
