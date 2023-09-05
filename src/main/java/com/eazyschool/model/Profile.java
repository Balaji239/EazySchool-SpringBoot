package com.eazyschool.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Profile {

    @NotBlank
    private String name;

    @NotBlank
    private String mobileNumber;

    @NotBlank
    private String email;

    @NotBlank
    private String address1;

    @NotBlank
    private String address2;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @NotBlank
    private String zipCode;

}
