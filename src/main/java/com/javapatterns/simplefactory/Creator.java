package com.javapatterns.simplefactory;

public class Creator
{
    public static Product factory()
    {
        return new ConcreteProduct();
    }

}
