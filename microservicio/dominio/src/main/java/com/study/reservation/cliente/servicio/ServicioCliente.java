package com.study.reservation.cliente.servicio;

import com.study.reservation.cliente.entidad.Cliente;
import com.study.reservation.cliente.entidad.ClienteActualizarDTO;
import com.study.reservation.cliente.puerto.RepositorioCliente;

import java.util.List;

public class ServicioCliente {
    private final RepositorioCliente repositorioCliente;

    public ServicioCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public Long crearCliente(Cliente cliente){
        return repositorioCliente.guardarCliente(cliente);
    }

    public List<Cliente> listarClientes(){
        return repositorioCliente.ObtenerClientes();
    }

    public void actualizarCliente(Long id, ClienteActualizarDTO cliente){
        repositorioCliente.actualizarCliente(id,cliente);
    }

    public void eliminarCliente(Long id){
        repositorioCliente.eliminarCliente(id);
    }
}
