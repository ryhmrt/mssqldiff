package com.github.ryhmrt.mssqldiff.convertor;

import com.github.ryhmrt.mssqldiff.csv.SchemaCsv;
import com.github.ryhmrt.mssqldiff.data.Permission;

public class PermissionConvertor {

    public Permission convert(SchemaCsv csv) {
        return csvToPermission(csv);
    }

    private Permission csvToPermission(SchemaCsv csv) {
        if (csv.getUserName() == null || csv.getUserName().isEmpty()) return null;
        Permission permission = new Permission();
        permission.setTableName(csv.getTableName());
        permission.setUserName(csv.getUserName());
        permission.setCanSelect(csv.isCanSelect());
        permission.setCanInsert(csv.isCanInsert());
        permission.setCanUpdate(csv.isCanUpdate());
        permission.setCanDelete(csv.isCanDelete());
        return permission;
    }
}
