package com.example.inventory.web.commands;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.inventory.application.InventoryApi;
import com.example.inventory.web.JsonUtil;
import com.example.inventory.web.dto.InventoryResponse;

/**
 * 全在庫取得指示
 */
public final class ListInventoriesCommand extends BaseJsonCommand {
    private final InventoryApi api;

    public ListInventoriesCommand(InventoryApi api) {
        this.api = api;
    }

    @Override
    protected void doHandle(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        // Httpメソッド実行
        List<InventoryResponse> result = api.getAllInventories();

        // ヘッダー情報付与
        resp.setStatus(200);
        resp.setContentType("application/json");

        // ボディ情報付与
        JsonUtil.mapper().writeValue(resp.getOutputStream(), result);
    }
}