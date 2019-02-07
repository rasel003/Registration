package com.rasel.registration;

import java.util.List;

class AllUserResponse {

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
