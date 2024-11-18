package com.example2;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Empresa {

    @Id
    private String nom;  // Usamos el nombre como identificador único
    private String cif;
    private String direccio;

    // Constructor por defecto
    public Empresa() {}

    // Constructor con parámetros
    public Empresa(String nom, String cif, String direccio) {
        this.nom = nom;
        this.cif = cif;
        this.direccio = direccio;
    }

    // Getters y Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getDireccio() {
        return direccio;
    }

    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }

    @Override
    public String toString() {
        return "Empresa [nom=" + nom + ", cif=" + cif + ", direccio=" + direccio + "]";
    }
}
