package com.example.inventory.web.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.inventory.application.InventoryApi;
import com.example.inventory.web.JsonUtil;
import com.example.inventory.web.Path;
import com.example.inventory.web.dto.InventoryResponse;

/**
 * 在庫取得指示
 * <p>
 * 在庫はアイテムIDで指定する
 * </p>
 */
public class GetInventoryCommand extends BaseJsonCommand {
    private final InventoryApi api;

    public GetInventoryCommand(InventoryApi api) {
        this.api = api;
    }

    @Override
    protected void doHandle(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        // Httpメソッド実行
        String itemuId = Path.extractItemId(req);
        InventoryResponse resulut = api.getInventoryByItemId(itemuId);

        // ヘッダー情報付与
        resp.setStatus(200);
        resp.setContentType("application/json");

        // ボディ情報付与
        JsonUtil.mapper().writeValue(resp.getOutputStream(), resulut);
    }
}