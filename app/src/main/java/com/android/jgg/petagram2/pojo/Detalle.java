package com.android.jgg.petagram2.pojo;

public class Detalle {
    private int    id;
    private String nombre;
    private int    img;
    private int    rating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getRatingAsString() {
        return Integer.toString(rating);
    }

    public void incRating() {
        rating++;
    }

}
