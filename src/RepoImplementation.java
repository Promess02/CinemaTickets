import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.*;

public class RepoImplementation<V> implements Repo<V>{
    private int index = 0;
    private Map<Integer,V> map = new HashMap<>();

    public RepoImplementation() {
    }

    @Override
    public List<V> getAllData() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void addData(V entity) {
        if(index==0) {
            map.put(0,entity);
            return;
        }
        map.put(++index, entity);
    }

    @Override
    public boolean checkIfContains(V entity) {
        return map.containsValue(entity);
    }

    @Override
    public Optional<V> findById(int id) {
        if(map.containsKey(id)) return Optional.of(map.get(id));
        return Optional.empty();
    }
    @Override
    public int getNextGeneratedId() {
        return index++;
    }
}
