package devel.exesoft.com.zapshop.models;

import io.realm.RealmObject;

public class Cart extends RealmObject {
    private long id;
    private long item_id;
    private String item_title;
    private long item_price;
    private long item_count;
    private String item_unit;
    private String device_id;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setItem_id(long item_id) {
        this.item_id = item_id;
    }

    public long getItem_id() {
        return item_id;
    }

    public void setItem_title(String item_title) {
        this.item_title = item_title;
    }

    public String getItem_title(){
        return item_title;
    }

    public void setItem_price(long item_price) {
        this.item_price = item_price;
    }

    public long getItem_price() {
        return item_price;
    }

    public void setItem_count(long item_count) {
        this.item_count = item_count;
    }

    public long getItem_count() {
        return item_count;
    }

    public void setItem_unit(String item_unit) {
        this.item_unit = item_unit;
    }

    public String getItem_unit() {
        return item_unit;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getDevice_id() {
        return device_id;
    }
}
