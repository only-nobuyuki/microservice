package com.example.inventory;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 内部システムロールを想定したREST APIを提供する。
 *
 * <p>
 * このクラスは◇◇と連携して動作します。
 * スレッドセーフではありません。
 * </p>
 */
public class SystemInventoryServlet extends HttpServlet  {
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse res) throws IOException {
        // 商品数変更
        // serviceクラス処理呼び出し
    }
}