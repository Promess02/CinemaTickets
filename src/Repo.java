import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface Repo<V> extends Serializable {
    List<V> getAllData();
    void addData(V entity);
    boolean checkIfContains(V entity);
    Optional<V> findById(int id);
    int getNextGeneratedId();

    void setAllData(List<V> data);


}
