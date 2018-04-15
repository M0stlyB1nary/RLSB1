package tech.lander.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tech.lander.domain.Quake;

import java.util.List;

public interface EqRepository extends MongoRepository<Quake, String> {

    public List<Quake> findByGroupObjectId(String groupObjectId);
}
