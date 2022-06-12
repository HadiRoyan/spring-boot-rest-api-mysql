package com.hadroy.SchoolManagementSystem.model;

public class ResponseApi <T> {

    public int code;

    public String status;

    public T data;

    public ResponseApi(int code, String status, T data) {
        this.code = code;
        this.status = status;
        this.data = data;
    }

    public ResponseApi(int code, String status) {
        this.code = code;
        this.status = status;
    }

}
