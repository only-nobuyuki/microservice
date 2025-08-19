package com.example.inventory.exceptions;

/**
 * httpレスポンスが404の例外
 * <p>
 * <a href="https://developer.mozilla.org/ja/docs/Web/HTTP/Reference/Status/404">MDN Web Docs</a>
 * </p>
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String msg) {
        super(msg);
    }
}