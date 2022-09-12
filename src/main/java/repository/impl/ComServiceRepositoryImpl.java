package repository.impl;

import base.BaseRepositoryImpl;
import domain.ComService;
import repository.ComServiceRepository;

import java.util.List;

public class ComServiceRepositoryImpl extends BaseRepositoryImpl<ComService> implements ComServiceRepository {
    @Override
    public Class<ComService> getEntityClass() {
        return ComService.class;
    }

    @Override
    public List<ComService> findByOriginAndDestination(String origin, String destination) {
        return em.createQuery("select c from ComService c where c.originCity =: origin and c.destinationCity =: destination"
                , ComService.class).setParameter("origin", origin).setParameter("destination", destination).getResultList();
    }
}
