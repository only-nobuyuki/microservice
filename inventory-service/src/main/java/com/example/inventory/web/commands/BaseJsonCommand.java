package com.example.inventory.web.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.inventory.exceptions.BadRequestException;
import com.example.inventory.exceptions.NotFoundException;
import com.example.inventory.web.Errors;

// 疑問　正常系と異常系の制御なのか？
public abstract class BaseJsonCommand implements Command {

    @Override
    public void handle(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        try {
            doHandle(req, resp);
        } catch (BadRequestException e) {
            Errors.writeJson(resp, 400, "BadRequest", e.getMessage());
        } catch (NotFoundException e) {
            Errors.writeJson(resp, 404, "NotFound", e.getMessage());
        }

    }

    /**
     * リクエストとレスポンスの一連処理
     */
    protected abstract void doHandle(HttpServletRequest req, HttpServletResponse resp) throws Exception;

}