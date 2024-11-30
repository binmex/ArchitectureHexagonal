package com.study.reservation.factura.comando.manejador;

import com.study.reservation.ComandoRespuesta;
import com.study.reservation.cliente.entidad.ClienteActualizarDTO;
import com.study.reservation.cliente.servicio.ServicioCliente;
import com.study.reservation.factura.comando.ComandoActualizarCliente;
import com.study.reservation.factura.comando.fabrica.FabricaActualizarCliente;
import com.study.reservation.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarCliente{
    private final ServicioCliente servicioCliente;
    private final FabricaActualizarCliente fabricaActualizarCliente;

    public ManejadorActualizarCliente(ServicioCliente servicioCliente, FabricaActualizarCliente fabricaActualizarCliente) {
        this.servicioCliente = servicioCliente;
        this.fabricaActualizarCliente = fabricaActualizarCliente;
    }

    public void manejadorActualizarCliente (Long id, ComandoActualizarCliente comando) {
        ClienteActualizarDTO clienteActualizarDTO = fabricaActualizarCliente.actualizar(comando);
        servicioCliente.actualizarCliente(id,clienteActualizarDTO);
    }
}
