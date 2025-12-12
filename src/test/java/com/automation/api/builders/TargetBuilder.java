package com.automation.api.builders;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.automation.api.models.Column;

public class TargetBuilder {

	public static JSONObject buildTarget(String connectionId, String schemaName, String tableName, String sqlQuery, List<Column> columns) {

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

        JSONObject target = new JSONObject();
        target.put("type", "target");
        target.put("name", "targetDataset");
        target.put("connectionId", connectionId);
        target.put("connectionType", "database");
        target.put("input", "table");
        target.put("configuration", config);

        return target;
    }
}
