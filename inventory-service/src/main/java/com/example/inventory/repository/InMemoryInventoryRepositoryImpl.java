package com.example.inventory.repository;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import com.example.inventory.web.dto.InventoryRequest;
import com.example.inventory.web.dto.InventoryResponse;

/**
 * 動作確認（DB非接続）
 */
public class InMemoryInventoryRepositoryImpl implements InventoryRepository {
    private final Map<String, InventoryResponse> store = new ConcurrentHashMap<>();

    public InMemoryInventoryRepositoryImpl() {
        store.put("00AA", new InventoryResponse("00AA", "ポメラニアン", 1));
        store.put("00CC", new InventoryResponse("00AA", "ダルメシアン", 5));
    }

    @Override
    public List<InventoryResponse> findAll(Connection con) {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<InventoryResponse> findById(Connection con, String itemId) {
        return Optional.ofNullable(store.get(itemId));
        //Optional.ofNullable(store.get(itemId)).orElse(new InventoryResponse(null, null, 0));
    }

    @Override
    public int save(Connection con, InventoryRequest inventory) {
        InventoryResponse response = new InventoryResponse(inventory.itemId(), inventory.name(), inventory.stock());
        try {
            store.put(inventory.itemId(), response);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    public int update(Connection con, InventoryRequest inventory) {
        try {
            store.replace(inventory.itemId(), store.get(inventory.itemId()));
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    public int deleteById(Connection con, String itemId) {
        try {
            store.remove(itemId);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

}
