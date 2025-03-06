package com.example.AddressBookApp.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDTO {
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Address cannot be blank")
    @Size(max = 200, message = "Address cannot exceed 200 characters")
    private String address;

    @NotBlank(message = "City cannot be blank")
    @Size(max = 100, message = "City cannot exceed 100 characters")
    private String city;

    @NotBlank(message = "State cannot be blank")
    @Size(min = 2, max = 50, message = "State must be between 2 and 50 characters")
    private String state;

    @NotBlank(message = "ZIP code cannot be blank")
    @Pattern(regexp = "^\\d{5,6}$", message = "ZIP code must be 5 or 6 digits long")
    private String zip;

    @NotBlank(message = "Phone number cannot be blank")
    @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$", message = "Phone must be in format XXX-XXX-XXXX or XXX-XXXX-XXXX")
    private String phone;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    @Size(max = 100, message = "Email cannot exceed 100 characters")
    private String email;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    // Constructor for use in the service implementation
    public AddressBookDTO(Long id, String name, String address, String city,
                          String state, String zip, String phone, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }
}