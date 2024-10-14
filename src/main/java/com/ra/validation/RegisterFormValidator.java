package com.ra.validation;

import com.ra.model.RegisterForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RegisterFormValidator implements Validator {
    @Override
    //supports: quy định xem lớp RegisterFormValidator có hỗ trợ cho cái object truyền dữ lệu vào hay không
    public boolean supports(Class<?> clazz) {
        return clazz.equals(RegisterForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        //Ép kiểu về Register Form
        RegisterForm request = (RegisterForm) target;
        //Kiểm tra tính đúng đắn theo yêu cầu
        //Nếu request.getFirstName() trống
        if(request.getFirstName().isEmpty()){
            //Ném ra thông báo lỗi
            errors.rejectValue("firstName", null, "Không được để trống!");
        }else if(request.getFirstName().matches("\\s")){
            //Ném ra thông báo lỗi
            errors.rejectValue("firstName", null, "Không được chứa khoảng trắng!");
        }
        //Nếu request.getLastName() trống
        if(request.getLastName().isEmpty()){
            errors.rejectValue("lastName", null, "Không được để trống!");
        }else if(request.getLastName().matches("\\s")){
            errors.rejectValue("lastName", null, "Không được chứa khoảng trắng!");
        }
        //Nếu request.getEmail() ko đúng định dạng
        if(request.getEmail().isEmpty()){
            errors.rejectValue("email", null, "Không được để trống!");
        }else if(!request.getEmail().matches("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$")){
            errors.rejectValue("email", null, "Email không đúng định dạng!");
        }
        //Nếu request.getPassword() trống
        if(request.getPassword().isEmpty()){
            errors.rejectValue("password", null, "Không được để trống!");
        }else if(request.getPassword().matches("\\s")){
            errors.rejectValue("password", null, "Không được chứa khoảng trắng!");
        }else if(request.getPassword().length() < 8){
            errors.rejectValue("password", null, "Mật khẩu phải từ 8 ký tự trở lên");
        }
        //Nếu request.getConfirmPassword() không trùng với request.getPassword()
        if(!request.getPassword().equals(request.getConfirmPassword())){
            errors.rejectValue("confirmPassword", null, "Mật khẩu nhập lại không khớp");
        }
    }
}
