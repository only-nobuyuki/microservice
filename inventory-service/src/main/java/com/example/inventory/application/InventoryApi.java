package com.example.inventory.application;

import java.util.List;

import com.example.inventory.web.dto.InventoryRequest;
import com.example.inventory.web.dto.InventoryResponse;

/**
 * InventoryAPIを抽象で表現
 */
public interface InventoryApi {

    /**
     * 全在庫取得オペレーション
     * 
     * @return Inventoryのレスポンスモデルリスト
     */
    List<InventoryResponse> getAllInventories();

    /**
     * 在庫取得（アイテムIDを指定）オペレーション
     * 
     * @param アイテムID
     * @return Inventoryのレスポンスモデル
     */
    InventoryResponse getInventoryByItemId(String itemId);

    /**
     * 在庫登録オペレーション
     * 
     * @param
     * @return Inventoryのレスポンスモデル
     */
    InventoryResponse registerInventory(InventoryRequest inv);

    /**
     * 商品数変更（アイテムIDを指定）オペレーション
     * 
     * @param
     * @return Inventoryのレスポンスモデル
     */
    InventoryResponse adjustInventory(InventoryRequest inv);

    /**
     * 商品削除（アイテムIDを指定）オペレーション
     * 
     * @param アイテムID
     */
    void deactivateInventory(String itemId);
}
