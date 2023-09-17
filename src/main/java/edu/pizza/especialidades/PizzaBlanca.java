package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

import java.util.ArrayList;
import java.util.List;

public class PizzaBlanca extends Pizza {

    public PizzaBlanca(String name, double price, Topping... toppings){
        super(name, toppings);
        //aggTop();
    }
}
