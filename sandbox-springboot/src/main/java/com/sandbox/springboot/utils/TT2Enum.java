package com.sandbox.springboot.utils;

public enum TT2Enum {
    F1(1, "f1"),
    F2(2, "f2");

    private int i;
    private String desc;

    TT2Enum(int i, String desc) {
        this.i = i;
        this.desc = desc;
    }
}
