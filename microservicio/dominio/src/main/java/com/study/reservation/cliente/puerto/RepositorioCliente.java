package com.study.reservation.cliente.puerto;

import com.study.reservation.cliente.entidad.Cliente;
import com.study.reservation.cliente.entidad.ClienteActualizarDTO;

import java.util.List;

public interface RepositorioCliente {
    Cliente obtener (Long id);
    List<Cliente> ObtenerClientes();
    Long guardarCliente(Cliente cliente);
    void actualizarCliente(Long id,ClienteActualizarDTO cliente);
    void eliminarCliente(Long id);
}
