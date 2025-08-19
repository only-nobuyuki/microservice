package com.example.inventory.infrastructure;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.function.Function;

import javax.sql.DataSource;

/**
 * トランザクションを制御
 */
public final class TransactionManager {
    private final DataSource dSource;

    public TransactionManager(DataSource dSource) {
        this.dSource = dSource;
    }

    /**
     * トランザクション制御実行
     * 
     * @param <T> inventoryApiImplの実行結果の戻り値の型
     * @param inventoryApiImpl InventoryApiImplの各メソッド
     * @return inventoryApiImplの実行結果
     */
    public <T> T executeInTransaction(Function<Connection, T> inventoryApiImpl) {
        try (Connection con = dSource.getConnection()) {
            con.setAutoCommit(false);
            try {
                T result = inventoryApiImpl.apply(con);
                con.commit();
                return result;
            } catch (Exception e) {
                try {
                    con.rollback();
                } catch (SQLException ignored) {
                }
                throw e;
            }
        } catch (SQLException e) {
            throw new RuntimeException("DB connection/tx error", e);
        }
    }
}