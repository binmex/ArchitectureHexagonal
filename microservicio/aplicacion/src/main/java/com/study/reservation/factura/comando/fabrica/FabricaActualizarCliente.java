package com.study.reservation.factura.comando.fabrica;

import com.study.reservation.cliente.entidad.ClienteActualizarDTO;
import com.study.reservation.factura.comando.ComandoActualizarCliente;
import org.springframework.stereotype.Component;

@Component
public class FabricaActualizarCliente {
    public ClienteActualizarDTO actualizar(ComandoActualizarCliente comando) {
        return new ClienteActualizarDTO(
                comando.nombre(),
                comando.apellido(),
                comando.correo(),
                comando.telefono(),
                comando.direccion()
        );
    }
}
