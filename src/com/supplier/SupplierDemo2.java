package com.supplier;

import java.util.function.Supplier;

public class SupplierDemo2 {

    public static void main(String[] args) {
        Supplier<String> sp= ()->"hi";
        System.out.println(sp.get());
    }
}
