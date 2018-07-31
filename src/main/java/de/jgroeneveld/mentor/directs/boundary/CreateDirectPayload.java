package de.jgroeneveld.mentor.directs.boundary;

import javax.validation.constraints.NotEmpty;

public class CreateDirectPayload {
    @NotEmpty
    public String firstName;

    @NotEmpty
    public String lastName;
}
