package com.example.Ecommerce.Exception;

public class ItemAlreadyExistsException extends RuntimeException{

    //Exception for Item Already Exists
    public ItemAlreadyExistsException(String message) {
        super(message);
    }
}
