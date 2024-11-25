-- Crear tabla de Cliente
CREATE TABLE Cliente (
    ID_cliente INT AUTO_INCREMENT PRIMARY KEY, -- Identificador único del cliente
    Nombre VARCHAR(100) NOT NULL,              -- Nombre del cliente
    Apellido VARCHAR(100) NOT NULL,            -- Apellido del cliente
    Correo_electronico VARCHAR(100) UNIQUE NOT NULL, -- Correo electrónico del cliente (único)
    Telefono VARCHAR(15),                     -- Número de teléfono del cliente
    Direccion TEXT                            -- Dirección del cliente
);

-- Crear tabla de Reservación
CREATE TABLE Reservacion (
    ID_reservacion INT AUTO_INCREMENT PRIMARY KEY, -- Identificador único de la reservación
    Fecha_reservacion DATE NOT NULL,               -- Fecha en la que se hizo la reservación
    Fecha_entrada DATE NOT NULL,                   -- Fecha de entrada (inicio de la reservación)
    Fecha_salida DATE NOT NULL,                    -- Fecha de salida (fin de la reservación)
    Estado VARCHAR(50) NOT NULL,                   -- Estado de la reservación (confirmada, pendiente, etc.)
    ID_cliente INT,                               -- Clave foránea para el cliente
    FOREIGN KEY (ID_cliente) REFERENCES Cliente(ID_cliente) -- Relación con la tabla Cliente
);
