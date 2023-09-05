package com.eazyschool.model;

import com.eazyschool.annotation.FieldsValueMatch;
import com.eazyschool.annotation.PasswordValidator;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@FieldsValueMatch.List({
        @FieldsValueMatch(
                field = "password",
                fieldMatch = "confirmPassword",
                message = "Password is not matching!"
        ),
        @FieldsValueMatch(
                field = "email",
                fieldMatch = "confirmEmail",
                message = "Email is not matching!"
        )
}

)
public class Person extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int personId;

    @NotBlank @Size(min = 5)
    private String name;

    @NotBlank @Pattern(regexp = "(^$|[0-9]{10})")
    private String mobileNumber;

    @NotBlank @Email
    private String email;

    @NotBlank
    @Email @Transient
    private String confirmEmail;

    @NotBlank @Size(min = 5) @PasswordValidator
    private String password;

    @NotBlank @Size(min = 5) @Transient
    private String confirmPassword;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

}
