package com.github.ryhmrt.mssqldiff.csv;

import java.util.List;

/**
 * スキーマ情報取得インターフェース
 */
public interface SchemaCsvReader {
    /**
     * スキーマ情報を取得する
     * @return スキーマ情報
     */
    public List<SchemaCsv> read();
}
