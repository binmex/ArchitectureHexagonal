package com.study.reservation.factura.comando.manejador;

import com.study.reservation.ComandoRespuesta;
import com.study.reservation.cliente.entidad.Cliente;
import com.study.reservation.cliente.servicio.ServicioCliente;
import com.study.reservation.factura.comando.ComandoCrearCliente;
import com.study.reservation.factura.comando.fabrica.FabricaCrearCliente;
import com.study.reservation.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearCliente implements ManejadorComandoRespuesta<ComandoCrearCliente, ComandoRespuesta<Long>> {
    private final FabricaCrearCliente fabricaCrearCliente;
    private final ServicioCliente servicioCliente;

    public ManejadorCrearCliente(FabricaCrearCliente fabricaCrearCliente, ServicioCliente servicioCliente) {
        this.fabricaCrearCliente = fabricaCrearCliente;
        this.servicioCliente = servicioCliente;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoCrearCliente comandoCrearCliente) {
        Cliente cliente = fabricaCrearCliente.crear(comandoCrearCliente);
        Long idCliente = servicioCliente.crearCliente(cliente);
        return new ComandoRespuesta<>(idCliente);
    }
}
