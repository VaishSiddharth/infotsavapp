package com.infotsav.test.Main_Activities;

public class Sponsors_details {
    private String id;
    private String sponsor_name;
    private String sponsor_level;
    private int sponsor_image;
    private String sponsor_dept;

    public Sponsors_details() {
    }

    public Sponsors_details(String id, String sponsor_name, String sponsor_level,  String sponsor_dept,int sponsor_image) {
        this.id = id;
        this.sponsor_name = sponsor_name;
        this.sponsor_level = sponsor_level;
        this.sponsor_image = sponsor_image;
        this.sponsor_dept = sponsor_dept;
    }


    public String getId() {
        return id;
    }

    public String getSponsor_name() {
        return sponsor_name;
    }

    public String getSponsor_level() {
        return sponsor_level;
    }

    public int getSponsor_image() {
        return sponsor_image;
    }

    public String getSponsor_dept() {
        return sponsor_dept;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSponsor_name(String sponsor_name) {
        this.sponsor_name = sponsor_name;
    }

    public void setSponsor_level(String sponsor_level) {
        this.sponsor_level = sponsor_level;
    }

    public void setSponsor_image(int sponsor_image) {
        this.sponsor_image = sponsor_image;
    }

    public void setSponsor_dept(String sponsor_dept) {
        this.sponsor_dept = sponsor_dept;
    }

}