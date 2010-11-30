package com.github.ryhmrt.mssqldiff.convertor;

import java.util.ArrayList;
import java.util.List;

import com.github.ryhmrt.mssqldiff.csv.SchemaCsv;
import com.github.ryhmrt.mssqldiff.data.Table;

public class TableListConvertor {

    public List<Table> convert(List<SchemaCsv> src) {
        List<Table> result = new ArrayList<Table>();
        TableConvertor tableConvertor = new TableConvertor();
        for (SchemaCsv csv : src) {
            Table table = tableConvertor.convert(csv);
            if (!result.contains(table)) {
                result.add(table);
            }
        }
        return result;
    }
}
