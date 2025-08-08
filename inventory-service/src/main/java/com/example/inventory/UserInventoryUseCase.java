package com.example.inventory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.inventory.response.InventoryResponse;

public class UserInventoryUseCase implements InventoryUseCase {
    @Override
    public List<InventoryResponse> getAllInventories() {
        // なんとかサービスクラスを呼び出す
        return new ArrayList<>(Arrays.asList(new InventoryResponse()));
    }

    @Override
    public InventoryResponse registerInventory() {
        return null;
    }

    @Override
    public InventoryResponse getInventoryByItemId(HttpServletRequest req) {
        // なんとかサービスクラスを呼び出す
        return new InventoryResponse();
    }

    @Override
    public InventoryResponse adjustInventory(HttpServletRequest req) {
        return null;
    }

    @Override
    public void deactivateInventory(HttpServletRequest req) {

    }
}
