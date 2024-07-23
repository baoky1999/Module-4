package com.validation.formlogin.dto;

import jakarta.validation.constraints.*;


public class UserDTO {

    @NotBlank(message = "Không được để trống tên")
    @Size(min = 5, max = 45, message = "tên được được ít hơn 10 ký tự và không được hơn 45 ký tự")
    private String firstName;

    @NotBlank(message = "Không được để trống tên")
    @Size(min = 5, max = 45, message = "tên được được ít hơn 10 ký tự và không được hơn 45 ký tự")
    private String lastName;

    @Pattern(regexp = "^(?:0|84|\\+84)?[1-9]\\d{8}$", message = "Số điện thoại không đúng định dạng")
    @NotNull(message = "Không được để trống số điện thoại")
    private String phoneNumber;

    @Min(value = 18, message = "Tuổi không được bé hơn 18")
    @NotNull(message = "Không được để trống tuổi")
    private int age;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$", message = "Email không đúng định dạng")
    @NotNull(message = "Không được để trống Email")
    private String email;

    public UserDTO() {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
