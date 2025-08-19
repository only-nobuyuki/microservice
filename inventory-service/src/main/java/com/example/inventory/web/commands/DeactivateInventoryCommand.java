package com.example.inventory.web.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.inventory.application.InventoryApi;
import com.example.inventory.web.JsonUtil;
import com.example.inventory.web.dto.InventoryRequest;

public class DeactivateInventoryCommand extends BaseJsonCommand {
    private final InventoryApi api;

    public DeactivateInventoryCommand(InventoryApi api) {
        this.api = api;
    }

    @Override
    protected void doHandle(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        // Httpメソッド実行
        var requestBody = JsonUtil.mapper().readValue(req.getInputStream(), InventoryRequest.class);
        api.deactivateInventory(requestBody.itemId());
        // ヘッダー情報付与
        resp.setStatus(200);
    }
}