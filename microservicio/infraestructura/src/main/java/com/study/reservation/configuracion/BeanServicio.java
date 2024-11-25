package com.study.reservation.configuracion;

import com.study.reservation.cliente.adaptador.repositorio.RepositorioClienteMysql;
import com.study.reservation.cliente.servicio.ServicioCliente;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCliente servicioCliente(RepositorioClienteMysql repositorioClienteMysql) {
        return new ServicioCliente(repositorioClienteMysql);
    }
}
