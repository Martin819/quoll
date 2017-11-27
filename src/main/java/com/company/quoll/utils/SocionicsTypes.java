package com.company.quoll.utils;

import com.company.quoll.model.SocionicsResult;

public class SocionicsTypes {

    public static String getTypeCode(SocionicsResult socionicsResult) {
        String code = "";
        if (socionicsResult.getExtrovert_value() > 0.5) {
            code += "E";
        }
        else code += "I";

        if (socionicsResult.getSensing_value() > 0.5) {
            code += "S";
        }
        else code += "I";

        if (socionicsResult.getThinking_value() > 0.5) {
            code += "T";
        }
        else code += "F";

        if (socionicsResult.getPerceiving_value() > 0.5) {
            code += "P";
        }
        else code += "J";
        return code;
    }

}
