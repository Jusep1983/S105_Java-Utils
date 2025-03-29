# S105_Java-Utils
## 📄 Descripción 
Este repositorio contiene los 3 niveles de la Tasca S1.05. Java_Utils,
los cuales exploran diversas funcionalidades de la clase java.util, 
además de la compilación y ejecución de archivos fuente desde la terminal.

🔽 Enunciados:
   <details>
    <summary>
      Nivel 1
    </summary>
 
    - Ejercicio 1 
    Crea una clase que liste alfabéticamente el contenido de un directorio recibido por parámetro.
    
    - Ejercicio 2    
    Añade a la clase del ejercicio anterior la funcionalidad de listar un árbol de directorios con el contenido de 
    todos sus niveles (recursivamente), de manera que se impriman en pantalla en orden alfabético dentro de cada nivel, 
    indicando además si es un directorio (D) o un archivo (F), y su última fecha de modificación.
 
    - Ejercicio 3    
    Modifica el ejercicio anterior. Ahora, en lugar de mostrar el resultado por pantalla, guarda el resultado en un archivo TXT.

    
    - Ejercicio 4    
    Añade la funcionalidad de leer cualquier archivo TXT y mostrar su contenido por consola.
    
    - Ejercicio 5  
    Ahora el programa debe serializar un objeto Java a un archivo .ser y luego deserializarlo.

      
   </details>
   <details>
   <summary>
   Nivel 2
   </summary>
  
    - Ejercicio 1
    Ejecuta el ejercicio 3 del nivel anterior parametrizando todos los métodos en un archivo de configuración.  
    Puedes utilizar un archivo Java Properties o bien la librería Apache Commons Configuration si lo prefieres.
    Del ejercicio anterior, parametriza lo siguiente:
    Directorio a leer.
    Nombre y directorio del archivo TXT resultante.

   </details>
   <details>
   <summary>
     Nivel 3
   </summary>
  
    - Ejercicio 1
    Crea una utilidad que encripte y desencripte los archivos resultantes de los niveles anteriores.
    Utiliza el algoritmo AES en modo de operación ECB o CBC con el método de relleno PKCS5Padding.  
    Se puede usar javax.crypto o bien org.apache.commons.crypto.


   </details>
</details>

## 💻 Tecnologías Utilizadas 
El proyecto ha sido desarrollado utilizando: 
  - Java 21 
  - IntelliJ IDEA como entorno de desarrollo
  - Git y GitHub para control de versiones.

## 📋 Requisitos 
Para ejecutar el proyecto es necesario contar con: 
  - JDK 21 instalado en el sistema
  - Git instalado y configurado
  - IntelliJ IDEA
  - Conexión a internet para clonar el repositorio.

## 🛠️ Instalación 
1. Clonar el repositorio

  - Opción 1: Desde GitHub (sin terminal):

    1. Ir al repositorio en GitHub:
       
        https://github.com/Jusep1983/S105_Java-Utils.git
    2. Hacer clic en el botón verde "Code" (Código).
    3. Seleccionar la opción "Download ZIP".
    4. Extraer el archivo ZIP en la ubicación de preferencia.

  - Opción 2: Desde IntelliJ IDEA:
    1. Abrir IntelliJ IDEA.
    2. En la pantalla de inicio, seleccionar "Get from VCS" (Obtener desde el control de versiones).
    3. En la pestaña "Version Control", seleccionar Git.
    4. En el campo "URL", pegar el enlace del repositorio: 
          https://github.com/Jusep1983/S105_Java-Utils.git
    6. Elegir la carpeta donde se guardará el proyecto y hacer clic en "Clone".
    7. IntelliJ IDEA detectará el proyecto y pedirá importarlo como un proyecto de Java.

  - Opción 3: Desde la terminal (con Git instalado):
    1. Abre la terminal o línea de comandos.
    2. Dirígete a la carpeta donde deseas clonar el repositorio:

            cd /ruta/donde/quieres/clonar
    3. Ejecuta el siguiente comando para clonar el repositorio:

            git clone https://github.com/Jusep1983/S105_Java-Utils.git
    4. Después de que se complete el proceso de clonación, ve a la carpeta del proyecto:

            cd S105_Java-Utils

2. Configurar el entorno:
    1. Abrir IntelliJ IDEA si no está abierto.
    2. Ir a File → Project Structure → Project.
    3. Asegurarse de que está seleccionado JDK 21.

## ▶️ Ejecución 
1. Abrir la clase que contiene el método main(). 
2. Hacer clic en el botón Run o presionar Shift + F10. 
3. Si es necesario, IntelliJ IDEA pedirá sincronizar dependencias, acepta la opción.

## 🌐 Despliegue 
El proyecto está diseñado para ejecutarse en un entorno local, por lo que no se ha definido un proceso de despliegue en producción.

## 🤝 Contribuciones 
Si deseas contribuir al proyecto, puedes: 
- Hacer un fork del repositorio. 
- Crear una nueva rama para tus cambios. 
- Enviar un pull request con una descripción detallada de tus modificaciones.


¡Gracias por tu interés en este proyecto! 🚀
