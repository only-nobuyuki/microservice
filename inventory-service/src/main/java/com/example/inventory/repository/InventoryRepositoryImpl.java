package com.example.inventory.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.inventory.web.dto.InventoryRequest;
import com.example.inventory.web.dto.InventoryResponse;

/**
 * データベースを使用したInventoryRepositoryの具象クラス
 */
public class InventoryRepositoryImpl implements InventoryRepository {

    @Override
    public List<InventoryResponse> findAll(Connection con) throws SQLException {
        // SQL実行
        String sql = """
                SELECT
                 item_id,
                 name,
                 quantity
                FROM
                 inventories
                ORDER BY
                 item_id
                        """;
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet reslut = ps.executeQuery();

        // SQL実行結果処理
        List<InventoryResponse> list = new ArrayList<>();
        while (reslut.next()) {
            list.add(mapping(reslut));
        }
        return list;
    }

    @Override
    public Optional<InventoryResponse> findById(Connection con, String itemId) throws SQLException {
        // SQL実行
        String sql = """
                SELECT
                  item_id,
                  name,
                  quantity
                FROM
                  inventories
                WHERE
                  item_id = ?
                        """;
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, itemId);
        ResultSet reslut = ps.executeQuery();

        // SQL実行結果処理
        while (reslut.next()) {
            return Optional.of(mapping(reslut));
        }
        return Optional.empty();
    }

    @Override
    public int save(Connection con, InventoryRequest inventory) throws SQLException {
        // SQL実行
        String sql = """
                INSERT INTO
                  inventories(item_id, name, stock)
                VALUES
                  (?,?,?)
                """;
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, inventory.itemId());
        ps.setString(2, inventory.name());
        ps.setInt(3, inventory.stock());
        int rowCount = ps.executeUpdate();

        // SQL実行結果処理
        return rowCount;
    }

    @Override
    public int update(Connection con, InventoryRequest inventory) throws SQLException {
        // SQL実行
        String sql = """
                UPDATE
                  inventories
                SET
                  item_id = ?,
                  name = ?,
                  stock = ?
                WHERE
                  item_id = ?
                        """;
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, inventory.itemId());
        ps.setString(2, inventory.name());
        ps.setInt(3, inventory.stock());
        ps.setString(4, inventory.itemId());
        int rowCount = ps.executeUpdate();

        // SQL実行結果処理
        return rowCount;
    }

    @Override
    public int deleteById(Connection con, String itemId) throws SQLException {
        // SQL実行
        String sql = """
                DELETE
                FROM
                  inventories
                        """;
        PreparedStatement ps = con.prepareStatement(sql);
        int rowCount = ps.executeUpdate();

        // SQL実行結果処理
        return rowCount;
    }

    /**
     * クエリ結果をInventoryResponseのフィールドにマッピングする。
     * 
     * @return 在庫のレスポンスモデル
     */
    private InventoryResponse mapping(ResultSet resultSet) throws SQLException {
        return new InventoryResponse(
                resultSet.getString("item_id"),
                resultSet.getString("name"),
                Integer.parseInt(resultSet.getString("stock")));
    }
}