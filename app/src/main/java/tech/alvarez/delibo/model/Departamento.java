package tech.alvarez.delibo.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Departamento {

    private String nombre;
    @SerializedName("nro_provincias")
    private int nroProvincias;
    private List<Plato> platos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNroProvincias() {
        return nroProvincias;
    }

    public void setNroProvincias(int nroProvincias) {
        this.nroProvincias = nroProvincias;
    }

    public List<Plato> getPlatos() {
        return platos;
    }

    public void setPlatos(List<Plato> platos) {
        this.platos = platos;
    }
}
