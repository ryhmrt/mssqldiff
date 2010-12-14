package com.github.ryhmrt.mssqldiff.gui.config;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DbConnectionStore {
    private static final String CONFIG_FILE = "mssqldiff-connection-preset.xml";

    public List<DbConnection> load() {
        List<DbConnection> result = new ArrayList<DbConnection>();
        File file = new File(CONFIG_FILE);
        if (!file.canRead()) {
            return result;
        }
        XMLDecoder xmlDecoder;
        try {
            xmlDecoder = new XMLDecoder(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Object o = xmlDecoder.readObject();
            Collections.addAll(result, (DbConnection[])o);
        } finally {
            xmlDecoder.close();
        }
        return result;
    }

    public void save(List<DbConnection> dbConnections) {
        File file = new File(CONFIG_FILE);
        XMLEncoder xmlEncoder;
        try {
            xmlEncoder = new XMLEncoder(new FileOutputStream(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            xmlEncoder.writeObject(dbConnections.toArray(new DbConnection[dbConnections.size()]));
        } finally {
            xmlEncoder.close();
        }
    }
}
