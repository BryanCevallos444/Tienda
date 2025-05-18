
package com.mycompany.p1activ3cevallosbryan;

class ItemInventario {
    private Productos producto;
    private Categoria categoria;

    public ItemInventario(Productos producto, Categoria categoria) {
        this.producto = producto;
        this.categoria = categoria;
    }

    public Productos getProducto() {
        return producto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void mostrarDatosCompletos() {
        System.out.println("ID Producto: " + producto.getId());
        System.out.println("Nombre Producto: " + producto.getNombre());
        System.out.println("Correo: " + producto.getCorreo());
        System.out.println("Codigo Categoria: " + categoria.getCodigo());
        System.out.println("Etiqueta: " + categoria.getEtiqueta());
        System.out.println("Tipo: " + categoria.getTipo());
        System.out.println("Precio: $" + categoria.getPrecio());
        System.out.println("-----------------------------");
    }

    public String toCSV() {
        return producto.getId() + "," +
               producto.getNombre() + "," +
               producto.getCorreo() + "," +
               categoria.getCodigo() + "," +
               categoria.getEtiqueta() + "," +
               categoria.getTipo() + "," +
               categoria.getPrecio();
    }

    public String toJSON() {
        return "{\n" +
            "  \"id\": \"" + producto.getId() + "\",\n" +
            "  \"nombre\": \"" + producto.getNombre() + "\",\n" +
            "  \"correo\": \"" + producto.getCorreo() + "\",\n" +
            "  \"codigo\": " + categoria.getCodigo() + ",\n" +
            "  \"etiqueta\": \"" + categoria.getEtiqueta() + "\",\n" +
            "  \"tipo\": \"" + categoria.getTipo() + "\",\n" +
            "  \"precio\": " + categoria.getPrecio() + "\n" +
            "}";
    }
}
