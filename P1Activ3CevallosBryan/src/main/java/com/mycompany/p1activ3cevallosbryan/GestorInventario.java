
package com.mycompany.p1activ3cevallosbryan;


import java.io.*;
import java.util.*;

class GestorInventario {
    private ArrayList<ItemInventario> inventario = new ArrayList<>();

    public void agregarItem() {
        System.out.println("\n=== Ingreso de Categoria ===");
        Categoria categoria = new Categoria(0, "", "", 0);
        Productos producto = new Productos("", "","");
        producto.mostrarDatos();
        categoria.mostrarDatosCat();

        try {
            verificarDuplicado(producto.getId(), categoria.getCodigo());
            ItemInventario nuevoItem = new ItemInventario(producto, categoria);
            inventario.add(nuevoItem);
        } catch (DatosDuplicadosException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void mostrarInventario() {
        System.out.println("\n=== Inventario Registrado ===");
        for (ItemInventario item : inventario) {
            item.mostrarDatosCompletos();
        }
    }

    public void guardarEnCSV(String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo, true)) {
            writer.write("ID,Nombre,Correo,Codigo,Etiqueta,Tipo,Precio\n");
            for (ItemInventario item : inventario) {
                writer.write(item.toCSV() + "\n");
            }
            System.out.println("Inventario guardado en CSV correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar CSV: " + e.getMessage());
        }
    }

    public void guardarEnJSON(String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo, true)) {
            writer.write("[\n");
            for (int i = 0; i < inventario.size(); i++) {
                writer.write(inventario.get(i).toJSON());
                if (i < inventario.size() - 1) {
                    writer.write(",\n");
                }
            }
            writer.write("\n]");
            System.out.println("Inventario guardado en JSON correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar JSON: " + e.getMessage());
        }
    }

 public void leerDesdeCSV(String nombreArchivo) {
    try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
        String linea;
        boolean esPrimeraLinea = true;
        int cargados = 0;
        while ((linea = br.readLine()) != null) {
            if (esPrimeraLinea) {
                esPrimeraLinea = false;
                continue;
            }

            String[] partes = linea.split(",");
            if (partes.length == 7) {
                String id = partes[0].trim();
                String nombre = partes[1].trim();
                String correo = partes[2].trim();
                int codigo = Integer.parseInt(partes[3].trim());
                String etiqueta = partes[4].trim();
                String tipo = partes[5].trim();
                double precio = Double.parseDouble(partes[6].trim());

                try {
                    verificarDuplicado(id, codigo);
                    Productos producto = new Productos(id, nombre, correo);
                    Categoria categoria = new Categoria(codigo, etiqueta, tipo, precio);
                    inventario.add(new ItemInventario(producto, categoria));
                    cargados++;
                } catch (DatosDuplicadosException e) {
                    System.out.println("Duplicado no cargado: " + e.getMessage());
                }
            }
        }
        System.out.println("\nCSV leído correctamente. Total cargados: " + cargados);
    } catch (Exception e) {
        System.out.println("Error al leer CSV: " + e.getMessage());
    }
}

public void verificarDuplicado(String id, int codigo) throws DatosDuplicadosException {
    for (ItemInventario item : inventario) {
        boolean idDuplicado = item.getProducto().getId().equalsIgnoreCase(id);
        boolean codigoDuplicado = item.getCategoria().getCodigo() == codigo;

        if (idDuplicado && codigoDuplicado) {
            throw new DatosDuplicadosException("ID y Codigo ya existen: ID = " + id + ", Codigo = " + codigo);
        } else if (idDuplicado) {
            throw new DatosDuplicadosException("ID duplicado: " + id);
        } else if (codigoDuplicado) {
            throw new DatosDuplicadosException("Codigo duplicado: " + codigo);
        }
    }
}



public void verContenidoCSV(String nombreArchivo) {
    System.out.println("\n=== Contenido del archivo CSV ===");
    try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }
    } catch (IOException e) {
        System.out.println("Error al leer el archivo CSV: " + e.getMessage());
    }
}
}