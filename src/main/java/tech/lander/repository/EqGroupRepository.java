package tech.lander.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tech.lander.domain.Qgroup;

public interface EqGroupRepository extends MongoRepository<Qgroup, String> {

}
