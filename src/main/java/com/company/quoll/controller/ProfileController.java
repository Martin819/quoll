package com.company.quoll.controller;

import com.company.quoll.model.SocionicsRelationsMatch;
import com.company.quoll.model.SocionicsResult;
import com.company.quoll.model.User;
import com.company.quoll.services.SocionicsRelationsMatchService;
import com.company.quoll.services.UserService;
import com.company.quoll.utils.ZodiacSigns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Calendar;
import java.util.Locale;

@Controller
public class ProfileController {

    @Autowired
    UserService userService;

    @Autowired
    SocionicsRelationsMatchService relationsMatchService;

    @GetMapping("/user/profile")
    public String showProfile(Model model, @AuthenticationPrincipal UserDetails currentUser) {
        User user = userService.findUserByUsername(currentUser.getUsername());
        return "profile";
    }

    @GetMapping("/user/profile/{userId}")
    public String showOtherProfile(@PathVariable int userId, Model model, @AuthenticationPrincipal UserDetails currentUserDetails) {
        System.out.println("user id: " + userId);

        final User user = userService.findUserById(userId);
        model.addAttribute("user", user);

        final int userZodiacIndex = user.getZodiacSign() - 1;
        final String userZodiacName = ZodiacSigns.getZodiacSigns().get(userZodiacIndex);
        model.addAttribute("zodiac", userZodiacName);

        final User currentUser = userService.findUserByUsername(currentUserDetails.getUsername());
        model.addAttribute("currentUser", currentUser);
        final int currentUserZodiacIndex = currentUser.getZodiacSign() - 1;

        if (currentUserZodiacIndex + 8 == userZodiacIndex
                || (currentUserZodiacIndex + 8) % 11 == userZodiacIndex) {
            // 4 signs before -> good match
            model.addAttribute("zodiacMessage", "This sign is four signs before yours. " +
                    "Therefore, according to the Zodiac, you are a perfect match.");
        } else if (currentUserZodiacIndex + 4 == userZodiacIndex
                || (currentUserZodiacIndex + 4) % 11 == userZodiacIndex) {
            // 4 signs after -> good match
            model.addAttribute("zodiacMessage", "This sign is four signs before yours. " +
                    "Therefore, according to the Zodiac, you are a perfect match.");
        } else if (currentUserZodiacIndex + 6 == userZodiacIndex
                || (currentUserZodiacIndex + 6) % 11 == userZodiacIndex) {
            // 6 signs away -> good match
            model.addAttribute("zodiacMessage", "This sign is four signs before yours. " +
                    "Therefore, according to the Zodiac, you are a perfect match.");
        } else {
            // other -> not good match
            model.addAttribute("zodiacMessage", "According to the Zodiac, your signs do not match.");
        }

        final SocionicsRelationsMatch relationsMatch = relationsMatchService.findSocionicsRelationsMatch(
                currentUser.getSocionicsType(), user.getSocionicsType());
        model.addAttribute("intertypeRelation", relationsMatch.getIntertypeRelation());
        model.addAttribute("intertypeRelationDesc", new String(relationsMatch.getIntertypeRelation().getDescription()));
        model.addAttribute("userSocionicsMessage", getSocionicsValuesExplanation(user, false));
        model.addAttribute("currentUserSocionicsMessage", getSocionicsValuesExplanation(currentUser, true));

        return "profile";
    }

    private String getSocionicsValuesExplanation(User user, boolean isCurrent) {
        final SocionicsResult usersSocResult = user.getSocionicsResult();
        return String.format(Locale.US, "That means %s more %s than %s, " +
                        "more %s than %s, more %s than %s and more %s than %s.",
                isCurrent ? "you are" : ("Male".equals(user.getSex()) ? "he is" : "she is"),
                usersSocResult.getExtrovertValue() > 0.5f ? "extrovert" : "introvert",
                usersSocResult.getExtrovertValue() < 0.5f ? "extrovert" : "introvert",
                usersSocResult.getSensingValue() > 0.5f ? "sensing" : "intuitive",
                usersSocResult.getSensingValue() < 0.5f ? "sensing" : "intuitive",
                usersSocResult.getThinkingValue() > 0.5f ? "thinking" : "feeling",
                usersSocResult.getThinkingValue() < 0.5f ? "thinking" : "feeling",
                usersSocResult.getPerceivingValue() > 0.5f ? "perceiving" : "judging",
                usersSocResult.getPerceivingValue() < 0.5f ? "perceiving" : "judging");
    }

}
