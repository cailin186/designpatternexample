package com.javapatterns.simplefactory.simplified1;

import com.javapatterns.simplefactory.Creator;
import com.javapatterns.simplefactory.Product;

public class Client {
    public static void main(String[] args) {
       Product productA=  Creator.factory();
       System.out.println(productA);
    }
}
