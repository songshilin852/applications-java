package com.qian.self_applications.apps.Users.Service;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;

import java.util.HashMap;

public class CharacterRecognitionService {

    //设置APPID/AK/SK
    final String APP_ID = "22854747\n";
    final String API_KEY = "gQYfeetu6W8mfAkdahrSXKGK";
    final String SECRET_KEY = "f5oF7Hf0EqA0Uxes8tBz7ZAneMbQFGTc";

    public HashMap<String, String> Sample() {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        HashMap<String, String> options = new HashMap<String, String>();
        options.put("detect_direction", "true");
        options.put("probability", "true");


        // 参数为本地图片路径
        String image = "/Users/edz/Desktop/test.png";
        JSONObject res = client.basicAccurateGeneral(image, options);
        System.out.println(res.toString(2));
        options.put("msg",res.toString());
        return options;

        // 参数为本地图片二进制数组
//        byte[] file = readImageFile(image);
//        res = client.basicAccurateGeneral(file, options);
//        System.out.println(res.toString(2));


    }
}
