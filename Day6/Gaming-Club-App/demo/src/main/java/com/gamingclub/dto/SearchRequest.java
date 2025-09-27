package com.gamingclub.dto;

public class SearchRequest {
    private String phone;

    public SearchRequest() {}

    public SearchRequest(String phone) {
        this.phone = phone;
    }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}