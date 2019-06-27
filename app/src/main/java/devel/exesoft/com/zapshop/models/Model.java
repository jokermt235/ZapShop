package devel.exesoft.com.zapshop.models;

public class Model {
    private long id;
    private String title;
    private long brand_id;
    private String production_start;
    private String getProduction_end;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setBrand_id(long brand_id) {
        this.brand_id = brand_id;
    }

    public long getBrand_id() {
        return brand_id;
    }

    public void setProduction_start(String production_start) {
        this.production_start = production_start;
    }

    public String getProduction_start() {
        return production_start;
    }

    public void setGetProduction_end(String getProduction_end) {
        this.getProduction_end = getProduction_end;
    }

    public String getGetProduction_end() {
        return getProduction_end;
    }

}
