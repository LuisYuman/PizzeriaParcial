package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class PizzaEspaguetis extends Pizza {

    public PizzaEspaguetis(String name, double price, String salsa, Topping... toppings){
        super(name, toppings);
        aggTop4();
    }

    public void aggTop4(){
        addTopping(new Topping("Espagueti", 10));
        addTopping(new Topping("Calabacin", 15));
        addTopping(new Topping("Jamon Serrano", 15));
    }
}
