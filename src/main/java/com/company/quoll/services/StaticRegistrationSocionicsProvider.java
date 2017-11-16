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
        sections = new ArrayList<RegistrationSocionicsSection>();

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
    }

    @Override
    public List<RegistrationSocionicsSection> getSections() {
        return sections;
    }
}
