package com.travala.authentication.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {
    private String email;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("avatar")
    private String avatar;
    @JsonProperty("is_enable_2fa")
    private boolean isEnable2Fa;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("address")
    private String address;
    @JsonProperty("referral_link")
    private String referralLink;
    @JsonProperty("referral_code")
    private String referralCode;

    @JsonProperty("token")
    private String token;

    public String getEmail() {
        return email;
    }

    public UserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public UserDTO setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public boolean isEnable2Fa() {
        return isEnable2Fa;
    }

    public UserDTO setEnable2Fa(boolean enable2Fa) {
        isEnable2Fa = enable2Fa;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getReferralLink() {
        return referralLink;
    }

    public UserDTO setReferralLink(String referralLink) {
        this.referralLink = referralLink;
        return this;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public UserDTO setReferralCode(String referralCode) {
        this.referralCode = referralCode;
        return this;
    }

    public String getToken() {
        return token;
    }

    public UserDTO setToken(String token) {
        this.token = token;
        return this;
    }
}
