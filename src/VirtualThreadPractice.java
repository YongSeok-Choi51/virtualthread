public class VirtualThreadPractice {


    public static void main(String[] args) throws Exception {

        Thread.Builder.OfVirtual ofVirtual = Thread.ofVirtual().name("ysVirt");
        Runnable task = () -> {
            System.out.println("hello world? and name is " + Thread.currentThread().getName());
        };

        Thread start = ofVirtual.start(task);
        System.out.println("my namme is : " + start.getName());

        start.join();

    }
}
