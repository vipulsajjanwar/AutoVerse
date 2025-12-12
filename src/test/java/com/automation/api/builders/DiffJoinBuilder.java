package com.automation.api.builders;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.automation.api.models.Column;

public class DiffJoinBuilder {

	 public static JSONObject buildDiffJoin(List<Column> srcCols, List<Column> tgtCols) {

	        JSONArray joins = new JSONArray();
	        int index = 1;

	        for (Column c : srcCols) {
	            if (tgtCols.stream().anyMatch(t -> t.name.equals(c.name))) {
	                JSONObject j = new JSONObject();
	                j.put("index", index++);
	                j.put("sourceKey", c.name);
	                j.put("targetKey", c.name);
	                joins.put(j);
	            }
	        }

	        JSONObject config = new JSONObject();
	        config.put("joins", joins);

	        JSONObject diff = new JSONObject();
	        diff.put("type", "diffJoin");
	        diff.put("name", "diffJoin");
	        diff.put("configuration", config);

	        return diff;
	    }
}
