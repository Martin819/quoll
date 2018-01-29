package com.company.quoll.utils;

import com.company.quoll.model.IntertypeRelation;
import com.company.quoll.model.SocionicsRelationsMatch;
import com.company.quoll.model.SocionicsResult;
import com.company.quoll.model.User;
import com.company.quoll.services.IntertypeRelationService;
import com.company.quoll.services.SocionicsRelationsMatchService;
import com.company.quoll.services.UserService;
import netscape.security.UserTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class SocionicsTypes {

    @Autowired
    SocionicsRelationsMatchService socionicsRelationsMatchService;

    @Autowired
    IntertypeRelationService intertypeRelationService;

    @Autowired
    UserService userService;

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

    public List<User> getMatchedUsersByFitnessOrder(User user, int fitnessOrder) {
        String userType = user.getSocionicsType();
        IntertypeRelation intertypeRelation = intertypeRelationService.findIntertypeRelationById(fitnessOrder);
        List<SocionicsRelationsMatch> relationsMatches = socionicsRelationsMatchService.findSocionicsRelationsMatchByTypeAAndIntertypeRelation(userType, intertypeRelation);
        List<User> matchedUsers = new ArrayList<>();
        for (SocionicsRelationsMatch srm:relationsMatches) {
            String matchType = srm.getTypeB();
            List<User> typeUsers = userService.findUserBySocionicsType(matchType);
            matchedUsers.addAll(typeUsers);
        }
        return matchedUsers;
    }

}
