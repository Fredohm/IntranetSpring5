package com.iepscf.fredohm.dto;

import com.iepscf.fredohm.entity.Role;
import com.iepscf.fredohm.validation.FieldMatch;
import com.iepscf.fredohm.validation.ValidEmail;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@FieldMatch.List({
        @FieldMatch(first = "password", second = "matchingPassword", message = "the password fields must match")
})
public class UserDto {

    private int id;

    @NotNull(message = "is required")
    @Size(min = 3, message = "is required (min 6 characters)")
    private String username;

    @NotNull(message = "is required")
    @Size(min = 5, message = "is required (min 5 characters)")
    private String password;

    @NotNull(message = "is required")
    @Size(min = 5, message = "is required (min 5 characters)")
    private String matchingPassword;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;

    @ValidEmail
    @NotNull
    private String email;

    @NotNull
    private Role formRole;

    public UserDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Role getFormRole() {
        return formRole;
    }

    public void setFormRole(Role formRole) {
        this.formRole = formRole;
    }
}
