package com.example.inventory.request;

public record InventoryRequest(String itemId, String name, int stock) {
}