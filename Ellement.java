package com.example.a1.ret;

public class Ellement {

    int count;
    String created;
    String lang;
    Results results;

    public Ellement(int count, String created, String lang, Results results) {
        this.count = count;
        this.created = created;
        this.lang = lang;
        this.results = results;
    }

    public Results getResults() {
        return results;
    }

    public int getCount() {
        return count;
    }

    public String getCreated() {
        return created;
    }

    public String getLang() {
        return lang;
    }
}
