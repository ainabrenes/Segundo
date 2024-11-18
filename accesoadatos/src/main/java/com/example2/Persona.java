package com.example2;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Persona {

    @Id
    private String nom; // Se usa el nombre como identificador único
    private int edat;
    private String email;

    // Constructor por defecto
    public Persona() {}

    // Constructor con parámetros
    public Persona(String nom, int edat, String email) {
        this.nom = nom;
        this.edat = edat;
        this.email = email;
    }

    // Getters y Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona [nom=" + nom + ", edat=" + edat + ", email=" + email + "]";
    }
}
