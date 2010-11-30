package com.github.ryhmrt.mssqldiff.csv;

public class SchemaCsv {

    /** スキーマ情報のキー */
    public static final String[] COLUMNS = {"objectType", "tableName", "columnName", "columnType", "length", "pk", "identity", "nullable", "defaultValue", "tableDescription", "columnDescription", "userName", "canSelect", "canInsert", "canUpdate", "canDelete"};

    /** オブジェクトタイプ : U=テーブル, V=ビュー */
    private String objectType;
    /** テーブル名 */
    private String tableName;
    /** カラム名 */
    private String columnName;
    /** カラム型 */
    private String columnType;
    /** データ長 */
    private int length;
    /** PKかどうか */
    private boolean pk;
    /** IDENTITY(自動採番)かどうか */
    private boolean identity;
    /** NULL許可かどうか */
    private boolean nullable;
    /** デフォルト値 */
    private String defaultValue;
    /** テーブル説明文 */
    private String tableDescription;
    /** カラム説明文 */
    private String columnDescription;
    /** 権限付与ユーザ */
    private String userName;
    /** SELECT可否 */
    private boolean canSelect;
    /** INSERT可否 */
    private boolean canInsert;
    /** UPDATE可否 */
    private boolean canUpdate;
    /** DELETE可否 */
    private boolean canDelete;

    public String getObjectType() {
        return objectType;
    }
    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }
    public String getTableName() {
        return tableName;
    }
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    public String getColumnName() {
        return columnName;
    }
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
    public String getColumnType() {
        return columnType;
    }
    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public boolean isPk() {
        return pk;
    }
    public void setPk(boolean pk) {
        this.pk = pk;
    }
    public boolean isIdentity() {
        return identity;
    }
    public void setIdentity(boolean identity) {
        this.identity = identity;
    }
    public boolean isNullable() {
        return nullable;
    }
    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }
    public String getDefaultValue() {
        return defaultValue;
    }
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
    public String getTableDescription() {
        return tableDescription;
    }
    public void setTableDescription(String tableDescription) {
        this.tableDescription = tableDescription;
    }
    public String getColumnDescription() {
        return columnDescription;
    }
    public void setColumnDescription(String columnDescription) {
        this.columnDescription = columnDescription;
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
}
