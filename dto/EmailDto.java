package com.define.definepage.dto;

public class EmailDto {
    private String name;
    private String email;
    private String category;
    private String priority;
    private boolean subscribe;
    private String message;
    private String recaptchaToken;
    private String formType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public boolean isSubscribe() {
        return subscribe;
    }

    public void setSubscribe(boolean subscribe) {
        this.subscribe = subscribe;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRecaptchaToken() {
        return recaptchaToken;
    }

    public void setRecaptchaToken(String recaptchaToken) {
        this.recaptchaToken = recaptchaToken;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    @Override
    public String toString() {
        return "EmailDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", category='" + category + '\'' +
                ", priority='" + priority + '\'' +
                ", subscribe=" + subscribe +
                ", message='" + message + '\'' +
                ", recaptchaToken='" + recaptchaToken + '\'' +
                ", formType='" + formType + '\'' +
                '}';
    }
}
