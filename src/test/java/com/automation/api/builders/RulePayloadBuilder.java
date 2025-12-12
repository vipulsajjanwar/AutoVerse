package com.automation.api.builders;

import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONObject;

public class RulePayloadBuilder {

	public static JSONObject buildRulePayload(
            JSONObject source,
            JSONObject target,
            JSONObject diffJoin) {

        JSONArray objects = new JSONArray();
        objects.put(source);
        objects.put(target);
        objects.put(diffJoin);

        // add static checks
        objects.put(buildRecordChecks());
        objects.put(buildReport());
        objects.put(buildSummary());

        JSONObject properties = new JSONObject();
        properties.put("criticality", "Warning");
        properties.put("degreeOfParallelism", 1);
        properties.put("engineType", "HighThroughput");

        JSONObject payload = new JSONObject();
        payload.put("name", "Rule_" + System.currentTimeMillis());
        payload.put("template", "recon");
        payload.put("ruleType", "Recon");
        payload.put("isActive", true);
        payload.put("objects", objects);
        payload.put("properties", properties);

        return payload;
    }

    private static JSONObject buildRecordChecks() {
        JSONObject chk = new JSONObject();
        chk.put("type", "recordCheck");
        chk.put("name", "checks");

        JSONArray arr = new JSONArray();
        JSONObject r = new JSONObject();
        r.put("name", "resulttype");

        JSONObject exprVals = new JSONObject();
        exprVals.put("values", Arrays.asList("a-b", "b-a", "Xp"));
        r.put("expression", exprVals);
        r.put("type", "ResultType");
        r.put("isActive", true);

        arr.put(r);
        JSONObject config = new JSONObject();
        config.put("checks", arr);
        chk.put("configuration", config);

        return chk;
    }

    private static JSONObject buildReport() {
        JSONObject rep = new JSONObject();
        rep.put("type", "report");
        rep.put("name", "exceptionReport");

        JSONObject config = new JSONObject();
        config.put("format", Arrays.asList("XLSX"));
        config.put("storeOnlyException", true);
        rep.put("configuration", config);

        return rep;
    }

    private static JSONObject buildSummary() {
        JSONObject sum = new JSONObject();
        sum.put("type", "summary");
        sum.put("name", "summary");
        return sum;
    }
}
