package com.company.quoll.model;

import java.util.ArrayList;
import java.util.List;

public class RegistrationSocionicsSection {

    private String title;
    private List<RegistrationSocionicsItem> items;

    public RegistrationSocionicsSection(String title) {
        this.title = title;
        items = new ArrayList<RegistrationSocionicsItem>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<RegistrationSocionicsItem> getItems() {
        return items;
    }

    public void setItems(List<RegistrationSocionicsItem> items) {
        this.items = items;
    }

    public void addItem(RegistrationSocionicsItem item) {
        items.add(item);
    }
}
