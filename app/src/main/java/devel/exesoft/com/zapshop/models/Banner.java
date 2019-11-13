package devel.exesoft.com.zapshop.models;

import android.graphics.Bitmap;

public class Banner {
    private long id;
    private String title;
    private String name;
    private long product_id;
    private Bitmap image;

    public void setId(long id){
        this.id = id;
    }

    public void setProduct_id(long product_id) {
        this.product_id= product_id;
    }

    public long getProduct_id(){
        return product_id;
    }

    public void  setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getId(){
        return this.id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public Bitmap getImage(){
        return  this.image;
    }
}
