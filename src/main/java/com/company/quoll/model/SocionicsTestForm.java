package com.company.quoll.model;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SocionicsTestForm {

    private List<List<String>> values;

    public SocionicsTestForm() {
        values = new ArrayList<List<String>>();
    }

    public List<List<String>> getValues() {
        return values;
    }

    public void setValues(List<List<String>> values) {
        this.values = values;
    }

    @Nullable
    public SocionicsResult makeResult() {
        if (values == null || values.size() < 4) {
            return null;
        }

        float extrovertValue = 0.0f;
        for (String s : values.get(0)) {
            if ("left".equals(s)) {
                extrovertValue += 1.0f / values.get(0).size();
            }
        }

        float sensingValue = 0.0f;
        for (String s : values.get(1)) {
            if ("left".equals(s)) {
                sensingValue += 1.0f / values.get(1).size();
            }
        }

        float thinkingValue = 0.0f;
        for (String s : values.get(2)) {
            if ("left".equals(s)) {
                thinkingValue += 1.0f / values.get(2).size();
            }
        }

        float perceivingValue = 0.0f;
        for (String s : values.get(3)) {
            if ("left".equals(s)) {
                perceivingValue += 1.0f / values.get(3).size();
            }
        }

        SocionicsResult result = new SocionicsResult();
        result.setExtrovertValue(extrovertValue);
        result.setSensingValue(sensingValue);
        result.setThinkingValue(thinkingValue);
        result.setPerceivingValue(perceivingValue);

        return result;
    }

}
