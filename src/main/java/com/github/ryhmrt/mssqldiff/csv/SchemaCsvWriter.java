package com.github.ryhmrt.mssqldiff.csv;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

import au.com.bytecode.opencsv.CSVWriter;

public class SchemaCsvWriter {

    private String path;

    public SchemaCsvWriter(String path) {
        this.path = path;
    }

    public void write(List<SchemaCsv> data) {
        try {
            OutputStream output = new FileOutputStream(path);
            Writer iwriter = new OutputStreamWriter(output, "UTF-8");
            CSVWriter writer = new CSVWriter(iwriter,',','"');
            try {
                writer.writeNext(SchemaCsv.COLUMNS);
                for (SchemaCsv csv : data) {
                    String[] values = new String[SchemaCsv.COLUMNS.length];
                    values[0] = csv.getObjectType();
                    values[1] = csv.getTableName();
                    values[2] = csv.getColumnName();
                    values[3] = csv.getColumnType();
                    values[4] = Integer.toString(csv.getLength());
                    values[5] = Boolean.toString(csv.isPk());
                    values[6] = Boolean.toString(csv.isIdentity());
                    values[7] = Boolean.toString(csv.isNullable());
                    values[8] = csv.getDefaultValue();
                    values[9] = csv.getTableDescription();
                    values[10] = csv.getColumnDescription();
                    values[11] = csv.getUserName();
                    values[12] = Boolean.toString(csv.isCanSelect());
                    values[13] = Boolean.toString(csv.isCanInsert());
                    values[14] = Boolean.toString(csv.isCanUpdate());
                    values[15] = Boolean.toString(csv.isCanDelete());
                    writer.writeNext(values);
                }
            } finally {
                writer.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
