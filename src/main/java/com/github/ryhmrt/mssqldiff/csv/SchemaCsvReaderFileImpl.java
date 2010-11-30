package com.github.ryhmrt.mssqldiff.csv;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class SchemaCsvReaderFileImpl {

    private String path;

    public SchemaCsvReaderFileImpl(String path) {
        this.path = path;
    }

    public List<SchemaCsv> read() {
        try {
            InputStream input = new FileInputStream(path);
            InputStreamReader ireader=new InputStreamReader(input, "UTF-8");
            CSVReader reader = new CSVReader(ireader,',','"',1);
            ColumnPositionMappingStrategy<SchemaCsv> strat = new ColumnPositionMappingStrategy<SchemaCsv>();
            strat.setType(SchemaCsv.class);
            strat.setColumnMapping(SchemaCsv.COLUMNS);
            CsvToBean<SchemaCsv> csv = new CsvToBean<SchemaCsv>();
            return csv.parse(strat, reader);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
