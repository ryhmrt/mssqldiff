package com.github.ryhmrt.mssqldiff.gui.config;

public class DbConnection implements Comparable<DbConnection> {
    private String host;
    private String dbname;
    private String user;

    public DbConnection(){
    }

    public DbConnection(String host, String dbname, String user){
        this.host = host;
        this.dbname = dbname;
        this.user = user;
    }

    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public String getDbname() {
        return dbname;
    }
    public void setDbname(String dbname) {
        this.dbname = dbname;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return host + ":" + dbname + ":" + user;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof DbConnection) {
            DbConnection dc = (DbConnection)o;
            return host.equalsIgnoreCase(dc.host) && dbname.equalsIgnoreCase(dc.dbname) && user.equalsIgnoreCase(dc.user);
        }
        return false;
    }

    @Override
    public int compareTo(DbConnection dc) {
        int h = host.compareToIgnoreCase(host);
        int d = dbname.compareToIgnoreCase(dbname);
        int u = user.compareToIgnoreCase(user);
        return h == 0 ? d == 0 ? u : d : h;
    }
}
