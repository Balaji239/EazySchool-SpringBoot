package com.eazyschool.model;

import com.eazyschool.annotation.FieldsValueMatch;
import com.eazyschool.annotation.PasswordValidator;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
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

    @NotBlank(message = "Name cannot be empty") @Size(min = 5, message = "Name must be least 5 characters")
    private String name;

    @NotBlank(message = "Contact number cannot be empty") @Pattern(regexp = "(^$|[0-9]{10})", message = "Please enter valid Contact number")
    private String mobileNumber;

    @NotBlank(message = "Email cannot be empty") @Email(message = "Please enter valid email")
    private String email;

    @NotBlank(message = "Please confirm email")
    @Email(message = "Please enter valid email") @Transient
    private String confirmEmail;

    @NotBlank(message = "Password cannot be empty") @Size(min = 5 ,message = "Password must contain atleast 5 characters") @PasswordValidator
    private String password;

    @NotBlank(message = "Please confirm password") @Size(min = 5) @Transient
    private String confirmPassword;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", referencedColumnName = "classId")
    private EazyClass eazyClass;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "person_courses",
            joinColumns = {
                    @JoinColumn(name = "person_id", referencedColumnName = "personId")},
            inverseJoinColumns = {
                    @JoinColumn(name = "course_id", referencedColumnName = "courseId")})
    private Set<Course> courses = new HashSet<>();

}
