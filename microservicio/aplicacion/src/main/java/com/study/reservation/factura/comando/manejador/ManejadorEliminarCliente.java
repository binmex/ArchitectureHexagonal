package com.study.reservation.factura.comando.manejador;

import com.study.reservation.ComandoRespuesta;
import com.study.reservation.cliente.servicio.ServicioCliente;
import com.study.reservation.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarCliente implements ManejadorComandoRespuesta<Long, ComandoRespuesta<Boolean>> {
    private final ServicioCliente servicioCliente;

    public ManejadorEliminarCliente(ServicioCliente servicioCliente) {
        this.servicioCliente = servicioCliente;
    }

    @Override
    public ComandoRespuesta<Boolean> ejecutar(Long id_cliente) {
        servicioCliente.eliminarCliente(id_cliente);
        return null;
    }
}
