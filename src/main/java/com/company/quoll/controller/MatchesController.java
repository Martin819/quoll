package com.company.quoll.controller;

import com.company.quoll.model.IntertypeRelation;
import com.company.quoll.model.SocionicsRelationsMatch;
import com.company.quoll.model.SocionicsResult;
import com.company.quoll.model.User;
import com.company.quoll.services.IntertypeRelationService;
import com.company.quoll.services.SocionicsRelationsMatchService;
import com.company.quoll.services.SocionicsResultService;
import com.company.quoll.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MatchesController {

    @Autowired
    SocionicsResultService socionicsResultService;

    @Autowired
    UserService userService;

    @Autowired
    IntertypeRelationService intertypeRelationService;

    @Autowired
    SocionicsRelationsMatchService socionicsRelationsMatchService;

    @GetMapping("/matches")
    public String getMapping(Model model, @AuthenticationPrincipal UserDetails currentUser){
        User user = userService.findUserByUsername(currentUser.getUsername());
        SocionicsResult userResults = socionicsResultService.findSocionicsResultById(user.getId());
        String userSocionicsType = user.getSocionicsType();
        SocionicsRelationsMatch partnerType1 = socionicsRelationsMatchService
                .findSocionicsRelationsMatchByTypeAAndIntertypeRelation(userSocionicsType,
                        intertypeRelationService.findIntertypeRelationByFitnessOrder(1));
/*        SocionicsRelationsMatch partnerType2 = socionicsRelationsMatchService
                .findSocionicsRelationsMatchByTypeAAndIntertypeRelation(userSocionicsType,
                        intertypeRelationService.findIntertypeRelationByFitnessOrder(2));
        SocionicsRelationsMatch partnerType3 = socionicsRelationsMatchService
                .findSocionicsRelationsMatchByTypeAAndIntertypeRelation(userSocionicsType,
                        intertypeRelationService.findIntertypeRelationByFitnessOrder(3));*/
        List<User> partners1 = userService.findUserBySocionicsType(partnerType1.getTypeB());
/*        List<User> partners2 = userService.findUserBySocionicsType(partnerType2.getTypeB());
        List<User> partners3 = userService.findUserBySocionicsType(partnerType3.getTypeB());*/
        model.addAttribute("userResults", userResults);
        model.addAttribute("userSocionicsType", userSocionicsType);
        model.addAttribute("partners1", partners1);
/*        model.addAttribute(partners2);
        model.addAttribute(partners3);*/
        System.out.println(userResults.getId() + userResults.getExtrovertValue());
        System.out.println(userSocionicsType);
        System.out.println(partners1);
        return "matches";
    }
}
