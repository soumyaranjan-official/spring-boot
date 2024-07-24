package com.devmix.student.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
@Data
@Entity
@Getter
@Setter
public class StudentEntity implements Serializable {

    @Id
    private String studentId;
    @NotNull (message = "cannot be null")
    @NotBlank(message = "cannot be empty")
    @NotEmpty(message = "first name cannot be null")
    private String firstName;
    @NotNull (message = "cannot be null")
    @NotBlank(message = "cannot be empty")
    @NotEmpty(message = "last name cannot be null")
    private String lastName;

    private String middleName;
    @Min(value = 5,message = "cannot be less than ")
    @Max(value = 99,message = "cannot exceeds from ")
    private int age;
    @Email(message = "invalid email")
    private String email;
    @NotNull (message = "cannot be null")
    @NotBlank(message = "cannot be empty")
    @Pattern(regexp = "^\\d{10}$",message = "invalid phone number")
    private String phoneNumber;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public @NotNull(message = "cannot be null") @NotBlank(message = "cannot be empty") @NotEmpty(message = "first name cannot be null") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotNull(message = "cannot be null") @NotBlank(message = "cannot be empty") @NotEmpty(message = "first name cannot be null") String firstName) {
        this.firstName = firstName;
    }

    public @NotNull(message = "cannot be null") @NotBlank(message = "cannot be empty") @NotEmpty(message = "last name cannot be null") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull(message = "cannot be null") @NotBlank(message = "cannot be empty") @NotEmpty(message = "last name cannot be null") String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Min(value = 5, message = "cannot be less than ")
    @Max(value = 99, message = "cannot exceeds from ")
    public int getAge() {
        return age;
    }

    public void setAge(@Min(value = 5, message = "cannot be less than ") @Max(value = 99, message = "cannot exceeds from ") int age) {
        this.age = age;
    }

    public @Email(message = "invalid email") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "invalid email") String email) {
        this.email = email;
    }

    public @NotNull(message = "cannot be null") @NotBlank(message = "cannot be empty") @Pattern(regexp = "^\\d{10}$", message = "invalid phone number") String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@NotNull(message = "cannot be null") @NotBlank(message = "cannot be empty") @Pattern(regexp = "^\\d{10}$", message = "invalid phone number") String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
