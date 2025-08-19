package com.example.inventory.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.example.inventory.web.dto.ErrorResponse;

/**
 * エラーレスポンスのJsonオブジェクト生成
 */
public final class Errors {
    private Errors() {

    }

    /**
     * HttpServletResponseに情報を設定
     * 
     * @param
     */
    public static void writeJson(HttpServletResponse resp, int status, String code, String message) throws IOException {
        resp.setStatus(status);
        resp.setContentType("application/json");
        JsonUtil.mapper().writeValue(resp.getOutputStream(), new ErrorResponse(code, message));
    }

}