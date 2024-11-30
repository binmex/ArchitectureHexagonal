package com.study.reservation.cliente.entidad;

public record ClienteActualizarDTO (
        String nombre,
        String apellido,
        String correo,
        String telefono,
        String direccion
){
}
