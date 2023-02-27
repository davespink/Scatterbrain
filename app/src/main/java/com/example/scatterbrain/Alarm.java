package com.example.scatterbrain;
/**
 * Created by User on 3/14/2017.
 */

public class Alarm {
    private String my_id;
    private String barcode;
    private String description;
    private String qty;

    public Alarm(String my_id, String barcode,  String description, String qty) {
        this.my_id = my_id;
        this.barcode = barcode;
        this.description = description;
        this.qty = qty;
    }

    public String getMy_id() {
        return my_id;
    }

    public void setMy_id(String my_id) {
        this.my_id = my_id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }
}
