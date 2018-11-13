package com.example.a1.ret;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("query")
    @Expose
    private Ellement ellement;

    public Example(Ellement ellement) {
        this.ellement = ellement;
    }

    public Ellement getEllement() {
        return ellement;
    }
}
