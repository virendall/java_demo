package com.example.demo.connection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import java.util.List;
import java.util.Map;

public interface HttpResponse {
    String sendGet(String url) throws Exception;

    String sendPost(String url,
                    Map<String, String> params,
                    Map<String, String> header) throws Exception;
}
