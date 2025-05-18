
package com.mycompany.p1activ3cevallosbryan;

import java.util.Scanner;

public class Productos {
    private String id;
    private String nombre;
    private String correo;
    Scanner dato1 = new Scanner(System.in);

    public Productos(String id, String nombre,String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getNombre() { 
        return nombre;
    }
    public String getId() { 
        return id; 
    }
    public String getCorreo() {
        return correo;
    }

    public void setId(String id) {
        try {
            while (id == null || id.trim().isEmpty()) {
                System.out.println("El ID no puede estar vacio. Ingrese nuevamente:");
                id = dato1.nextLine();
            }
            this.id = id.trim();
        } catch (Exception e) {
            System.out.println("Error al asignar ID: " + e.getMessage());
        }
    }

    public void setNombre(String nombre) {
        try {
            while (nombre == null || nombre.trim().isEmpty()) {
                System.out.println("El nombre no puede estar vacio. Ingrese nuevamente:");
                nombre = dato1.nextLine();
            }
            this.nombre = nombre.trim();
        } catch (Exception e) {
            System.out.println("Error al asignar nombre: " + e.getMessage());
        }
    }

    public void setCorreo() throws FormatoCorreoInvalidoException { 
     boolean valido = false;
        while (!valido) {
            try {
                System.out.print("Ingrese el correo del proveedor :");
                correo = dato1.nextLine();
               if (correo == null || !correo.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")||correo.trim().isEmpty())
               throw new FormatoCorreoInvalidoException("Correo invalido. Debe tener formato ejemplo@dominio.com");
                this.correo = correo;
                valido = true;
            } catch (FormatoCorreoInvalidoException e) {
                System.out.println("Error al validar correo: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Entrada no valida. Intente nuevamente.");
                dato1.nextLine();
            }
        }
    }

    public void mostrarDatos() {
        try {
            System.out.println("Ingrese el nombre del articulo :");
            setNombre(dato1.nextLine());
            System.out.println("El nombre del producto ingresado es : " + getNombre());
            System.out.println("Ingrese el ID del articulo :");
            setId(dato1.nextLine());
            System.out.println("El ID del producto ingresado es : " + getId());
            setCorreo();
            System.out.println("Correo registrado: " + getCorreo());
        } catch (FormatoCorreoInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
            mostrarDatos();
        }
    }
}
