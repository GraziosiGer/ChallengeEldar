package com.company;

/*
La clase Titular existe por la posibilidad de una expansion en el futuro, capaz que ademas del nombre
y del apellido, los clientes puedan tener por ejemplo un ID asociado como el DNI, y tambien por ejemplo
si tienen mas de una tarjeta poder ver todas las tarjetas a su nombre
 */
public class Titular {
    private String nombres;
    private String apellidos;

    public Titular(String nombres, String apellidos) {
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public String getNombreCompleto() {
        return this.nombres +" "+ this.apellidos;
    }
}
