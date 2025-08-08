package com.example.inventory;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.inventory.response.InventoryResponse;

public class SystemInventoryUseCase implements InventoryUseCase {
    @Override
    public List<InventoryResponse> getAllInventories() {
        return null;
    }

    @Override
    public InventoryResponse registerInventory() {
        return null;
    }

    @Override
    public InventoryResponse getInventoryByItemId(HttpServletRequest req) {
        return null;
    }

    @Override
    public InventoryResponse adjustInventory(HttpServletRequest req) {
               // なんとかサービスクラスを呼び出す
        return new InventoryResponse();
    }

    @Override
    public void deactivateInventory(HttpServletRequest req) {

    }
}
