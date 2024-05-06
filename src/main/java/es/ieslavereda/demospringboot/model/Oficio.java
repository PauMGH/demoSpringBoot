package es.ieslavereda.demospringboot.model;

public class Oficio {
    private int id_oficio;
    private String nombre;

    public Oficio(int id_oficio, String nombre){
        this.id_oficio = id_oficio;
        this.nombre = nombre;
    }

    public int getId_oficio() {
        return id_oficio;
    }
    public void setId_oficio(int id_oficio) {
        this.id_oficio = id_oficio;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
