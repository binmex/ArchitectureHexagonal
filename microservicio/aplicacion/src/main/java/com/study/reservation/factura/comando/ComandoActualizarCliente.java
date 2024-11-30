package com.study.reservation.factura.comando;

public record ComandoActualizarCliente(Long id, String nombre, String apellido, String correo, String telefono, String direccion) {
}
