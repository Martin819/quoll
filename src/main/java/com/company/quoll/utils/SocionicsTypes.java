package com.company.quoll.utils;

import com.company.quoll.model.SocionicsResult;

public class SocionicsTypes {

    public static String getTypeCode(SocionicsResult socionicsResult) {
        String code = "";
        if (socionicsResult.getExtrovertValue() > 0.5) {
            code += "E";
        }
        else code += "I";

        if (socionicsResult.getSensingValue() > 0.5) {
            code += "S";
        }
        else code += "N";

        if (socionicsResult.getThinkingValue() > 0.5) {
            code += "T";
        }
        else code += "F";

        if (socionicsResult.getPerceivingValue() > 0.5) {
            code += "p";
        }
        else code += "j";
        return code;
    }

}
