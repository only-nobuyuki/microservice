package com.example.inventory.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * ObjectMapperの生成クラス
 */
public final class JsonUtil {
    // ObjectMapperはスレッドセーフであるため、生成は一回行えば十分
    private static final ObjectMapper mapper = new ObjectMapper()
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    private JsonUtil() {
    }

    /**
     * ObjectMapperインスタンスの生成
     * 
     * @return　ObjectMapperインスタンス
     */
    public static ObjectMapper mapper() {
        return mapper;
    }
}