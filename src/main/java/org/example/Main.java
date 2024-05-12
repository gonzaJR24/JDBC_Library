package org.example;


import org.example.DBEntity.*;
import org.example.UnitTest.UnitTestAutor;

import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        DBEntity dbEntity = new DBEntity();
        dbEntity.conectar();

        //Instancia Unit Test Autor
        UnitTestAutor unitTestAutor=new UnitTestAutor();
        unitTestAutor.start();






    }




}