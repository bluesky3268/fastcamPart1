package org.example.ch3.order;

/**
 * 요리사
 */
public class Chef {

    public Cook cook(MenuItem menuItem) {
        Cook cook = new Cook(menuItem);
        return cook;
    }
}
