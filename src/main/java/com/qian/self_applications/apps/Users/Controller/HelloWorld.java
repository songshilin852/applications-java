package com.qian.self_applications.apps.Users.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;


@RestController
public class HelloWorld {
    SimpleDateFormat sdf = new SimpleDateFormat("/yyy/MM/dd");

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);

    }

    @GetMapping("/upload")
    public Map<String, Object> fileLoad(@RequestBody MultipartFile file) {
        Map<String,Object> result = new HashMap<>();
        try {

            byte[] bytes = file.getBytes();
            result.put("msg",bytes);


        } catch (Exception ex) {
            result.put("msg",ex.getMessage());
            return result;

        }
        return result;
    }
}
