package Repositories;

import java.util.ArrayList;
import java.util.Optional;

public class InMemoryRepository<T extends Entity> implements Repository<T> {
    private ArrayList<T> entities;

    private String entityType;

    public InMemoryRepository(ArrayList<T> entities, String entityType) {
        this.entities = entities;

        this.entityType = entityType;
    }

    public Optional<T> fetchById(String id) {

        ArrayList<T> entitiesWithThisId = new ArrayList<T>();

        for (T entity : this.entities) {
            if (entity.getId().equals(id)) {
                entitiesWithThisId.add(entity);
            }
        }

        if (entitiesWithThisId.size() == 2) {
            System.out.println("[Repository.fetchById] Error: Found more than one " + entityType);
            // We should raise an exception here. All bets are off!
        }

        if (entitiesWithThisId.size() == 1) {
            return Optional.of(entitiesWithThisId.get(0));
        }

        // Not Found
        return Optional.ofNullable(null);
    }

    public ArrayList<T> fetchMany() {
        // TODO Should we clone to avoid shared references?
        return this.entities;
    }

    public void create(T entity) {
        this.entities.add(entity);
    }

    public void update(T updatedEntity) {
        String idOfEntityToUpdate = updatedEntity.getId();

        Optional<T> searchResult = this.fetchById(idOfEntityToUpdate);

        if (!searchResult.isPresent()) {
            System.out.println("Cannot update entity as there is no entity with the id: " + idOfEntityToUpdate);

            return;
        }

        this.entities.forEach(
                entity -> {
                    if (entity.getId() == idOfEntityToUpdate) {
                        // does this work?
                        entity = updatedEntity;
                    }
                });
    }
}