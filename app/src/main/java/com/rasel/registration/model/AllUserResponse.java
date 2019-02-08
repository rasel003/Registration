package com.rasel.registration.model;

import com.rasel.registration.model.UserInfo;

import java.util.List;

public class AllUserResponse {

    private String Message, Status;
    private List<UserInfo> Data;

    public String getMessage() {
        return Message;
    }

    public String getStatus() {
        return Status;
    }

    public List<UserInfo> getData() {
        return Data;
    }
}
