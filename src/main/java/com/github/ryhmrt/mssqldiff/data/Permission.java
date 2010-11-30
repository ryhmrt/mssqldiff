package com.github.ryhmrt.mssqldiff.data;

public class Permission {

    private String tableName;
    private String userName;
    private boolean canSelect;
    private boolean canInsert;
    private boolean canUpdate;
    private boolean canDelete;

    public String getTableName() {
        return tableName;
    }
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public boolean isCanSelect() {
        return canSelect;
    }
    public void setCanSelect(boolean canSelect) {
        this.canSelect = canSelect;
    }
    public boolean isCanInsert() {
        return canInsert;
    }
    public void setCanInsert(boolean canInsert) {
        this.canInsert = canInsert;
    }
    public boolean isCanUpdate() {
        return canUpdate;
    }
    public void setCanUpdate(boolean canUpdate) {
        this.canUpdate = canUpdate;
    }
    public boolean isCanDelete() {
        return canDelete;
    }
    public void setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Permission) {
            Permission c = (Permission)o;
            return tableName.equals(c.tableName) && userName.equals(c.userName);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Permission[" + userName + "] of Table[" + tableName + "]";
    }
}
