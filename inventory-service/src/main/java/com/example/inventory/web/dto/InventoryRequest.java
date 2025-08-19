package com.example.inventory.web.dto;
/**
 * 在庫のリクエストモデル
 * 
 * @param itemId 商品ID
 * @param name 商品名
 * @param stock 在庫数
 */
public record InventoryRequest(String itemId, String name, int stock) {

}
