
package com.paradise.core.utils.poem;


import chatbot.message.MarkdownMessage;
import chatbot.message.Message;
import com.alibaba.fastjson.JSONObject;
import com.paradise.core.entity.poem.Origin;
import com.paradise.core.entity.poem.PoemEntity;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author dzhang
 */
public class PoemSendUtils {
    private static final Logger logger = LoggerFactory.getLogger(PoemSendUtils.class);

    public static PoemEntity getPoem() throws IOException {
        String url = "https://v2.jinrishici.com/one.json";
        String token = "Xtw9qKYqtWSYAz51waUbbalXV/w2+w87";

        PoemEntity poemEntity = new PoemEntity();
        HttpClient httpclient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("Content-Type", "application/json; charset=utf-8");
        httpGet.addHeader("X-User-Token", token);

        HttpResponse httpResponse = httpclient.execute(httpGet);
        if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String result = EntityUtils.toString(httpResponse.getEntity());
            JSONObject obj = JSONObject.parseObject(result);
            poemEntity = obj.toJavaObject(PoemEntity.class);
            logger.info(obj.toJSONString());
            logger.info(">>>>>>>>>>>>>>>");
        }
        return poemEntity;
    }

    /**
     * 根据古诗词接口返回的实体类生成钉钉md message
     *
     * @param poemEntity 古诗词实体
     * @return Message
     */
    public static Message poem2Md(PoemEntity poemEntity) {
        MarkdownMessage message = new MarkdownMessage();
        message.setTitle(poemEntity.getData().getContent());
        Origin origin = poemEntity.getData().getOrigin();
        message.add(MarkdownMessage.getHeaderText(1, origin.getTitle()));
        message.add(MarkdownMessage.getHeaderText(3, origin.getAuthor() + " " + origin.getDynasty()));
        message.add(MarkdownMessage.getBoldText(origin.getContentStr()));
        if (StringUtils.isNotEmpty(origin.getTranslate())) {
            message.add(MarkdownMessage.getReferenceText(origin.getTranslate()));
        }
        message.add("  ");
        return message;
    }

}
