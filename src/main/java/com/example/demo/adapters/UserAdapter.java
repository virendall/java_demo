package com.example.demo.adapters;

import com.example.demo.connection.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserAdapter {

    @Autowired
    HttpResponse httpClientExample;

    public String loadInfo() throws Exception {
        return httpClientExample.sendGet("YOur url here");
    }

    public String postInfo(Map<String, String> map) throws Exception {
        HashMap<String, String> header = new HashMap<>();
        header.put("Authorization", "695");
        return httpClientExample.sendPost(
                "Your url here",
                map,
                header);
    }
}
