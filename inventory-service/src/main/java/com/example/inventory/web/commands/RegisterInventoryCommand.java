package com.example.inventory.web.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.inventory.application.InventoryApi;
import com.example.inventory.web.JsonUtil;
import com.example.inventory.web.dto.InventoryRequest;
import com.example.inventory.web.dto.InventoryResponse;

/**
 * 在庫登録指示
 */
public class RegisterInventoryCommand extends BaseJsonCommand {
    private final InventoryApi api;

    public RegisterInventoryCommand(InventoryApi api) {
        this.api = api;
    }

    @Override
    protected void doHandle(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        // Httpメソッド実行
        var requestBody = JsonUtil.mapper().readValue(req.getInputStream(), InventoryRequest.class);
        InventoryResponse resulut = api.registerInventory(requestBody);

        // ヘッダー情報付与
        resp.setStatus(201);
        // Httpの仕様に基づく動作（サーバーが201を返す場合）
        // 「新しく作成されたリソースの URI を Location ヘッダに含めるべき」
        resp.setHeader("Location", req.getContextPath() + "/invetories" + resulut.itemId());
        resp.setContentType("application/json");

        // ボディ情報付与
        JsonUtil.mapper().writeValue(resp.getOutputStream(), resulut);
    }
}