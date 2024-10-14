package com.ra.model;

import lombok.*;

import javax.validation.constraints.*;

//Thư viện lombok
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class RegisterForm {
    //Chứa các thông tin trong Form đăng ký
    //Đánh dấu các Annotation trên các trường muốn validate
    @NotBlank(message = "Không được trống!")
    @Size(min = 2, max = 10, message = "Phải từ 2 đến 10 kí tự")
    private String firstName;

    @Size(min = 4, max = 20)
    @NotBlank(message = "Không được trống!")
    private String lastName;

    //@Email(message = "Không đúng định dạng!")
    @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$")
    private String email;

    @NotNull(message = "Không được mang giá trị null")
    private String password;

    //Tự định nghĩa Annotation để check 2 mật khẩu trùng nhau
    @NotEmpty(message = "Độ dài chuỗi phải > 0!")
    private String confirmPassword;

    //Constructor
//    public RegisterForm() {
//    }
//
//    public RegisterForm(String firstName, String lastName, String email, String password, String confirmPassword) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.password = password;
//        this.confirmPassword = confirmPassword;
//    }
//
//    //Getter, setter
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getConfirmPassword() {
//        return confirmPassword;
//    }
//
//    public void setConfirmPassword(String confirmPassword) {
//        this.confirmPassword = confirmPassword;
//    }
}
