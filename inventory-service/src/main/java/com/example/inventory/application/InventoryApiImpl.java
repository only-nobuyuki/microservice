package com.example.inventory.application;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.example.inventory.exceptions.ConflictException;
import com.example.inventory.infrastructure.TransactionManager;
import com.example.inventory.repository.InventoryRepository;
import com.example.inventory.web.dto.InventoryRequest;
import com.example.inventory.web.dto.InventoryResponse;

/**
 * InventoryApiの具象クラス
 */
public class InventoryApiImpl implements InventoryApi {
    private final TransactionManager transactionManager;
    private final InventoryRepository repository;

    public InventoryApiImpl(TransactionManager transactionManager, InventoryRepository repository) {
        this.transactionManager = transactionManager;
        this.repository = repository;
    }

    @Override
    public List<InventoryResponse> getAllInventories() {
        return transactionManager.executeInTransaction(con -> {
            try {
                return repository.findAll(con);
            } catch (SQLException e) {
                throw translate(e);
            }
        });
    }

    @Override
    public InventoryResponse getInventoryByItemId(String itemId) {
        return transactionManager.executeInTransaction(con -> {
            try {
                Optional<InventoryResponse> result = repository.findById(con, itemId);
                // 取得できない場合はエラーを投げる？
                if (result.isEmpty()) {
                    // 例外をどう処理するか。ここで書いてよいのか
                }
                return result.get();
            } catch (SQLException e) {
                throw translate(e);
            }
        });
    }

    @Override
    public InventoryResponse registerInventory(InventoryRequest inv) {
        return transactionManager.executeInTransaction(con -> {
            try {
                int rowRecord = repository.save(con, inv);
                if (rowRecord == 1) {
                    return repository.findById(con, inv.itemId()).get();
                }
                // 例外をどう処理するか。ここで書いてよいのか
                throw new ConflictException("");
            } catch (SQLException e) {
                throw translate(e);
            }
        });

    }

    @Override
    public InventoryResponse adjustInventory(InventoryRequest inv) {
        return transactionManager.executeInTransaction(con -> {
            try {
                int rowRecord = repository.update(con, inv);
                if (rowRecord == 1) {
                    return repository.findById(con, inv.itemId()).get();
                }
                // 例外をどう処理するか。ここで書いてよいのか
                throw new ConflictException("");
            } catch (SQLException e) {
                throw translate(e);
            }
        });
    }

    @Override
    public void deactivateInventory(String itemId) {
        transactionManager.executeInTransaction(con -> {
            try {
                int rowRecord = repository.deleteById(con, itemId);
                if (rowRecord == 0) {
                    // 例外をどう処理するか。ここで書いてよいのか
                    throw new ConflictException("");
                }
                // deactivateInventoryの制約のために実装
                return null;
            } catch (SQLException e) {
                throw translate(e);
            }
        });
    }

    /**
     * レスポンス用の例外処理を投げる。
     * 
     * @return
     *         <ul>
     *         <p>
     *         一意制約違反の場合
     *         </p>
     *         <li>ConflictException
     *         <p>
     *         上記以外の場合
     *         </p>
     *         <li>RuntimeException</li>
     *         </li>
     *         </ul>
     */
    private RuntimeException translate(SQLException e) {
        if (e.getSQLState().equals("23505")) {
            return new ConflictException("duplicate key");
        }
        return new RuntimeException(e);
    }
}