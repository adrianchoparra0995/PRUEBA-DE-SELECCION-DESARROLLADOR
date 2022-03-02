--
-- Base de datos: `test`
--

create database bartender;
use bartender;
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `arrays`
--

CREATE TABLE arrays (
  id INT PRIMARY KEY NOT NULL,
  input_array varchar(20) NOT NULL
) 

SELECT * FROM arrays WHERE id = 1

--
-- Volcado de datos para la tabla `arrays`
--

INSERT INTO arrays (id, input_array) VALUES
(1, '2,4,5,6,7,8'),
(2, '3,7,9,5,4,2'),
(3, '5,7,9,11,13'),
(4, '6,4,2,12,15'),
(5, '7,10,15,11,9');


INSERT INTO arrays (id, input_array) VALUES (6,'2,3,4,5,6,7')
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `arrays`
--
ALTER TABLE arrays ALTER COLUMN id int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
  
USE master
GO
xp_readerrorlog 0, 1, N'Server is listening on' 
GO