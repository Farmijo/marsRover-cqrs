# MY SOLUTION

First iteration:

1. Veo que no hay tests y compruebo que hay ciertas reglas que no se cumplen.

    - No hay validación de inputs
    - No hay control sobre la posición inicial de rover
    - No hay control sobre los tamaños o las coordenadas iniciales
    - La logica de "planeta esferico" no esta implementada.
    
2. Saco la clase MarsRover fuera usando el código de main que no es referente a inputs e intento testearla. 
  
3. Es imposible dado como esta hecha, así que implemento las clases Coordinate y Field y el enum Orientation. 
    - Coordinate servirá para encapsular la logica de movimiento. 
    - Field servirá para definir las dimensiones del mapa donde se mueve el rover 
      (no lo tengo del todo claro para la hora de cuando tenga que implementar las fronteras pero de momento lo voy a dejar así)
4. La logica queda un poco más clara (todo y que hay cosas que chirrian, como el executeCommand). Al menos puedo testear minimamente la clase.
5. Añado tests y, una vez comprobados, escribo los tests para las comprobaciones de frontera. Una vez hechos, empiezo a implementar esa lógica.
6. El executeCommand me chirría demasiado, así que voy a separarlo en metodos de move y rotation. Separo dominio (marsRover) de infraestructura (la linea de comandos)
7. Test hechos e implementación de lógica hecha. Ahora que tengo movimiento y tests hechos, voy a ver si hay alguna forma de hacer más elegante el control de mars rover (sin tanto switch, por ejemplo).
