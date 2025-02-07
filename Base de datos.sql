
DELIMITER $$

CREATE PROCEDURE sp_BuscarLibrosPorCedula(IN a_cedula VARCHAR(20))
BEGIN
    SELECT l.idLibro, l.idAutor
    FROM Libros l
    JOIN Autores a ON l.idAutor = a.idAutor
    WHERE a.cedula = a_cedula;  -- Aquí no se debe usar 'a.' antes de 'a_cedula'
END $$

DELIMITER ;

CALL sp_BuscarLibrosPorCedula(2345678901);