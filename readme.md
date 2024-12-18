Este bloque contiene la estructura necesaria para construir un proyecto en java favoreciendo el enfoque de DDD. 

Los principales patrones y estilos de arquitectura que gu&iacute;an este bloque son

#### Arquitectura hexagonal
Arquitectura que fomenta  que nuestro dominio sea el n&uacute;cleo de todas las capas, tambi&eacute;n conocida como puertos y adaptadores en la cual el dominio define los puertos y en las capas superiores se definen los adaptadores para desacoplar el dominio. Se divide princialmente en tres capas, **aplicaci&oacute;n**, **dominio** e **infraestructura**
- **Infraestructura**: Capa que tiene las responsabilidades de realizar los adaptadores a los puertos definidos en el domino, exponer web services, consumir web services, realizar conexiones a bases de datos, ejecutar sentencias DML, en general todo lo que sea implementaciones de cualquier framework
- **Aplicaci&oacute;n**: capa encargada de enrutar los eventos entrantes de la capa de infraestructura hac&iacute;a la capa del dominio, generalmente se conoce como una barrera transaccional la cual agrupa toda la invocaci&oacute;n de un caso de uso, se pueden encontrar patrones como Fabricas, Manejadores de Comandos, Bus de eventos, etc 
- **Dominio**: representa toda la l&oacute;gica de negocio de la aplicaci&oacute;n la cual es la raz&oacute;n de existir del negocio. Se busca evitar el anti-patron [https://martinfowler.com/bliki/AnemicDomainModel.html](https://martinfowler.com/bliki/AnemicDomainModel.html)  y favorecer el principio [https://martinfowler.com/bliki/TellDontAsk.html](https://martinfowler.com/bliki/TellDontAsk.html) en esta capa se pueden encontrar los siguientes patrones agregados, servicios de dominio, entidades, objetos de valor, repositorios (puerto), etc. 

Para obtener mas documentaci&oacute;n sobre este tipo de arquitectura se recomienda [https://codely.tv/blog/screencasts/arquitectura-hexagonal-ddd/](https://codely.tv/blog/screencasts/arquitectura-hexagonal-ddd/)

#### Patr&oacute;n CQRS:  
Patr&oacute;n con el cual dividimos nuestro modelo de objetos en dos, un modelo para consulta y un modelo para comando (modificaci&oacute;n de datos). Este patr&oacute;n es recomendado cuando se va desarrollar l&oacute;gica de negocio compleja porque nos ayuda a separar las responsabilidades y a mantener un modelo de negocio consistente. 

 - **Consulta**: modelo a trav&eacute;s del cual se divide la responsabilidad para presentar datos en la interfaz de usuario, los objetos se modelan basado en lo que se va a presentar y no en la l&oacute;gica de negocio, ejm: ver facturas, consultar clientes
 - **Comando**: son todas las operaciones que cambian el estado del sistema, ejm: (facturar, aplicar descuento), este modelo se construye todo el modelo de objetos basado en la l&oacute;gica de negocio de la aplicaci&oacute;n  

Para mayor documentaci&oacute;n del patr&oacute;n [https://martinfowler.com/bliki/CQRS.html](https://martinfowler.com/bliki/CQRS.html)

#### Especificaciones t&eacute;cnicas: 

 - Spring boot 2.1.2
 - Flayway -> administrar todos los script DDL e iniciliazadores de la bd 
 - Integraci&oacute;n con Jenkins: Jenkins File
 - Integraci&oacute;n con Sonar: Sonar properties
 - Acceso a la base de datos por medio de JDBC template
 - Se entregan pruebas de muestra automatizadas para cada una de las capas 
 - Pruebas de carga de ejemplo en el directorio microservicio/external-resources
 - Ejemplo de como modelar un Comando y un Query
 - Ejemplo de pruebas de integraci&oacute;n con H2
 - Java 8
 - Se debe tener configurado el IDE con Lombok, descargar desde (https://projectlombok.org/download)
 

#### Calidad en las pruebas:
El bloque cuenta con la libreria https://pitest.org/ la cual nos ayuda a validar la calidad de las pruebas que estamos desarrollando.
Esta libreria funciona bajo el principio de mutation testing y se recomienda ejecutar la tarea **pitest** de los proyectos dominio e infraestructura y luego revisar 
el informe generado en la carpeta build. Siempre se debe buscar tener los mutantes en cero.  

#### Tener en cuenta para usar bloque para producción: 
Al momento de descargar este bloque y se vaya usar de manera productiva se debe ejecutar la tarea de gradle **dependencyCheckAnalyze** la cual revisa las vulnerabilidades para las versiones de las librerias que usa el bloque. El reporte que genera esta tarea se encuentra en la carpeta build del proyecto raiz. Se deben resolver los reportes críticos

#### Tener en cuenta cada que se incluya una nueva libreria: 
Despues de incluir una libreria en gradle se debe ejecutar la tarea de gradle **dependencyCheckAnalyze** para revisar las vulnerabilidades reportadas. 

#### Estructura del proyecto: 
Se identifican dos carpetas principales, com&uacute;n y microservicio. Microservicio es la carpeta que contiene todo el c&oacute;digo fuente para el primer microservicio de su proyecto, se recomienda cambiar el nombre de esta carpeta por la de su l&oacute;gica de negocio y posteriormente modificar el archivo *settings.gradle*,  si necesita crear mas microservicios lo &uacute;nico que debe realizar es duplicar esta carpeta y realizar la modificaci&oacute;n en el archivo *settings.gradle*. El proyecto com&uacute;n contiene c&oacute;digo fuente que comparten todos los microservicios y capas, es una librer&iacute;a que importan los que requieran este c&oacute;digo compartido, es importante tener en cuenta que no debe ir c&oacute;digo de negocio en este lugar. 
Como cada microservicio se va realizar con CQRS, cada uno contiene su propia estructura de arquitectura hexagonal en la cual no se comparten los modelos.

#### Importar el proyecto:
Para importar el proyecto se recomienda usar Gradle en la versi&oacute;n 5.0, se debe importar desde la ruta *microservicio/build.gradle*
Despu&eacute;s de importar el proyecto se queda viendo de la siguiente manera 

![enter image description here](https://drive.google.com/uc?id=1x2ZVpM2steX0Er-jDNoffQ_V6pRVdW0k)

#### Bloque HealthCheck
Es un bloque que tiene como fin saber el estado de otros bloques o servicios agregados como por ejemplo de mysql,sqlServer etc.Para esto es necesario crear un paquete com.ceiba.core.actuator en microservicio-consulta-infraestructura    e implementar una interfaz llamada  HealthCheck  con la anotacion @Component sobreescribiendo los siguientes metodos:

- **registrarBloque()**: Que tiene la funcion de registrar el bloque que quiere tenerse encuenta ,para esto es necesario que ala hora de construir la clase que implemente  la interface HealthCheck se inyecte la clase manejadorHealthCheckBloques que tiene en memoria los bloques 
implementados pasandole la cadena del nombre y la clase en si.

- **healthCheck()**: Es un metodo que se le delega al programador para que segun el servicio o el bloque usado implemente una funcionalidad que logre detectar que este ya no esta arriba.No devuleve un valor si no excepcion de tipo ExepcionBloqueSinServicio.

Al momento de crear el bloque principal pedira un tiempo que estara dado en  milisegundos llamado tiempoHealthCheck que estara guardado en archivo application.yaml de resources del microservicio.


nota* Es recomendable  tener muy encuenta el tiempo asignado a HealthCheck como tal en las base de datos el tiempo que tarda en verificar es 30000 milisegundos que en segundos son 30 entoces debe ser mayor a este , para que cuando  healthCheck  realice la revision ,ya todos los bloques hallan devuelto su valor para no tener  inconsistencias de
los valores devuelto .Se esperaria aumentar el tiempo cada vez que un bloque se implemente dependiendo tambien de su tiempo de retardo.



*Cualquier duda o aporte con este bloque contactar a juan.botero@ceiba.com.co o juan.castano@ceiba.com.co*#   A r c h i t e c t u r e H e x a g o n a l  
 #   A r c h i t e c t u r e H e x a g o n a l  
 