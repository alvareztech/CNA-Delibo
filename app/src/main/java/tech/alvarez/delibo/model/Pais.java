package tech.alvarez.delibo.model;

import java.util.List;

public class Pais {

    private List<Departamento> departamentos;

    public Pais(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }
}
