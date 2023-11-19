package hw_seminar2.server.server.repository;

public interface Repository<T> {
    void save(T text);
    T load();
}
