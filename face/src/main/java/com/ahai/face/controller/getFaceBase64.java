package com.ahai.face.controller;

import com.ahai.face.tools.Base64Req;
import com.ahai.face.dao.photoInfoDao;
import com.ahai.face.tools.baseToImg;
import com.ahai.face.photo.photoInfo;
import com.ahai.face.tools.getFace;
import com.ahai.face.tools.loadImages;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.util.Map;

@Controller
public class getFaceBase64 {
    public static int id = 0;
    public static String name = null;

    @RequestMapping(value = {"/", "index"})
    public String navigator() {
        return "index";
    }

    @PostMapping("/postBase64")
    @ResponseBody
    public Base64Req postBase64(@RequestBody Base64Req base64Req) throws IOException {
        baseToImg.GenerateImage(base64Req.getBase64(), "E:\\image\\tmp\\facetest.png");
        getFace getface = new getFace();
        boolean flag = getface.errorCode1();
        if (flag) {
            return base64Req;
        }
        return null;
    }

    @Resource
    photoInfoDao photoInfoDao;

//    @PostMapping("/upload")
//    @ResponseBody
    @RequestMapping("/upload")
    public String loadImage(@RequestBody MultipartFile pc1, photoInfo photoInfo,Map<String,Object> map) throws IOException {
        String msg = "<a href=\"http://127.0.0.1:8080\">点击返回主页登陆</a>";
        loadImages loadImag = new loadImages();
        loadImag.singleFileUpload(pc1);
        photoInfo.setName(loadImages.photoName);
        int count = photoInfoDao.insert(photoInfo);
        if (count>0){
            map.put("msg", msg);
            return "successGetPhoto";
        }
        return "404";
    }

}