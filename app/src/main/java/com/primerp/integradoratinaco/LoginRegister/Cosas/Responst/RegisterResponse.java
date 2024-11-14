package com.primerp.integradoratinaco.LoginRegister.Cosas.Responst;

public class RegisterResponse {
    private String message;
    private boolean success;

    // Constructor, getters y setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
