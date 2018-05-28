# Petagram3 - Practica Android con base de datos

La practica es igual a la anterior, pero se ha añadido la persistencia en SQLLite

## Modelo de datos
Existen dos tablas:
*Mascotas*: 
- idMascota: Identificador unico de la mascota
- idFoto: Foto por defecto de las fotos existentes en la tabla de fotos
- Nombre: Nombre de la mascota
- likes: Numero total de likes

*Fotos*: 
- idMascota: Identificador unico de la mascota
- idFoto: Identificador unico de la foto para esa mascota
- likes: Numero total de likes de esa foto

Una mascota puede tener de 1 a n fotos
<p align="center">

  <img src="https://github.com/Grandez/Petagram3/blob/master/DataModel.png"/>
  
</p>
<p align="center">

  <img src="https://github.com/Grandez/Petagram3/blob/master/screenshot.png"/>
  
</p>
