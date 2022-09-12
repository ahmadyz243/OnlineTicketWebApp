package repository;

import base.BaseRepository;
import domain.ComService;

import java.util.List;

public interface ComServiceRepository extends BaseRepository<ComService> {
    List<ComService> findByOriginAndDestination(String origin, String destination);
}

