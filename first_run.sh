#!/user/bin/env bash
javac -d practica/build/ practica/src/main/java/CategoryManager.java
javac -d practica/build/ -cp practica/build/ practica/src/main/java/Main.java

java -cp practica/build/ practica01.Main
