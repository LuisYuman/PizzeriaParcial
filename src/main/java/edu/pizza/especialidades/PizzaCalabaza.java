package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class PizzaCalabaza extends Pizza {

    public PizzaCalabaza(String name, double price, String salsa, Topping... toppings){
        super(name, toppings);
        aggTop3();
    }

    public void aggTop3(){
        addTopping(new Topping("Calabaza", 10));
        addTopping(new Topping("Jamon", 10));
    }
}
