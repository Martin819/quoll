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
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

@Controller
public class ProfileController {

    @Autowired
    UserService userService;

    @Autowired
    SocionicsRelationsMatchService relationsMatchService;

    @GetMapping("/user/profile")
    public String showProfile(Model model, @AuthenticationPrincipal UserDetails currentUser) {
        final User user = userService.findUserByUsername(currentUser.getUsername());
        model.addAttribute("user", user);
        final String userZodiacName = ZodiacSigns.getZodiacSigns().get(user.getZodiacSign() - 1);
        model.addAttribute("zodiac", userZodiacName);
        final String socionicsMessage = getSocionicsValuesExplanation(user, true);
        model.addAttribute("userSocionicsMessage", socionicsMessage);
        return "myprofile";
    }

    @PostMapping("/user/profile")
    public String updatePersonalDetails(@Valid User user, BindingResult bindingResult) {
        System.out.println(user.getUsername());
        System.out.println(user.getDateOfBirth());
        System.out.println(user.getEmail());
        System.out.println(user.getSex());
        System.out.println(user.getPassword());
        System.out.println(user.getAddressCode());
        System.out.println(user.getRepeatPassword());

        final List<FieldError> errors = bindingResult.getFieldErrors();
        for (FieldError error : errors) {
            if (!"password".equals(error.getField()) && !"repeat-password".equals(error.getField())) {
                return "myprofile";
            }
        }

        // TODO further validation and persisting

        return "redirect:/user/profile";
    }

    @PostMapping("/user/profile/password")
    public String updatePassword(@Valid User user, BindingResult bindingResult) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getRepeatPassword());

        // TODO password validation and persisting

        return "redirect:/user/profile";
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
