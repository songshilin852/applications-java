package com.qian.self_applications.apps.Users.Controller;
import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.HashMap;

@RestController
public class CharacterRecognitionController {
    @PostMapping("/character_recognition")
    public HashMap<String, String> hello(MultipartFile file) throws IOException {
        HashMap<String, String> options = new HashMap<String, String>();
        if (file.isEmpty()) {
            options.put("msg","请选择一张图片");
            return options;
        }

        //设置APPID/AK/SK
        final String APP_ID = "22854747";
        final String API_KEY = "gQYfeetu6W8mfAkdahrSXKGK";
        final String SECRET_KEY = "f5oF7Hf0EqA0Uxes8tBz7ZAneMbQFGTc";
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        //文件转二进制
        byte[] bytes = file.getBytes();
        String fileType = file.getContentType();
        System.out.print(fileType);
        if (!fileType.startsWith("image")){
            options.put("msg","请上传图片类型的文件");
            return options;
        }

        JSONObject res = client.basicAccurateGeneral(bytes, options);
        System.out.println(res.toString(2));


        JSONArray a = res.getJSONArray("words_result");
        System.out.println(a.toString());

        String character = "";
        for(int i=0;i<a.length();i++) {
            System.out.println(a.getJSONObject(i).get("words"));
            character = character + a.getJSONObject(i).getString("words") + "\n";
        }

        options.put("msg", character);
        return options;

    }
}
