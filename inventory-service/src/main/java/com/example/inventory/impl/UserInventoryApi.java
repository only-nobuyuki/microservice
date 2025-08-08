package com.example.inventory.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.inventory.InventoryUseCase;
import com.example.inventory.response.InventoryResponse;

public class UserInventoryApi implements InventoryUseCase{

    @Override
    public List<InventoryResponse> getAllInventories() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllInventories'");
    }

    @Override
    public InventoryResponse registerInventory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registerInventory'");
    }

    @Override
    public InventoryResponse getInventoryByItemId(HttpServletRequest req) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInventoryByItemId'");
    }

    @Override
    public InventoryResponse adjustInventory(HttpServletRequest req) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adjustInventory'");
    }

    @Override
    public void deactivateInventory(HttpServletRequest req) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deactivateInventory'");
    }

}
