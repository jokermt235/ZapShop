package devel.exesoft.com.zapshop.models;

import android.graphics.Bitmap;

public class Item {
    private long id;
    private String title;
    private String description;
    private long price;
    private long compare_price;
    private String unit;
    private long collection_id;
    private Bitmap image;
    private Bitmap country;

    public void setId(long id){
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return  title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getPrice() {
        return price;
    }

    public void setCompare_price(long compare_price) {
        this.compare_price = compare_price;
    }

    public long getCompare_price() {
        return compare_price;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit(){
        return this.unit;
    }

    public void setCollection_id(long collection_id) {
        this.collection_id = collection_id;
    }

    public long getCollection_id() {
        return collection_id;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public Bitmap getImage() {
        return image;
    }

    public Bitmap getCountry(){return  country;}

    public void setCountry(Bitmap country){this.country = country;}

}
