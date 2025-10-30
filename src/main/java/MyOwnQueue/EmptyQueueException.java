package MyOwnQueue;

public class EmptyQueueException extends Exception {
    public void printStackTrace() {
        System.out.print("Error Full\n");
    }
}
