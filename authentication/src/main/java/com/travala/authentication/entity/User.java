package com.travala.authentication.entity;

import com.travala.authentication.constants.TwoFactorType;
import commons.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "auth_user")
public class User extends BaseEntity {
    private String password;
    @Column(name = "is_superuser")
    private boolean isSupperUser;
    @Column(name = "username")
    private String username;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "is_staff")
    private boolean isStaff;
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "phone")
    private String phone;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "facebook_id")
    private String facebookId;
    @Column(name = "google_id")
    private String googleId;
    @Column(name = "avatar_link")
    private String avatarLink;
    @Column(name = "two_factor_key")
    private String twoFactorKey;
    @Column(name = "is_deleted")
    private boolean isDeleted;
    @Column(name = "reason")
    private String reason;
    @Column(name = "two_factor_type")
    @Enumerated(EnumType.STRING)
    private TwoFactorType twoFactorType;

    @Column(name = "backup_code")
    private String backupCode;
    @Column(name = "update_password")
    private boolean updatedPassword;

    @Column(name = "activated_date")
    private Date activatedDate;
    @Column(name = "empty_email")
    private boolean emptyEmail;
    @Column(name = "user_code")
    private String userCode;

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public boolean isSupperUser() {
        return isSupperUser;
    }

    public User setSupperUser(boolean supperUser) {
        isSupperUser = supperUser;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public boolean isStaff() {
        return isStaff;
    }

    public User setStaff(boolean staff) {
        isStaff = staff;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public User setActive(boolean active) {
        isActive = active;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public User setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public User setFacebookId(String facebookId) {
        this.facebookId = facebookId;
        return this;
    }

    public String getGoogleId() {
        return googleId;
    }

    public User setGoogleId(String googleId) {
        this.googleId = googleId;
        return this;
    }

    public String getAvatarLink() {
        return avatarLink;
    }

    public User setAvatarLink(String avatarLink) {
        this.avatarLink = avatarLink;
        return this;
    }

    public String getTwoFactorKey() {
        return twoFactorKey;
    }

    public User setTwoFactorKey(String twoFactorKey) {
        this.twoFactorKey = twoFactorKey;
        return this;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public User setDeleted(boolean deleted) {
        isDeleted = deleted;
        return this;
    }

    public String getReason() {
        return reason;
    }

    public User setReason(String reason) {
        this.reason = reason;
        return this;
    }

    public TwoFactorType getTwoFactorType() {
        return twoFactorType;
    }

    public User setTwoFactorType(TwoFactorType twoFactorType) {
        this.twoFactorType = twoFactorType;
        return this;
    }

    public String getBackupCode() {
        return backupCode;
    }

    public User setBackupCode(String backupCode) {
        this.backupCode = backupCode;
        return this;
    }

    public boolean isUpdatedPassword() {
        return updatedPassword;
    }

    public User setUpdatedPassword(boolean updatedPassword) {
        this.updatedPassword = updatedPassword;
        return this;
    }

    public Date getActivatedDate() {
        return activatedDate;
    }

    public User setActivatedDate(Date activatedDate) {
        this.activatedDate = activatedDate;
        return this;
    }

    public boolean isEmptyEmail() {
        return emptyEmail;
    }

    public User setEmptyEmail(boolean emptyEmail) {
        this.emptyEmail = emptyEmail;
        return this;
    }

    public String getUserCode() {
        return userCode;
    }

    public User setUserCode(String userCode) {
        this.userCode = userCode;
        return this;
    }
}
