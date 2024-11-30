package com.study.reservation.cliente.adaptador.controlador;

import com.study.reservation.cliente.entidad.Cliente;
import com.study.reservation.factura.comando.ComandoActualizarCliente;
import com.study.reservation.factura.comando.ComandoCrearCliente;
import com.study.reservation.factura.comando.manejador.ManejadorActualizarCliente;
import com.study.reservation.factura.comando.manejador.ManejadorCrearCliente;
import com.study.reservation.factura.comando.manejador.ManejadorEliminarCliente;
import com.study.reservation.factura.consulta.ManejadorConsultasCliente;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ControladorClientes {
    private final ManejadorConsultasCliente manejadorConsultasCliente;
    private final ManejadorCrearCliente manejadorCrearCliente;
    private final ManejadorActualizarCliente manejadorActualizarCliente;
    private  final ManejadorEliminarCliente manejadorEliminarCliente;

    public ControladorClientes(ManejadorConsultasCliente manejadorConsultasCliente, ManejadorCrearCliente manejadorCrearCliente, ManejadorActualizarCliente manejadorActualizarCliente, ManejadorEliminarCliente manejadorEliminarCliente) {
        this.manejadorConsultasCliente = manejadorConsultasCliente;
        this.manejadorCrearCliente = manejadorCrearCliente;
        this.manejadorActualizarCliente = manejadorActualizarCliente;
        this.manejadorEliminarCliente = manejadorEliminarCliente;
    }

    @GetMapping("/list")
    public List<Cliente> listarClientes() {
        return manejadorConsultasCliente.obtenerClientes();
    }

    @PostMapping("/save")
    public Long guardarCliente(@RequestBody ComandoCrearCliente comandoCrearCliente) {
        // Lógica para guardar un cliente
        return manejadorCrearCliente.ejecutar(comandoCrearCliente).getValor();
    }

    @PutMapping("/update{id}")
    public void actualizarCliente(@PathVariable Long id,@RequestBody ComandoActualizarCliente comandoActualizarCliente) {
        // Lógica para actualizar un cliente
        manejadorActualizarCliente.manejadorActualizarCliente(id, comandoActualizarCliente);
    }

    @DeleteMapping("/delete{id}")
    public void eliminarCliente(@PathVariable Long id) {
        // Lógica para eliminar un cliente
        manejadorEliminarCliente.ejecutar(id);
    }
}
