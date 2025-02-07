


DELIMITER $$

CREATE PROCEDURE sp_BuscarLibrosCedula(IN a_cedula VARCHAR(20))
BEGIN
    SELECT l.idLibro, l.idAutor, l.nombreLibros, a.nombreAutores
    FROM Libros l
    JOIN Autores a ON l.idAutor = a.idAutor
    WHERE a.cedula = a_cedula;  -- Aquí la comparación está correcta, ya que a_cedula es una variable de entrada
END $$

DELIMITER ;

CALL sp_BuscarLibrosCedula('2345678901');


INSERT INTO autores (idAutor, nombreAutores, cedula) VALUES
(1, 'Carlos Ruiz Zafón', '2345678901'),
(2, 'Gabriel García Márquez', '2345678902'),
(3, 'Isabel Allende', '2345678903'),
(4, 'J.K. Rowling', '2345678904'),
(5, 'Mario Vargas Llosa', '2345678905');

INSERT INTO Libros (idLibro, idAutor, nombreLibros) VALUES
(1, 1, 'El Universo de Carlos'),
(2, 1, 'Cuentos Cortos'),
(3, 2, 'La Aventura de Ana'),
(4, 3, 'La Historia de Luis'),
(5, 4, 'El Secreto de Marta'),
(6, 5, 'Viaje a lo Desconocido'),
(7, 2, 'Reflexiones de una vida'),
(8, 3, 'El Misterio de Rodríguez');
