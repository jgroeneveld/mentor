package de.jgroeneveld.mentor.directs.boundary;

import de.jgroeneveld.mentor.directs.entity.Direct;

public class DirectListElement {
    private long id;
    private String firstName;
    private String lastName;

    public static DirectListElement of(Direct direct) {
        DirectListElement element = new DirectListElement();

        element.id = direct.getId();
        element.firstName = direct.getFirstName();
        element.lastName = direct.getLastName();

        return element;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
