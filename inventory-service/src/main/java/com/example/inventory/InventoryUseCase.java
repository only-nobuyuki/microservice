package com.example.inventory;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.inventory.response.InventoryResponse;

/**
 * invetory-serviceAPI
 *
 * <p>
 * このクラスは◇◇と連携して動作します。
 * スレッドセーフではありません。
 * </p>
 */
public interface InventoryUseCase {

    /**
     * すべての在庫を取得する
     *
     * @return 商品情報リスト
     */
    List<InventoryResponse> getAllInventories();

    /**
     * 商品を在庫に登録する。
     *
     * @return 商品情報
     */
    InventoryResponse registerInventory();

    /**
     * アイテムIDを指定して商品情報を取得する。
     *
     * @param req リクエスト情報
     * @return 商品情報
     */
    InventoryResponse getInventoryByItemId(HttpServletRequest req);

    // TODO 現バージョンでは商品情報をすべて更新する実装
    /**
     * アイテムIDを指定して在庫数を変更する。
     * 
     * @param req リクエスト情報
     * @return 商品情報
     */
    InventoryResponse adjustInventory(HttpServletRequest req);

    /**
     * アイテムIDを指定して在庫数を削除する。
     *
     * @param req リクエスト情報
     */
    void deactivateInventory(HttpServletRequest req);
}