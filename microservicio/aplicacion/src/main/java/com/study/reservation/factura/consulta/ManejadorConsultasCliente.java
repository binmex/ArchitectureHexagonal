package com.study.reservation.factura.consulta;

import com.study.reservation.cliente.entidad.Cliente;
import com.study.reservation.cliente.puerto.RepositorioCliente;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorConsultasCliente {

    private final RepositorioCliente repositorioCliente;

    public ManejadorConsultasCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public List<Cliente> obtenerClientes(){
        return repositorioCliente.ObtenerClientes();
    }
}
