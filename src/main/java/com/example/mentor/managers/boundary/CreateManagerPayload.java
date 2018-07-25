package com.example.mentor.managers.boundary;

import javax.validation.constraints.NotBlank;

public class CreateManagerPayload {
    @NotBlank
    public String firstName;

    @NotBlank
    public String lastName;
}
