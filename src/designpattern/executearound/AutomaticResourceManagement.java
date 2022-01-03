package designpattern.executearound;

import java.io.IOException;
import java.io.InputStream;

class Resource implements AutoCloseable {
    public Resource(){
        System.out.println("Creating Resource");
    }


    public void fn1(){
        System.out.println("fn1 called....");
    }

    public void fn2(){
        System.out.println("fn2 called....");
    }


    @Override
    public void close() throws Exception {
        System.out.println("Cleaned....");
    }
}

public class AutomaticResourceManagement {

    public static void main(String[] args) throws Exception {
        try(Resource resource= new Resource()){
            resource.fn1();
            resource.fn2();
        }


    }
}
