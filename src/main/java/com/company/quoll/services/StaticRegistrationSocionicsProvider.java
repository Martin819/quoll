package com.company.quoll.services;

import com.company.quoll.model.RegistrationSocionicsItem;
import com.company.quoll.model.RegistrationSocionicsSection;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StaticRegistrationSocionicsProvider implements RegistrationSocionicsProvider {

    private List<RegistrationSocionicsSection> sections;

    public StaticRegistrationSocionicsProvider() {
        sections = new ArrayList<>();

        final RegistrationSocionicsSection extInt = new RegistrationSocionicsSection("Extrovert or introvert");
        extInt.addItem(new RegistrationSocionicsItem(
                "I am interested in what is happening around me",
                "I am interested in my own thoughts and feelings"));
        extInt.addItem(new RegistrationSocionicsItem(
                "I am open and often talkative",
                "I need to have my own territory"));
        extInt.addItem(new RegistrationSocionicsItem(
                "I compare my own opinions with the opinions of others",
                "I often appear reserved, quiet and thoughtful"));
        extInt.addItem(new RegistrationSocionicsItem(
                "I easily make new friends or adapt to a new group",
                "I usually do not have many friends"));
        extInt.addItem(new RegistrationSocionicsItem(
                "I am interested in new people",
                "I do not like unexpected visits and therefore do not make them"));
        sections.add(extInt);

        final RegistrationSocionicsSection senInt = new RegistrationSocionicsSection("Sensing or intuitive");
        senInt.addItem(new RegistrationSocionicsItem(
                "I live in here and now",
                "I am mostly in the past or in the future"));
        senInt.addItem(new RegistrationSocionicsItem(
                "I see everyone and sense everything",
                "I worry about the future more than the present"));
        senInt.addItem(new RegistrationSocionicsItem(
                "I like pleasures based on physical sensation",
                "I am attracted more to the theory than the practice"));
        senInt.addItem(new RegistrationSocionicsItem(
                "I am practical and realistic",
                "I am interested in everything new and unusual"));
        senInt.addItem(new RegistrationSocionicsItem(
                "I am active and self-confident",
                "I often have doubts"));
        sections.add(senInt);

        final RegistrationSocionicsSection thiFee = new RegistrationSocionicsSection("Thinking or feeling");
        thiFee.addItem(new RegistrationSocionicsItem(
                "I am interested in systems, structures, patterns",
                "I am interested in people and their feelings"));
        thiFee.addItem(new RegistrationSocionicsItem(
                "I expose everything to logical analysis",
                "I easily pass my own mood to others"));
        thiFee.addItem(new RegistrationSocionicsItem(
                "I am relatively cold and unemotiona",
                "I pay great attention to love and passion"));
        thiFee.addItem(new RegistrationSocionicsItem(
                "I evaluate things by intellect and right or wrong",
                "I evaluate things by ethics and good or bad"));
        thiFee.addItem(new RegistrationSocionicsItem(
                "I have difficulties talking about feelings",
                "I can be touchy or use emotional manipulation"));
        sections.add(thiFee);


        final RegistrationSocionicsSection perJud = new RegistrationSocionicsSection("Perceiving or judging");
        perJud.addItem(new RegistrationSocionicsItem(
                "I prefer to have freedom from obligations",
                "I do not like to leave unanswered questions"));
        perJud.addItem(new RegistrationSocionicsItem(
                "I can start many things at once without finishing them properly",
                "I plan work ahead and tend to finish it"));
        perJud.addItem(new RegistrationSocionicsItem(
                "I am curious and like a fresh look at things",
                "I do not like to change my decisions"));
        perJud.addItem(new RegistrationSocionicsItem(
                "My work productivity depends on my mood",
                "I have relatively stable workability"));
        perJud.addItem(new RegistrationSocionicsItem(
                "I often act without any preparation",
                "I easily follow rules and discipline"));
        sections.add(perJud);
    }

    @Override
    public List<RegistrationSocionicsSection> getSections() {
        return sections;
    }
}
