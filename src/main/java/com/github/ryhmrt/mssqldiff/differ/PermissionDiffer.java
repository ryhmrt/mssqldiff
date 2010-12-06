package com.github.ryhmrt.mssqldiff.differ;

import com.github.ryhmrt.mssqldiff.data.Diff.Type;
import com.github.ryhmrt.mssqldiff.data.Permission;
import com.github.ryhmrt.mssqldiff.data.PermissionDiff;

public class PermissionDiffer extends AbstractDiffer<Permission, PermissionDiff> {

    @Override
    protected PermissionDiff detailDiff(Permission from, Permission to) {
        if (from.isCanSelect() != to.isCanSelect() ||
                from.isCanInsert() != to.isCanInsert() ||
                from.isCanUpdate() != to.isCanUpdate() ||
                from.isCanDelete() != to.isCanDelete()) {
            return createDiff(Type.MODIFIED, from, to);
        }
        return null;
    }

    @Override
    protected PermissionDiff createDiff() {
        return new PermissionDiff();
    }

}
