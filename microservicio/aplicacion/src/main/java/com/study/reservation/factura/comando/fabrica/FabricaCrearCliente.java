package com.study.reservation.factura.comando.fabrica;

import com.study.reservation.cliente.entidad.Cliente;
import com.study.reservation.factura.comando.ComandoCrearCliente;
import org.springframework.stereotype.Component;

@Component
public class FabricaCrearCliente {

    public Cliente crear(ComandoCrearCliente comando) {
        return new Cliente(
                comando.id(),
                comando.nombre(),
                comando.apellido(),
                comando.correo(),
                comando.telefono(),
                comando.direccion()
        );
    }
}
