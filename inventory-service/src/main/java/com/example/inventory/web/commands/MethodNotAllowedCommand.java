package com.example.inventory.web.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.inventory.web.Errors;

// クラス名が悩む
/**
 * 
 */
public class MethodNotAllowedCommand extends BaseJsonCommand {

    @Override
    protected void doHandle(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Errors.writeJson(resp, 405, "METHOD_NOT_ALLOWED", "method not allowed");
        resp.setHeader("Allow", "GET,POST,PUT,DELETE");
    }
}
