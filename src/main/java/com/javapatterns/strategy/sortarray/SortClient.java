package com.javapatterns.strategy.sortarray;

public class SortClient {
    public static void main(String[] args) {

    Sorter sorter= new Sorter();
    sorter.setSortStrategy(new BinSort());
    sorter.sort();

    }
}
