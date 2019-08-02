package tech.lander.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import tech.lander.domain.Vehicle;

import java.util.List;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, String> {

    @Query(value = "{ 'make' : ?0}")
    List<Vehicle> findByMake(String make);

    Vehicle insert(Vehicle vehicle);

    List<Vehicle> findAll();

    //TODO: Update method


}
