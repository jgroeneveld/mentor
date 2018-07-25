package com.example.mentor.directs.boundary;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CreateDirectPayload {
    @NotEmpty
    public String firstName;

    @NotEmpty
    public String lastName;

    @NotNull
    public long managerId;
}
