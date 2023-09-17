package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class PizzaVegetariana extends Pizza {

    public PizzaVegetariana(String name, double price, String salsa, Topping... toppings){
        super(name, toppings);
        aggTop5();
    }

    public void aggTop5(){
        addTopping(new Topping("Aguacate", 10));
        addTopping(new Topping("Nueces", 15));
    }
}
