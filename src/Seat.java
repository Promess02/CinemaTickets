import java.io.Serializable;

public class Seat<K,V> implements Serializable {
    private K key;
    private V value;

    public Seat(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Seat {" +
                "row=" + key +
                ", seat=" + value +
                '}';
    }
}
