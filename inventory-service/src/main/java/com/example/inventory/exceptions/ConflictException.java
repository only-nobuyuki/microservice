package com.example.inventory.exceptions;

/**
 * httpレスポンスが409の例外
 * <p>
 * <a href="https://developer.mozilla.org/ja/docs/Web/HTTP/Reference/Status/409">MDN Web Docs</a>
 * </p>
 */
public class ConflictException extends RuntimeException {
    public ConflictException(String msg) {
        super(msg);
    }
}