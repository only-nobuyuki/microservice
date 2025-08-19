package com.example.inventory.exceptions;

/**
 * httpレスポンスが400の例外
 * <p>
 * <a href="https://developer.mozilla.org/ja/docs/Web/HTTP/Reference/Status/400">MDN Web Docs</a>
 * </p>
 */
public class BadRequestException extends RuntimeException {
    public BadRequestException(String msg) {
        super(msg);
    }
}