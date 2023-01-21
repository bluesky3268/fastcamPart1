package org.example.ch3.order;

public class Customer {

    public Cook order(String menuName, Menu menu, Chef chef) {
        MenuItem menuItem = menu.choose(menuName);
        return chef.cook(menuItem);
    }
}
