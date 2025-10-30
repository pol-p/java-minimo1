package MyOwnQueue;

public class QueueImpl<E> implements Queuee<E>{
    private E[] data;
    private int p;

    public QueueImpl(int len) {
        // TO-DO
        this.p = 0;
        this.data = (E[])new Object[len];
    }

    public void push(E e) throws FullQueueException {
        if (isFull()) throw new FullQueueException();
        this.data[this.p++]=e;

    }


    public E pop() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException();
        E res = data[0];
        for(int i = 1; i < this.p; i++){
            data[i - 1] = data[i];
        }
        p--;
        return res;

    }

    private boolean isFull() {
        // TO-DO
        return this.data.length == this.p;
    }

    private boolean isEmpty() {
        // TO-DO
        return (p == 0);
    }

    public int size() {
        //TO-Do
        return this.p;
    }
}
