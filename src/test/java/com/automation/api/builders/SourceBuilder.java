package com.automation.api.builders;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.automation.api.models.Column;

public class SourceBuilder {

	public static JSONObject buildSource(String connectionId, String schemaName, String tableName, String sqlQuery, List<Column> columns) {

        JSONArray cols = new JSONArray();
        int index = 1;

        for (Column c : columns) {
            JSONObject col = new JSONObject();
            col.put("index", index++);
            col.put("datatype", c.datatype);
            col.put("icedqDatatype", c.icedqDatatype);
            col.put("name", c.name);
            cols.put(col);
        }

        JSONObject config = new JSONObject();
        config.put("schemaName", schemaName);
        config.put("tableName", tableName);
        config.put("sql", sqlQuery);
        config.put("appendOrderBy", true);
        config.put("isDeferredSort", false);
        config.put("columns", cols);

        JSONObject source = new JSONObject();
        source.put("type", "source");
        source.put("name", "sourceDataset");
        source.put("connectionId", connectionId);
        source.put("connectionType", "database");
        source.put("input", "table");
        source.put("configuration", config);

        return source;
    }
}
