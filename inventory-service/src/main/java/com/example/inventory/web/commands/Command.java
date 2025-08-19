package com.example.inventory.web.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 操作を定義するインターフェース
 * <p>
 * Commandパターン
 * </p>
 */
public interface Command {

    /**
     * 
     * @param
     */
    void handle(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}