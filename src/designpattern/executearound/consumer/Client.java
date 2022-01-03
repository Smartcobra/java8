package designpattern.executearound.consumer;



public class Client {
    public static void main(String[] args) {
        Resource.use(resource -> {
            resource.fn1();
            resource.fn2();
        });
    }
}
