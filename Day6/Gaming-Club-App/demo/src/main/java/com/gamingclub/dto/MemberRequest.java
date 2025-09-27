package com.gamingclub.dto;

public class MemberRequest {
    private String name;
    private String phone;
    private Double fee;

    public MemberRequest() {}

    public MemberRequest(String name, String phone, Double fee) {
        this.name = name;
        this.phone = phone;
        this.fee = fee;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Double getFee() { return fee; }
    public void setFee(Double fee) { this.fee = fee; }
}