package ru.job4j.ood.srp;

import org.json.JSONObject;

public class FormatterJSON implements Formatter {
    private Report report;

    public FormatterJSON(Report report) {
        this.report = report;
    }

    @Override
    public String generate() throws Exception {
        return new JSONObject(report).toString();
    }
}
