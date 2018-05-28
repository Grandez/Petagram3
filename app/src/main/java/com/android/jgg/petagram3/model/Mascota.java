package com.android.jgg.petagram3.model;

public class Mascota implements Comparable {
    private Integer idMascota;
    private Integer idFoto;
    private Integer likes;
    private String  nombre;

    public Integer getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Integer idMascota) {
        this.idMascota = idMascota;
    }

    public Integer getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(Integer idFoto) {
        this.idFoto = idFoto;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int compareTo(Object other) {
        int res= ((Mascota) other).getLikes();
        return res - this.getLikes();  // Descending order
    }

}

