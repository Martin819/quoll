package com.company.quoll.controller;

import com.company.quoll.model.IntertypeRelation;
import com.company.quoll.model.SocionicsRelationsMatch;
import com.company.quoll.model.SocionicsResult;
import com.company.quoll.model.User;
import com.company.quoll.services.IntertypeRelationService;
import com.company.quoll.services.SocionicsRelationsMatchService;
import com.company.quoll.services.SocionicsResultService;
import com.company.quoll.services.UserService;
import com.company.quoll.utils.SocionicsTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.UUID;

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
        SocionicsTypes.getMatchedUsersByFitnessOrder()
        return "matches";
    }
}
