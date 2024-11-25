package com.study.reservation.factura.comando;

public record ComandoCrearCliente(Long id, String nombre, String apellido, String correo, String telefono, String direccion) {
}
