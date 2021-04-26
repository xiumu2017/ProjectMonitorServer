package com.paradise.core.entity.ding;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ResMsg {
    private String text;
    private List<String> atMobiles;
    private List<String> atUserIds;
    private boolean isAtAll;

    public ResMsg(String text, String userId) {
        this.text = text;
        this.atUserIds = Collections.singletonList(userId);
    }

    /**
     * 生成 Json
     *
     * @return String 字符串
     */
    public String toJsonString() {
        Map<String, Object> items = new HashMap<>(2);
        items.put("msgtype", "text");
        Map<String, String> textContent = new HashMap<>(4);
        if (StringUtils.isBlank(this.text)) {
            throw new IllegalArgumentException("text should not be blank");
        } else {
            textContent.put("content", this.text);
            items.put("text", textContent);
            Map<String, Object> atItems = new HashMap<>(3);
            if (this.atMobiles != null && !this.atMobiles.isEmpty()) {
                atItems.put("atMobiles", this.atMobiles);
            }
            if (this.atUserIds != null && !this.atUserIds.isEmpty()) {
                atItems.put("atUserIds", this.atUserIds);
            }

            if (this.isAtAll) {
                atItems.put("isAtAll", true);
            }
            items.put("at", atItems);
            return JSON.toJSONString(items);
        }
    }

}
