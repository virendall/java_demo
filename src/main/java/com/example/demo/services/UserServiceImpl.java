package com.example.demo.services;

import com.example.demo.adapters.UserAdapter;
import com.example.demo.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserAdapter adapter;

    @Override
    public String getInfo() throws Exception {
        return adapter.loadInfo();
    }

    @Override
    public String postInfo(Map<String, String> map) throws Exception {
        return adapter.postInfo(map);
    }
}
