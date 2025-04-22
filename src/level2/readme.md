## Level 2 - Ejercicio 1: El programa lista un árbol de directorios con el contenido
de todos sus niveles (recursivamente) y se guardan en un archivo .txt en orden alfabético
dentro de cada nivel, indicando además si es un directorio (D) o un archivo (F),
y su última fecha de modificación. La ruta del directorio del que creará la lista
del contenido y el archivo .txt donde la guardará están indicados en el archivo
config.properties, el programa las obtiene de esta carpeta.

## En la terminal situado en el directorio de trabajo del proyecto, en mi caso:

    "C:\Users\JosePC\Documents\IT_ACADEMY\EspecialitzacioJavaBackEnd\Sprint1\S105_Java Utils>"

## Para compilar los archivos ejecuto el comando:

    javac -d out src\level2\*.java

 Este comando creará, a partir de los archivos fuente .java, los archivos compilados .class
 listos para ejecutar en la ruta

 C:\Users\JosePC\Documents\IT_ACADEMY\EspecialitzacioJavaBackEnd\Sprint1\S105_Java Utils\out\level2


## Para Ejecutar MainProperties:

    java -cp out level2.MainProperties

Ejecutará los archivos .class compilados en la carpeta out\level2

## Resultado:
    Obtiene del archivo config.properties la ruta de la carpeta de la cual genera
    la lista y el archivo en el cual la guarda.
    Despues, guarda el siguiente texto en el archivo obtenido que es "directoryList.txt":

    FIL src\level2\config.properties 10-04-2025 02:25:06
    FIL src\level2\directoryList.txt 10-04-2025 02:25:47
    FIL src\level2\DirectoryUtils.java 10-04-2025 02:28:17
    FIL src\level2\fruitsLvl2.txt 25-03-2025 10:57:15
    DIR src\level2\joseFolder 29-03-2025 03:55:12
    FIL src\level2\MainProperties.java 10-04-2025 02:19:59
    FIL src\level2\MissingOutputFileException.java 10-04-2025 02:28:17
    FIL src\level2\readme.txt 10-04-2025 02:27:13
    DIR src\level2\sampleFolder 29-03-2025 03:47:18
