package com.supplier;

import java.util.function.Supplier;

public class SupplierDemo implements Supplier<String> {

    @Override
    public String get() {
        return "Hello";
    }


    public static void main(String[] args) {
        SupplierDemo sd= new SupplierDemo();
        System.out.println(sd.get());
    }
}
