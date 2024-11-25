package com.study.reservation.cliente.adaptador.repositorio;

import com.study.reservation.cliente.entidad.Cliente;
import com.study.reservation.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoCliente implements RowMapper<Cliente>, MapperResult {

    @Override
    public Cliente mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        long id = resultSet.getLong("ID_cliente");
        String nombre = resultSet.getString("nombre");
        String apellido = resultSet.getString("apellido");
        String correo = resultSet.getString("correo_electronico");
        String telefono = resultSet.getString("telefono");
        String direccion = resultSet.getString("direccion");

        return Cliente.reconstruir(id, nombre, apellido, correo, telefono, direccion);
    }

}
