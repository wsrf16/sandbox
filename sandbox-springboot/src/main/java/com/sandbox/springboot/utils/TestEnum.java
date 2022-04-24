package com.sandbox.springboot.utils;

public enum TestEnum {
    BLACK(0, "BLACK", "BB"),
    RED(1, "RED", "RR");

    private int no;
    private String extra;
    private String desc;

    TestEnum(int no, String desc, String extra) {
        this.no = no;
        this.desc = desc;
        this.extra = extra;
    }
}