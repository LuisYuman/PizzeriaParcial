package edu.pizza.base;

import java.util.ArrayList;

public class Topping {



    private String nombre; // Nombre del topping
    private ArrayList<String> ingredientes = new ArrayList<>(); // Ingredientes del topping

    private double precio;

    public double getPrecio() {
        return precio;
    }

    public void agregarIngrediente(String ingrediente) {
        this.ingredientes.add(ingrediente);
    }

    public Topping(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre + " - " + precio;
    }


    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<String> ingredientes) {
        this.ingredientes = ingredientes;
    }


}
