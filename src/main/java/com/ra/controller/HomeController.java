package com.ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;

@Controller
public class HomeController {
    //Để upload file
    @Autowired
    private ServletContext context; //Môi trường chạy trên server

    @GetMapping("/")
    public String home() {
        return "home";
    }

    //Upload file
    @PostMapping("/upload")
    //@RequestParam("<tên_tham_số>"): lấy ra 1 tham số
    public String upload(@RequestParam("image") MultipartFile image, @RequestParam("audio") MultipartFile audio, Model model) {
        //logic upload
        //Lấy ra thư mục upload
        String uploadPath = context.getRealPath("/uploads");
        //Kiểm tra xem có tồn tại file hay không
        File file = new File(uploadPath);
        if (!file.exists()) {
            file.mkdirs(); //Lệnh tạo mới thư mục
        }
        //Lấy tên file từ file người dùng tải lên
        String fileImageName = image.getOriginalFilename();
        String fileAudioName = audio.getOriginalFilename();
        //Copy file người dùng gửi lên vào thư mục uploads
        try {
            FileCopyUtils.copy(image.getBytes(), new File(uploadPath+File.separator+fileImageName));
            FileCopyUtils.copy(audio.getBytes(), new File(uploadPath+File.separator+fileAudioName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("url", fileImageName);
        model.addAttribute("audio", fileAudioName);
        return "upload";
    }
}
