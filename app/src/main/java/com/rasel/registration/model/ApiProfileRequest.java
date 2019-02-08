package com.rasel.registration.model;

import com.rasel.registration.model.UserId;

public class ApiProfileRequest {
    private String Message;
    private Boolean Status;
    private UserId Data;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }

    public UserId getData() {
        return Data;
    }

    public void setData(UserId data) {
        Data = data;
    }

}
