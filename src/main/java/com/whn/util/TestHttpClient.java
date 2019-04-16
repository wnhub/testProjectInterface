package com.whn.util;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * <dependency>
 *      <groupId>org.apache.httpcomponents</groupId>
 *      <artifactId>httpclient</artifactId>
 *      <version>4.5.2</version>
 * </dependency>
 */
public class TestHttpClient {
    public static String get(String url) throws IOException {
        //创建一个默认连接
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        //获取状态吗，判断状态
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            org.apache.http.HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity, "UTF-8");
            System.out.println("result:" + result);
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            TestHttpClient.get("http://localhost:8080/myServer/StudentInq");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
