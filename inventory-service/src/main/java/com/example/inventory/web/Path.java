package com.example.inventory.web;

import javax.servlet.http.HttpServletRequest;

/**
 * APIリクエストのpath抽出
 */
public final class Path {
    private Path() {

    }

    /**
     * HttpServletRequestからパスを抽出
     * 
     * @param
     * @return パス
     */
    public static String extractItemId(HttpServletRequest req) {
        String pathInfo = req.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/") || pathInfo.isBlank()) {
            // 何らかの例外処理が必要な気がする
            return null;
        }
        if (pathInfo.startsWith("/")) {
            return pathInfo.substring(1);
        }

        return null;
        // 何らかの例外処理が必要な気がする
    }
}