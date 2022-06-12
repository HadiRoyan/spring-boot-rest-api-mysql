package com.hadroy.SchoolManagementSystem.model;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.util.List;

public class ResponseError {

    private int codeStatus;

    private String error;

    private List<String> messages;

    public ResponseError() {
    }

    public ResponseError(int codeStatus, String error, List<String> messages) {
        this.codeStatus = codeStatus;
        this.error = error;
        this.messages = messages;
    }

    public int getCodeStatus() {
        return codeStatus;
    }

    public void setCodeStatus(int codeStatus) {
        this.codeStatus = codeStatus;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
