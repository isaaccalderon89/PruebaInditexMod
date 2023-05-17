
# Proyecto Inditex

***

Para este proyecto se ha configurado una base de datos de *tipo h2*  con los siguientes datos. 

![[Pasted image 20230517155205.png]]

He creado varios casos de uso antes para comprobar que la aplición funcionaba correctamente junto con la base de datos. Siendo los siguientes casos de uso que hay para probar: 
* FindAllPrice : devuelve una lista con todos los datos. 
* FindPryceById: devuelve una entidad que coincida con el *id* que le hemos pasado. 
* FindMatchingPrice: devuelve los datos que se pedían en el ejercicio. 

A la hora de imprimir en el Postman los datos que nos pedían he usado la etiqueta **@JsonIgnore** en aquellas colunmas que no queríamostrar. 

***

## Para utilizar la BBDD 

1. Hay que arrancar el proyecto. 
2. http://localhost:8080/h2-console/ hay que acceder a este enlace e introducir usuario *root* y contraseña *root*. 
3. Ejecutar en postman. 