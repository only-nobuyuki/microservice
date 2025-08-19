package com.example.inventory.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.example.inventory.web.dto.InventoryRequest;
import com.example.inventory.web.dto.InventoryResponse;

/**
 * 在庫のリポジトリ
 */
public interface InventoryRepository {

    // Listはnullにしないこと。
    /**
     * 全在庫取得
     * 
     * @param con
     *            トランザクション管理のため
     * @return 在庫リスト
     */
    List<InventoryResponse> findAll(Connection con) throws SQLException;

    //取得件が0の場合を考慮してOptionalを使用する。
    /**
     * アイテムIDを指定して商品単体取得<br>
     * 
     * @param con
     *            トランザクション管理のため
     * @return 在庫
     */
    Optional<InventoryResponse> findById(Connection con, String itemId) throws SQLException;

    /**
     * 商品を追加
     * 
     * @param con
     *            トランザクション管理のため
     * @return 登録成功した在庫
     */
    int save(Connection con, InventoryRequest inventory) throws SQLException;

    /**
     * 商品を更新することで在庫数を変更
     * 
     * @param con
     *            トランザクション管理のため
     * @return 更新件数
     */
    int update(Connection con, InventoryRequest inventory) throws SQLException;

    /**
     * 在庫を恒久的に削除
     * 
     * @param con
     *            トランザクション管理のため
     * @return 削除件数
     */
    int deleteById(Connection con, String itemId) throws SQLException;

}