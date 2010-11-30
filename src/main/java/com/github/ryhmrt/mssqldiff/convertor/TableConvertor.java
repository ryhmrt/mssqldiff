package com.github.ryhmrt.mssqldiff.convertor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.github.ryhmrt.mssqldiff.csv.SchemaCsv;
import com.github.ryhmrt.mssqldiff.data.Column;
import com.github.ryhmrt.mssqldiff.data.Permission;
import com.github.ryhmrt.mssqldiff.data.Table;

public class TableConvertor {

    private ColumnConvertor columnConvertor = new ColumnConvertor();
    private PermissionConvertor permissionConvertor = new PermissionConvertor();

    private Map<String, Table> tableCache = new HashMap<String, Table>();

    public Table convert(SchemaCsv csv) {
        Table table = csvToTable(csv);
        addColumnToTable(csv, table);
        addPermissionToTable(csv, table);
        return table;
    }

    private void addColumnToTable(SchemaCsv csv, Table table) {
        Column column = columnConvertor.convert(csv);
        if (!table.getColumns().contains(column)) {
            table.getColumns().add(column);
        }
    }

    private void addPermissionToTable(SchemaCsv csv, Table table) {
        Permission permission = permissionConvertor.convert(csv);
        if (permission != null && !table.getPermissions().contains(permission)) {
            table.getPermissions().add(permission);
        }
    }

    private Table csvToTable(SchemaCsv csv) {
        Table table = tableCache.get(csv.getTableName());
        if (table == null) {
            table = new Table();
            table.setName(csv.getTableName());
            table.setType(csv.getObjectType());
            table.setDescription(csv.getTableDescription());
            table.setColumns(new ArrayList<Column>());
            table.setPermissions(new ArrayList<Permission>());
            tableCache.put(csv.getTableName(), table);
        }
        return table;
    }
}
