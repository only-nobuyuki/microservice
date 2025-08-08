package com.example.inventory;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 管理者ロールを想定したREST APIを提供する。
 *
 * <p>
 * このクラスは◇◇と連携して動作します。
 * スレッドセーフではありません。
 * </p>
 */
public class InventoryController extends HttpServlet {
    private final InventoryUseCaseDispatcher dispatcher = new InventoryUseCaseDispatcher();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        User use = UserResolver.resolve(req);
        InventoryUseCase useCase = dispatcher.get(use);
        String pathInfo = req.getPathInfo();
        if (null != pathInfo &&
                pathInfo.equals("/")) {
            // 全在庫取得
            // 入力チェッ？？
            // serviceクラス処理呼び出し
            useCase.getInventoryByItemId(req);
        } else {
            // 個別取得
            // serviceクラス処理呼び出し
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        // 在庫登録
        // 入力チェッ？？
        // serviceクラス処理呼び出し
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse res) throws IOException {
        // 商品数変更
        // 入力チェッ？？
        // serviceクラス処理呼び出し
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {
        // 商品削除
        // 入力チェッ？？
        // serviceクラス処理呼び出し
    }
}