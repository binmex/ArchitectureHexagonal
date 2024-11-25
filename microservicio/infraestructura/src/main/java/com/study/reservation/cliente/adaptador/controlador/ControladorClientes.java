package com.study.reservation.cliente.adaptador.controlador;

import com.study.reservation.cliente.entidad.Cliente;
import com.study.reservation.factura.consulta.ManejadorConsultasCliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ControladorClientes {
    private final ManejadorConsultasCliente manejadorConsultasCliente;

    public ControladorClientes(ManejadorConsultasCliente manejadorConsultasCliente) {
        this.manejadorConsultasCliente = manejadorConsultasCliente;
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return manejadorConsultasCliente.obtenerClientes();
    }
}
