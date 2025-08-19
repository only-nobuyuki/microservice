package com.example.inventory.web;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.inventory.web.commands.Command;

public class InventoryServlet extends HttpServlet {
    // finalは行わない。init()で初期化後に再定義は行わないため
    private CommandFactory factory;

    @Override
    public void init() {

        this.factory = new CommandFactory(null);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        dispatch(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        dispatch(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        dispatch(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        dispatch(req, resp);
    }

    //例外処理はこのタイミングでよいのか
    /**
     * コマンドインターフェースを呼び出す。
     * @param
     */
    private void dispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            Command cmd = factory.resolveHttpPath(req);
            cmd.handle(req, resp);
        } catch (Exception e) {
            Errors.writeJson(resp, 500, "INTERNAL_ERROR", "internal server error");
        }

    }

}