package com.github.ryhmrt.mssqldiff.data;

public abstract class Diff<DATA> {

    public enum Type {EQUAL, MODIFIED, CREATED, DROPPED};

    private Type type;
    private DATA from;
    private DATA to;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public DATA getFrom() {
        return from;
    }

    public void setFrom(DATA from) {
        this.from = from;
    }

    public DATA getTo() {
        return to;
    }

    public void setTo(DATA to) {
        this.to = to;
    }

    @Override
    public String toString() {
        switch (getType()) {
        case MODIFIED:
            return "* " + getName();
        case CREATED:
            return "+ " + getName();
        case DROPPED:
            return "- " + getName();
        default:
            return getName();
        }
    }

    public String toSql() {
        switch (getType()) {
        case CREATED:
            return toCreateSql();
        case DROPPED:
            return toDropSql();
        case MODIFIED:
            return toModifySql();
        }
        return null;
    }

    public abstract String getName();

    public abstract String toCreateSql();

    public abstract String toDropSql();

    public abstract String toModifySql();
}
