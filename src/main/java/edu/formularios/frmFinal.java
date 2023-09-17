package edu.formularios;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;
import edu.pizza.especialidades.PizzaBlanca;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class frmFinal {
    private JComboBox comboBoxToppings;
    private JTextField txtPizza;
    private JButton btnAddIngrediente;
    private JLabel lblTotal;
    private JList lista1;
    private JButton btnPreparPizza;
    private JPanel jPanelPrincipal;
    private JComboBox comboBoxPizzas;
    private JButton btnDltIngrediente;
    private JRadioButton pequeñaRadioButton;
    private JRadioButton medianaRadioButton;
    private JRadioButton grandeRadioButton;
    private JList lista2;

    private List<Topping> ingredientes = new ArrayList<>();
    private List<Pizza> pizzas = new ArrayList<>();
    private List<Topping> pizzaBlanca = new ArrayList<>();
    private List<Topping> pizzaQuesoDeCabra = new ArrayList<>();
    private List<Topping> pizzaCalabaza = new ArrayList<>();
    private List<Topping> pizzaEspaguetis = new ArrayList<>();
    private List<Topping> pizzaVegetariana = new ArrayList<>();



    private DefaultListModel modeloLista = new DefaultListModel();

    private double total = 0.0;

    private ButtonGroup sizeButtonGroup;

    public frmFinal() {
        cargarToppings();
        cargarpizzas();
        btnAddIngrediente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Topping ingrediente = (Topping) comboBoxToppings.getSelectedItem();

                modeloLista.addElement(ingrediente);
                lista1.setModel(modeloLista);
                total += ingrediente.getPrecio();
                lblTotal.setText(String.valueOf(total));
            }
        });
        btnDltIngrediente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lista1.getSelectedIndex() == -1){
                    JOptionPane.showMessageDialog(null, "Debe seleccionar un ingrediente");
                    return;
                }
                Topping ingrediente = (Topping) lista1.getSelectedValue();
                modeloLista.removeElement(ingrediente);
                lista1.setModel(modeloLista);
                total -= ingrediente.getPrecio();
                lblTotal.setText(String.valueOf(total));
            }
        });

        sizeButtonGroup = new ButtonGroup();
        sizeButtonGroup.add(pequeñaRadioButton);
        sizeButtonGroup.add(medianaRadioButton);
        sizeButtonGroup.add(grandeRadioButton);

        pequeñaRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePizzaPrice();
            }
        });

        medianaRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePizzaPrice();
            }
        });

        grandeRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePizzaPrice();
            }
        });
        btnPreparPizza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtPizza.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Debe ingresar el nombre de la pizza");
                    return;
                }
                if (lista1.getModel().getSize() == 0){
                    JOptionPane.showMessageDialog(null, "Debe ingresar al menos un ingrediente");
                    return;
                }
                JOptionPane.showMessageDialog(null, "Pizza preparada");

                Pizza pizza = new Pizza(txtPizza.getText());
                Topping topi;
                for (int i = 0; i < lista1.getModel().getSize(); i++) {
                    topi = (Topping) lista1.getModel().getElementAt(i);
                    pizza.addTopping(topi);
                }
                pizza.prepare();
            }
        });
        comboBoxPizzas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pizza pizza = (Pizza) comboBoxPizzas.getSelectedItem();
                modeloLista.removeAllElements();
                lista1.setModel(modeloLista);
                txtPizza.setText(pizza.getName());
                total = 0.0;
                lblTotal.setText(String.valueOf(total));

                if (pizza.getName().equals("Pizza Blanca")){
                    tppb();
                    for (int i = 0; i < pizzaBlanca.size(); i++) {
                        modeloLista.addElement(pizzaBlanca.get(i));
                        lista1.setModel(modeloLista);
                        total += pizzaBlanca.get(i).getPrecio();
                        lblTotal.setText(String.valueOf(total));
                    }
                } else if (pizza.getName().equals("Pizza Calabaza")) {
                    tppc();
                    for (int i = 0; i < pizzaCalabaza.size(); i++) {
                        modeloLista.addElement(pizzaCalabaza.get(i));
                        lista1.setModel(modeloLista);
                        total += pizzaCalabaza.get(i).getPrecio();
                        lblTotal.setText(String.valueOf(total));
                    }
                } else if (pizza.getName().equals("Pizza Espaguetis")) {
                    tppe();
                    for (int i = 0; i < pizzaEspaguetis.size(); i++) {
                        modeloLista.addElement(pizzaEspaguetis.get(i));
                        lista1.setModel(modeloLista);
                        total += pizzaEspaguetis.get(i).getPrecio();
                        lblTotal.setText(String.valueOf(total));
                    }
                } else if (pizza.getName().equals("Pizza Queso de Cabra")) {
                    tppqdc();
                    for (int i = 0; i < pizzaQuesoDeCabra.size(); i++) {
                        modeloLista.addElement(pizzaQuesoDeCabra.get(i));
                        lista1.setModel(modeloLista);
                        total += pizzaQuesoDeCabra.get(i).getPrecio();
                        lblTotal.setText(String.valueOf(total));
                    }
                } else if (pizza.getName().equals("Pizza Vegetariana")) {
                    tppv();
                    for (int i = 0; i < pizzaVegetariana.size(); i++) {
                        modeloLista.addElement(pizzaVegetariana.get(i));
                        lista1.setModel(modeloLista);
                        total += pizzaVegetariana.get(i).getPrecio();
                        lblTotal.setText(String.valueOf(total));
                    }
                } else if (pizza.getName().equals("Yo la armooooo")) {
                    for (int i = 0; i < ingredientes.size(); i++) {
                        modeloLista.addElement(ingredientes.get(i));
                        lista1.setModel(modeloLista);
                        total += ingredientes.get(i).getPrecio();
                        lblTotal.setText(String.valueOf(total));
                    }
                }

            }
        });
    }

    public JPanel getjPanelPrincipal() {
        return jPanelPrincipal;
    }

    private void cargarToppings() {
        ingredientes.add(new Topping("Albahaca", 10));
        ingredientes.add(new Topping("Champiñones", 10));
        ingredientes.add(new Topping("Pepino", 10));
        ingredientes.add(new Topping("Brocoli", 10));
        ingredientes.add(new Topping("Coliflor", 10));

        DefaultComboBoxModel model = new DefaultComboBoxModel(ingredientes.toArray());
        comboBoxToppings.setModel(model);

    }

    private void cargarpizzas(){
        pizzas.add(new Pizza("Pizza Blanca"));
        pizzas.add(new Pizza("Pizza Queso de Cabra"));
        pizzas.add(new Pizza("Pizza Calabaza"));
        pizzas.add(new Pizza("Pizza Espaguetis"));
        pizzas.add(new Pizza("Pizza Vegetariana"));
        pizzas.add(new Pizza("Yo la armooooo"));

        DefaultComboBoxModel model = new DefaultComboBoxModel(pizzas.toArray());
        comboBoxPizzas.setModel(model);

    }



    private void tppb(){
        pizzaBlanca.add(new Topping("Cebolla", 10));
        pizzaBlanca.add(new Topping("Jamon", 10));
        pizzaBlanca.add(new Topping("Parmesano", 10));
    }

    private void tppc(){
        pizzaCalabaza.add(new Topping("Calabaza", 10));
        pizzaCalabaza.add(new Topping("Jamon", 10));
    }

    private void tppe(){
        pizzaEspaguetis.add(new Topping("Espaguetis", 10));
        pizzaEspaguetis.add(new Topping("Calabacin", 10));
        pizzaEspaguetis.add(new Topping("Jamon Serrano", 10));
    }

    private void tppqdc(){
        pizzaQuesoDeCabra.add(new Topping("Queso de Cabra", 10));
        pizzaQuesoDeCabra.add(new Topping("Foie Gras", 10));
        pizzaQuesoDeCabra.add(new Topping("Miel", 10));
    }

    private void tppv(){
        pizzaVegetariana.add(new Topping("Aguacates", 10));
        pizzaVegetariana.add(new Topping("Nueces", 10));
    }

    private void updatePizzaPrice(){
        String selectedSize = "";
        if (pequeñaRadioButton.isSelected()){
            selectedSize = "Pequeña";
        } else if (medianaRadioButton.isSelected()){
            selectedSize = "Mediana";
        } else if (grandeRadioButton.isSelected()){
            selectedSize = "Grande";
        }
        double precio = calcularPrecioSegunTamaño(selectedSize);
        lblTotal.setText(String.valueOf(total + precio));
    }

    private double calcularPrecioSegunTamaño(String size){
        double precio = 0.0;
        if ("Pequeña".equals(size)){
            precio = 40.0;
        } else if ("Mediana".equals(size)){
            precio = 50.0;
        } else if ("Grande".equals(size)){
            precio = 70.0;
        }
        return precio;
    }

}
