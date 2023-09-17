package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class PizzaCabra extends Pizza {

    public PizzaCabra(String name, double price, String salsa, Topping... toppings){
        super(name, toppings);
        aggTop2();
    }

    public void aggTop2(){
        addTopping(new Topping("Queso de cabra", 20));
        addTopping(new Topping("Foie Gras", 15));
        addTopping(new Topping("Miel", 10));
    }
}
