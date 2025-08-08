package com.example.inventory;

import java.util.Map;

public class InventoryUseCaseDispatcher {
    private final Map<Role, InventoryUseCase> strategies;

    public InventoryUseCaseDispatcher() {
        strategies = Map.of(
                Role.ADMIN, new AdminInventoryUseCase(),
                Role.USER, new UserInventoryUseCase(),
                Role.SYSTEM, new SystemInventoryUseCase());
    }

    public InventoryUseCase get(User user) {
        InventoryUseCase useCase = strategies.get(user.role());
        return useCase;
    }
}