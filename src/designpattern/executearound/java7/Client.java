package designpattern.executearound.java7;

public class Client {
    public static void main(String[] args) {
        Resource.use(new UseResource() {
            @Override
            public void accept(Resource resource) {
                resource.fn1();
                resource.fn2();
            }
        });
    }
}
