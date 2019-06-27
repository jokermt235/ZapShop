package devel.exesoft.com.zapshop.models;

import android.graphics.Bitmap;

public class Collection {

    private long id;
    private String title;
    private Bitmap image;

    public void setId(long id){
        this.id = id;
    }

    public long getId(){
        return id;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public Bitmap getImage(){
        return  image;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public  String getTitle(){
        return  title;
    }
}
