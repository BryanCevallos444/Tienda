
package com.mycompany.p1activ3cevallosbryan;

import java.util.Scanner;

public class Categoria {
    private int codigo;
    private double precio;
    private String tipo;
    private String etiqueta;
    Scanner dato = new Scanner(System.in);

    public Categoria(int codigo, String etiqueta, String tipo, double precio) {
        this.codigo = codigo;
        this.precio = precio;
        this.tipo = tipo;
        this.etiqueta = etiqueta;
    }

    public int getCodigo() { return codigo; }
    public double getPrecio() { return precio; }
    public String getTipo() { return tipo; }
    public String getEtiqueta() { return etiqueta; }

    public void setCodigo() {
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print("Ingrese el codigo del producto: ");
                codigo = dato.nextInt();
                if (codigo <= 0) throw new CampoVacioException("El codigo debe ser mayor a 0");
                this.codigo = codigo;
                valido = true;
            } catch (CampoVacioException e) {
                System.out.println("Error al validar codigo: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Entrada no valida. Intente nuevamente.");
                dato.nextLine();
            }
        }
    }

    public void setPrecio() {
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print("Ingrese el precio del producto: ");
                precio = dato.nextDouble();
                if (precio <= 0 || precio > 500) throw new PrecioInvalidoException("El precio debe ser mayor a 0 y no mayor a 500");
                this.precio = precio;
                valido = true;
            } catch (PrecioInvalidoException e) {
                System.out.println("Error al validar precio: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Entrada no valida. Intente nuevamente.");
                dato.nextLine();
            }
        }
    }

    public void setTipo(String tipo) {
        try {
            while (tipo == null || tipo.trim().isEmpty()) {
                System.out.println("El tipo no puede estar vacio. Ingrese nuevamente:");
                tipo = dato.nextLine();
            }
            this.tipo = tipo.trim();
        } catch (Exception e) {
            System.out.println("Error al asignar tipo: " + e.getMessage());
        }
    }

    public void setEtiqueta(String etiqueta) {
        try {
            while (etiqueta == null || etiqueta.trim().isEmpty()) {
                System.out.println("La etiqueta no puede estar vacia. Ingrese nuevamente:");
                etiqueta = dato.nextLine();
            }
            this.etiqueta = etiqueta.trim();
        } catch (Exception e) {
            System.out.println("Error al asignar etiqueta: " + e.getMessage());
        }
    }

    public void mostrarDatosCat() {
        System.out.println("Ingrese la Etiqueta del articulo:");
        setEtiqueta(dato.nextLine());
        setCodigo();
        dato.nextLine();
        System.out.println("Ingrese el tipo de articulo:");
        setTipo(dato.nextLine());
        setPrecio();
        dato.nextLine();
    }
}