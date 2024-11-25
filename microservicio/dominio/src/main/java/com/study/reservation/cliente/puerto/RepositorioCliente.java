package com.study.reservation.cliente.puerto;

import com.study.reservation.cliente.entidad.Cliente;

import java.util.List;

public interface RepositorioCliente {
    Cliente obtener (Long id);
    List<Cliente> ObtenerClientes();
    Long guardarCliente(Cliente cliente);
}
