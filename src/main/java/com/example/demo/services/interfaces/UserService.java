package com.example.demo.services.interfaces;

import java.util.Map;

public interface UserService {

    String getInfo() throws Exception;

    String postInfo(Map<String, String> map) throws Exception;
}

