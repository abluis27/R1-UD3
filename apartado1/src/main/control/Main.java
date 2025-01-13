package main.control;

import main.model.Autor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
   private static Scanner entrada = new Scanner(System.in);
   private static GestorBBDD gestorBBDD = new GestorBBDD();

    public static void main(String[] args) {
        Autor autorBuscado = gestorBBDD.buscarAutorPorNombreCompleto("Isable", "Allende");
        System.out.println(autorBuscado);
    }

    public static void listarAutores(List<Autor> autores) {
        System.out.println("----- AUTORES REGISTRADOS -----");
        for (Autor autor : autores) {
            System.out.println(autor);
            System.out.println("----------");
        }
    }

    public static Autor crearAutor() {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Inserte el nombre del autor: ");
        String nombre = entrada.nextLine();
        System.out.print("Inserte el apellido del autor: ");
        String apellido = entrada.nextLine();
        System.out.print("Inserte la nacionalidad del autor: ");
        String nacionalidad = entrada.nextLine();
        System.out.print("Inserte la fecha de nacimineto del autor (dd/mm/yyyy): ");
        String fechaNacimiento = entrada.nextLine();
        return new Autor(nombre, apellido, nacionalidad,
                LocalDate.parse(fechaNacimiento, formatoFecha));
    }
}
