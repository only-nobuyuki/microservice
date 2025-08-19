package com.example.inventory.web.dto;

/**
 * 在庫のレスポンスモデル
 * 
 * @param itemId 商品ID
 * @param name 商品名
 * @param stock 在庫数
 */
public record InventoryResponse(String itemId, String name, int stock) {
}
