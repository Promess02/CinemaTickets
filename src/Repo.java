import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface Repo<V> {
    List<V> getAllData();
    void addData(V entity);
    boolean checkIfContains(V entity);
    Optional<V> findById(int id);
    int getNextGeneratedId();


}
