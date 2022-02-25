import java.util.ArrayList;
import java.util.Objects;

class ParametrList <E> {
    private int size;
    Object [] data = new Object[size];
    public int size(){
        return size;
    }
    public void add (E value){
        data[size] = value;
        size++;
    }
    public E get(int index) {
        Objects.checkIndex(index, size);
        return data(index);
    }
}

