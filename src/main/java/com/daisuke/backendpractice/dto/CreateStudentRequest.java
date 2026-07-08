package com.daisuke.backendpractice.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateStudentRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String major;

    public CreateStudentRequest() {

    }

    public CreateStudentRequest(String name, String major) {
        this.name = name;
        this.major = major;
    }

    public String getName() {
        return this.name;
    }

    public String getMajor() {
        return this.major;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
