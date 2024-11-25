package com.study.reservation.cliente.entidad;

import com.study.reservation.dominio.ValidadorArgumento;

public class Cliente {
    private Long id;
    private final String nombre;
    private final String apellido;
    private String correo;
    private String telefono;
    private String direccion;

    public Cliente(Long id, String nombre, String apellido, String correo, String telefono, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public static Cliente reconstruir(Long id, String nombre, String apellido, String correo, String telefono, String direccion){
        ValidadorArgumento.validarObligatorio(id,"El Id del cliente es obligatorio");
        ValidadorArgumento.validarObligatorio(nombre,"El nombre del cliente es obligatorio");
        ValidadorArgumento.validarObligatorio(apellido,"El apellido del cliente es obligatorio");
        ValidadorArgumento.validarRegex(correo,"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$","Debe proporcionar un correo con un formato valido");
        ValidadorArgumento.validarLongitud(telefono,10,"El telefono debe tener 10 digitos");
        return new Cliente(id,nombre,apellido,correo,telefono,direccion);
    };

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
