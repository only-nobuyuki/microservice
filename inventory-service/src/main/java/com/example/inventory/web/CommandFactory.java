package com.example.inventory.web;

import javax.servlet.http.HttpServletRequest;

import com.example.inventory.application.InventoryApi;
import com.example.inventory.web.commands.AdjustInventoryCommand;
import com.example.inventory.web.commands.Command;
import com.example.inventory.web.commands.DeactivateInventoryCommand;
import com.example.inventory.web.commands.GetInventoryCommand;
import com.example.inventory.web.commands.ListInventoriesCommand;
import com.example.inventory.web.commands.RegisterInventoryCommand;

/**
 * 在庫数変更指示
 * <p>
 * 在庫モデルをすべて更新する。
 * </p>
 */
public final class CommandFactory {
    private final InventoryApi api;

    public  CommandFactory(InventoryApi api) {
        this.api = api;
    }

    public Command resolveHttpPath(HttpServletRequest req) {
        String method = req.getMethod();
        String servletPath = req.getServletPath();
        String pathInfo = req.getPathInfo();
        boolean isCollectionRequest = (pathInfo == null || pathInfo.equals("/"));

        if ("/inventories".equals(servletPath)) {
            switch (method) {
                case "GET":
                    if (isCollectionRequest) {
                        return new ListInventoriesCommand(api);
                    } else {
                        return new GetInventoryCommand(api);
                    }

                case "POST":
                    if (isCollectionRequest) {
                        return new RegisterInventoryCommand(api);
                    }
                    break;

                case "PUT":
                    if (!isCollectionRequest) {
                        return new AdjustInventoryCommand(api);
                    }
                    break;

                case "DELETE":
                    if (!isCollectionRequest) {
                        return new DeactivateInventoryCommand(api);
                    }
                    break;

                default:
                    break;
            }
        }
        return null;
    }
}