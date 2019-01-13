package com.infotsav.test.Main_Activities;

import android.content.Intent;
import android.net.Uri;

import static android.support.v4.content.ContextCompat.startActivity;

public class Contactus_details {
    private String id;
    private String name;
    private String email;
    private String dept;
    private String call;
    private int image;

    public Contactus_details() {
    }

    public Contactus_details(String id, String name, String email, String dept, String call,int image) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dept = dept;
        this.call=call;
        this.image=image;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDept() {
        return dept;
    }

    public String getCall() {
        return call;

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public int getImage() {
        return image;
    }

}

