package devel.exesoft.com.zapshop.models;

import android.graphics.Bitmap;

public class Brand {
    private long id;
    private String title;
    private Bitmap image;

    public void setId(long id){
        this.id = id;
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
