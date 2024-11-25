package com.study.reservation.reservacion.entidad;

import com.study.reservation.dominio.ValidadorArgumento;

import java.util.Date;

public class Reservacion {
    private Long id;
    private Date fecha_ingreso;
    private Date fecha_salida;
    private EstadoReservacion estadoReservacion;

    public Reservacion(Long id, Date fecha_ingreso, Date fecha_salida, EstadoReservacion estadoReservacion) {
        this.id = id;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_salida = fecha_salida;
        this.estadoReservacion = estadoReservacion;
    }

    public static Reservacion reconstruir(Long id, Date fecha_ingreso, Date fecha_salida, EstadoReservacion estadoReservacion) {
        ValidadorArgumento.validarObligatorio(id, "El id de la reservacion es obligatoria");
        ValidadorArgumento.validarObligatorio(fecha_ingreso, "La fecha de ingreso es obligatoria");
        ValidadorArgumento.validarObligatorio(fecha_salida, "la fecha de salida es obligatoria");
        return new Reservacion(id, fecha_ingreso, fecha_salida, estadoReservacion);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public EstadoReservacion getEstadoReservacion() {
        return estadoReservacion;
    }

    public void setEstadoReservacion(EstadoReservacion estadoReservacion) {
        this.estadoReservacion = estadoReservacion;
    }
}
