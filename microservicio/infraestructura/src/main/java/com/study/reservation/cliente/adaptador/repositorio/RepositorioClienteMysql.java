package com.study.reservation.cliente.adaptador.repositorio;

import com.study.reservation.cliente.entidad.Cliente;
import com.study.reservation.cliente.puerto.RepositorioCliente;
import com.study.reservation.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.study.reservation.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.study.reservation.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioClienteMysql implements RepositorioCliente {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "cliente", value = "obtenerporid")
    private static String sqlObtenerPorId;

    public RepositorioClienteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Cliente obtener(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() ->
                this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorId,
                        paramSource, new MapeoCliente()));
    }

    @Override
    public List<Cliente> ObtenerClientes() {
        String sql = "SELECT * FROM Cliente";
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sql, new MapeoCliente());
    }

    @Override
    public Long guardarCliente(Cliente cliente) {
        String sql = "INSERT INTO Cliente (nombre, apellido, correo_electronico, telefono, direccion) VALUES (:nombre, :apellido, :correo, :telefono, :direccion)";
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", cliente.getNombre());
        paramSource.addValue("apellido", cliente.getApellido());
        paramSource.addValue("correo", cliente.getCorreo());
        paramSource.addValue("telefono", cliente.getTelefono());
        paramSource.addValue("direccion", cliente.getDireccion());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sql, paramSource, keyHolder, new String[]{"id"});
        return keyHolder.getKey().longValue();
    }
}