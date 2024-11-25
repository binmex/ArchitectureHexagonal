package com.study.reservation.infraestructura.jdbc;

public interface EjecutarBD<T> {
    T ejecutar();
}