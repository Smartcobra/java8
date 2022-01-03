package designpattern.executearound.consumer;

import java.util.function.Consumer;

public class Resource {
    private Resource(){
        System.out.println("Creating Resource........");
    }

    public void fn1(){
        System.out.println("fn1 called....");
    }

    public void fn2(){
        System.out.println("fn2 called....");
    }
    private void close(){
        System.out.println("Resource Closed.....");
    }

    public static void use(Consumer<Resource> useResource){
        Resource rs= new Resource();
        try {
            useResource.accept(rs);
        }finally {
            rs.close();
        }

    }

}
