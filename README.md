
# UADE
# Análisis y Diseño Orientado a Objetos
## Segundo Cuatrimestre 2021 - Grupo 4
### Integrantes:
* Chan Ivan
* Gelsi Federico
* Huaman Cecilia
* Maidana Emmanuel
* Santos Nicolas

# Condiciones Generales
* El trabajo práctico debe realizarse de a, como máximo, 5 personas.
* Se debe entregar un único documento PDF con todas las consignas solicitadas (por cada entrega).
* Fechas de entregas:
  * Primera entrega: **07 de septiembre**
  * Segunda entrega: **09 de noviembre**
  * Entrega final: **16 de noviembre**
* En los días de entrega se debe exponer la solución propuesta.

# Contexto General

Una importante organización de RRHH nos ha solicitado el diseño y
desarrollo de un sistema de Bolsa de Trabajo.

Toda empresa que quiera realizar una búsqueda laboral deberá generar una
Publicación de Oferta Laboral, completando, mínimamente, los siguientes
datos:

* Título de la búsqueda: puede estar vacío. Si está vacío, el sistema deberá generar un título de forma
automática tomando en cuenta la Categoría, el Tipo de trabajo y Lugar de trabajo.
* Descripción del puesto: detalle de qué tareas involucra el puesto, de forma narrada y mediante tareas
seleccionables a través de un desplegable.
* Modalidad de contrato: puede ser part-time o full-time.
* Tipo de trabajo: puede ser “remoto” o “presencial”.
* Lugar de trabajo: solamente se deberá completar si el tipo de trabajo es presencial y no se deberá
especificar la dirección exacta, sino una referencia.
* Categoría: categoría a la cual pertenece la búsqueda laboral (“Sistemas”, “Industria Petrolera”,
“RRHH”, “Contable”, entre otras, pueden ser algunos ejemplos).
* Requisitos: serie requisitos que deben cumplir, sin excepción, los postulantes.
* Sueldo ofrecido: monto que se pagará, con determinada frecuencia, al empleado.

Cada publicación deberá tener un periodo de vigencia durante el cual estará abierta para la recepción de
postulantes. Fuera de este periodo, deberá figurar por N semanas como “Búsqueda cerrada”. Cabe destacar
que, si el puesto ofrecido por una publicación no fue cubierto, la empresa interesada podrá volverla a reabrir.

Las personas que estén interesadas en postularse en búsquedas laborales deberán registrarse en la
plataforma, dejando detalle de:

* Nombre y apellido completo
* Fecha de nacimiento
* Nacionalidades 
* Idiomas 
* Intereses: deberá seleccionar, por orden de prioridad, las Categorías de las publicaciones que le
  interese

Los postulantes podrán postularse en las búsquedas laborales activas, siempre y cuando sus perfiles cumplan
con los requisitos solicitados. En caso de no cumplir con los requisitos, el sistema deberá mostrarle un “cartel”
informativo avisándole de esta situación.

Cuando un postulante se postula a un puesto deberá cargar su CV actualizado (en PDF) y la remuneración
pretendida. Además, cuando esto ocurra, el sistema deberá enviarle una notificación sobre esta situación a la
empresa, a través del medio de notificación seleccionado para esa publicación.

La empresa podrá ver, en todo momento, todos los postulantes para una determinada publicación, con el
detalle, por cada postulante, de la fecha en la cual se postuló, la remuneración pretendida y el CV.
Por otro lado, los postulantes deberán poder guardar publicaciones en “favoritos”. Semanalmente, el sistema
deberá enviar a los futuros postulantes recomendaciones que se ajusten a las categorías de las publicaciones
que hayan guardado en favoritos.

Por último, el sistema deberá generar una imagen de una publicación de oferta laboral, en distintos formatos
(jpg, png, svg, entre otras), que contenga, en todos los casos, un encabezado, un cuerpo y un pie. Esta imagen
será utilizada para generar publicidad en redes sociales.

## Alcance y Requerimientos

El sistema deberá permitir que:
* Las empresas gestionen las publicaciones de ofertas laborales.
* Las personas interesadas se postulen en una publicación, siempre y cuando cumplan los requisitos, y
puedan ver aquellas publicaciones que ya están cerradas.
* El administrador de la plataforma descargue las imágenes generadas a partir de las publicaciones de
ofertas laborales.
* El administrador de la plataforma configure las tareas que podrán ser seleccionadas para las
descripciones de los puestos, así como también los idiomas y nacionalidades que podrán ser elegidos.

Además, es necesario que el sistema informe:
* La oferta laboral que más postulantes recibió en un mes y/o año determinado.
* Las primeras M categorías más seleccionadas en las ofertas laborales.
* Cuál es el trabajo “más accesible”, considerando que “el más accesible” es aquel trabajo part-time, 
remoto, con menor cantidad de tareas asignadas y menor cantidad de requisitos. 
* Cuál es la oferta “más exigente”, considerando que es “la más exigente” aquella oferta que tiene 
mayor cantidad de requisitos.

# Consignas

## Primera entrega
- [x] Enumerar y detallar los requerimientos que se desprenden del dominio. Clasificarlos según
FURPS+.
- [x] Realizar el diagrama de casos de uso general del sistema.
- [x] Realizar la especificación de los casos de uso principales del sistema.
- [x] Realizar el diagrama de actividad general “Crear oferta laboral”, desde la perspectiva de una
empresa.
- [x] Realizar los diagramas de secuencia que muestren cómo se resuelven los informes que debe
emitir el sistema.
- [x] Realizar una iteración inicial del diagrama de clases del sistema, detallando, solamente, las
clases de la capa de dominio.

## Segunda entrega
- [x] Realizar el diagrama de clases del sistema, detallando, solamente, las clases de la capa de
dominio.
- [ ] Justificar utilización de patrones de diseño en el caso que se hayan utilizado.
- [ ] Implementar el diagrama de clases propuesto en Java, mostrando el correcto funcionamiento
de los requerimientos principales a través de Tests Unitarios.

## Patrón Adapter
Decidimos utilizar el patrón adapter para la implementación de las estrategias de visualización de los informes.

Esto es debido a que los métodos para las interfaces para la visualización web y la visualización con PDF no son
compatibles con nuestra clase base de informes. Al permitirnos crear una capa media entre los informes y 
los métodos de visualización, este patrón nos permite interconectar dos elementos que de otra forma tendrían 
interfaces incompatibles.