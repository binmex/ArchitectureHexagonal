package com.study.reservation.reservacion.puerto;

import com.study.reservation.reservacion.entidad.Reservacion;

public interface RepositorioReservacion {
    Reservacion obtener(Long id);
}
