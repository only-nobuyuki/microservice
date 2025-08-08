package com.example.inventory;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ユーザーロールを想定したREST APIを提供する。
 *
 * <p>
 * このクラスは◇◇と連携して動作します。
 * スレッドセーフではありません。
 * </p>
 */
public class UserInventoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String pathInfo = req.getPathInfo();

        if (null != pathInfo &&
                pathInfo.equals("/")) {
            // 全在庫取得
            // serviceクラス処理呼び出し
        } else {
            // 個別取得
            // serviceクラス処理呼び出し
        }
    }
}