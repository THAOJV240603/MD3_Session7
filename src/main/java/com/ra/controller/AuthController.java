package com.ra.controller;

import com.ra.model.RegisterForm;
import com.ra.validation.RegisterFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AuthController {
    @Autowired
    private RegisterFormValidator validator;

    //Điều hướng tới form đăng ký
    @GetMapping("/sign-up")
    public String formRegister(Model model) {
        //Gửi modelAttribute
        model.addAttribute("formRegister",new RegisterForm());
        return "register";
    }

    @PostMapping("/sign-up")
    //@Valid: Cho phép kiểm tra tính xác thực của đối tượng ModelAttribute truyền vào
    //BindingResult: Kiểm tra xem có lỗi nào sinh ra không
    //Điều hướng về trang mới thì cần Model
    public String signUp(@Valid @ModelAttribute("formRegister") RegisterForm request, BindingResult result, Model model) {
        model.addAttribute("formRegister",request);

        //Gọi đến phương thức đã triển khai trong RegisterFormValidator
        //validator.validate(request, result);

        //Xử lý dữ liệu
        if (result.hasErrors()) { //Kiểm tra xem có lỗi không
            //Trả về giao diện cũ và hiển thị lỗi
            return "register";
        }else {
            //Thành công - đổ thông tin ra mới infor
            return "info";
        }
    }
}
