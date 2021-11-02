package com.example.demo.exception;

public class InvoiceNotFound extends RuntimeException{
    public InvoiceNotFound(String message) {super(message);}
}
