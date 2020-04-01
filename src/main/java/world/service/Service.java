package world.service;

public interface Service<T, ID> {
    T add(T c);

    Iterable<T> findAll();

    T findById(ID id);

    Iterable<T> findByName(String name);

    boolean existsById(ID id);

    long count();

    void update(ID id, Updatable c);

    void deleteById(ID id);
}
