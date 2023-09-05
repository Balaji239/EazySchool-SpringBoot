package com.eazyschool.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "contact_msg")
public class Contact extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int contactId;

    @NotBlank(message = "Name should not be blank")
    @Size(min = 3, message = "Name should be at least 3 characters long")
    private String name;

    @NotBlank(message = "Email should not be blank")
    @Email(message = "Please provide a valid Email address")
    private String email;

    @NotBlank(message = "Message should not be blank")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNum;

    @NotBlank(message = "Subject should not be blank")
    @Size(min = 5, message = "Subject should be at least 5 characters long")
    private String subject;

    @NotBlank(message = "Message should not be blank")
    @Size(min = 10, message = "Message should be at least 10 characters long")
    private String message;

    private String status;

}
