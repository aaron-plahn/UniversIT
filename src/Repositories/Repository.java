package Repositories;

import java.util.ArrayList;
import java.util.Optional;

public interface Repository<T extends Entity> {
    Optional<T> fetchById(String id);

    ArrayList<T> fetchMany();

    void create(T entity);

    void update(T updatedEntity);
}
