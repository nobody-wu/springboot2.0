package com.example.http;

import com.alibaba.fastjson.JSON;
import com.example.springboot2docker.Springboot2DockerApplication;
import com.example.springboot2docker.util.HttpClientHelper;
import com.google.common.collect.Maps;
import com.taobao.api.Constants;
import com.taobao.api.internal.util.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.*;

/**
 * @Author: wujiapeng
 * @Description: java 常见几种发送http请求案例
 * @Date: created in 17:16 2018/6/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Springboot2DockerApplication.class)
public class HttpRequestMethodTest {

    @Test
    public void signTest() throws IOException {
        Map<String, Object> params = Maps.newHashMap();
        params.put("method", "alitrip.travel.trades.search");
        params.put("app_key", "123456");
        params.put("sign_method", "md5");
        params.put("timestamp", new Date().getTime());
        params.put("v", "2.0");
        params.put("order_id", "12233");
        params.put("format", "json");
        params.put("sign", signTopRequest(params, "", "md5"));

        System.out.println(HttpClientHelper.httpClientPost("http://gw.api.tbsandbox.com/router/rest", params, "utf-8"));
//        HttpClient httpClient = new DefaultHttpClient();
//        HttpPost httpPost = new HttpPost("http://gw.api.tbsandbox.com/router/rest");
//        // 构建请求参数
//        List<NameValuePair> list = new ArrayList<>();
//        for (Map.Entry<String, Object> elem : params.entrySet()) {
//            list.add(new BasicNameValuePair(elem.getKey(), String.valueOf(elem.getValue())));
//        }
//        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "utf-8");
//        httpPost.setEntity(entity);
//        HttpResponse response = httpClient.execute(httpPost);
//        // 读取服务器响应数据
//        StringBuilder resultBuffer = new StringBuilder();
//        BufferedReader br;
//        br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//        String temp;
//        while ((temp = br.readLine()) != null) {
//            resultBuffer.append(temp);
//        }
//        System.out.println(JSON.toJSONString(resultBuffer));
    }

    public static String signTopRequest(Map<String, Object> params, String secret, String signMethod) throws IOException {
        // 第一步：检查参数是否已经排序
        String[] keys = params.keySet().toArray(new String[0]);
        Arrays.sort(keys);

        // 第二步：把所有参数名和参数值串在一起
        StringBuilder query = new StringBuilder();
        if (Constants.SIGN_METHOD_MD5.equals(signMethod)) {
            query.append(secret);
        }
        for (String key : keys) {
            String value = params.get(key).toString();
            if (StringUtils.areNotEmpty(key, value)) {
                query.append(key).append(value);
            }
        }

        // 第三步：使用MD5/HMAC加密
        byte[] bytes;
        if (Constants.SIGN_METHOD_HMAC.equals(signMethod)) {
            bytes = encryptHMAC(query.toString(), secret);
        } else {
            query.append(secret);
            bytes = encryptMD5(query.toString());
        }

        // 第四步：把二进制转化为大写的十六进制(正确签名应该为32大写字符串，此方法需要时使用)
        return byte2hex(bytes);
    }

    public static byte[] encryptHMAC(String data, String secret) throws IOException {
        byte[] bytes = null;
        try {
            SecretKey secretKey = new SecretKeySpec(secret.getBytes(Constants.CHARSET_UTF8), "HmacMD5");
            Mac mac = Mac.getInstance(secretKey.getAlgorithm());
            mac.init(secretKey);
            bytes = mac.doFinal(data.getBytes(Constants.CHARSET_UTF8));
        } catch (GeneralSecurityException gse) {
            throw new IOException(gse.toString());
        }
        return bytes;
    }

    public static byte[] encryptMD5(String data) throws IOException {
        return data.getBytes(Constants.CHARSET_UTF8);
    }

    public static String byte2hex(byte[] bytes) {
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex.toUpperCase());
        }
        return sign.toString();
    }
}
