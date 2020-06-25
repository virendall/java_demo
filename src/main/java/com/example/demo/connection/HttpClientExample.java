package com.example.demo.connection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class HttpClientExample implements HttpResponse {

    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    private void close() throws IOException {
        httpClient.close();
    }

    public String sendGet(String url) throws Exception {
        HttpGet request = new HttpGet(url);
        request.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        request.addHeader(HttpHeaders.ACCEPT, "application/json");
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                return EntityUtils.toString(entity);
            }
        }
        return null;
    }

    public String sendPost(String url,
                           Map<String, String> params,
                           Map<String, String> header) throws Exception {
        HttpPost post = new HttpPost(url);
        header.forEach(
                (k, v) -> post.addHeader(k, v)
        );
        List<NameValuePair> urlParameters = new ArrayList<>();
        params.forEach(
                (k, v) -> urlParameters.add(new BasicNameValuePair(k, v))
        );
        post.addHeader(HttpHeaders.ACCEPT, "application/json");
        post.setEntity(new UrlEncodedFormEntity(urlParameters));
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {
            return EntityUtils.toString(response.getEntity());
        }
    }

}
