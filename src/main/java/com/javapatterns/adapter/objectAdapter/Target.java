package com.javapatterns.adapter.objectAdapter;

public interface Target {
    /**
     * Class Adaptee contains operation sampleOperation1. 
     */
    void sampleOperation1();

    /**
     * Class Adaptee doesn't contain operation sampleOperation2. 
     */
    void sampleOperation2();
}
