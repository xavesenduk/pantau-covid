package com.example.pantaucovid.model;

import org.json.JSONObject;

import java.util.List;

public class CovidSulut {
    //"FID":25,"Kode_Provi":71,"Provinsi":"Sulawesi Utara","Kasus_Posi":15638,"Kasus_Semb":12961,"Kasus_Meni":504
    private GlobalAttributes attributes;

    public GlobalAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(GlobalAttributes attributes) {
        this.attributes = attributes;
    }
}
