package com.example.inventory.web.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.inventory.application.InventoryApi;
import com.example.inventory.web.JsonUtil;
import com.example.inventory.web.dto.InventoryRequest;
import com.example.inventory.web.dto.InventoryResponse;

/**
 * 在庫数変更指示
 * <p>
 * 在庫モデルをすべて更新する。
 * </p>
 */
public class AdjustInventoryCommand extends BaseJsonCommand {
    private final InventoryApi api;

    public AdjustInventoryCommand(InventoryApi api) {
        this.api = api;
    }

    @Override
    protected void doHandle(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        // Httpメソッド実行
        var requestBody = JsonUtil.mapper().readValue(req.getInputStream(), InventoryRequest.class);
        InventoryResponse resulut = api.adjustInventory(requestBody);

        // ヘッダー情報付与
        resp.setStatus(200);
        resp.setContentType("application/json");

        // ボディ情報付与
        JsonUtil.mapper().writeValue(resp.getOutputStream(), resulut);
    }
}