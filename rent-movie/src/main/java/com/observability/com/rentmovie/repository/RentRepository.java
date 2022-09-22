package com.observability.com.rentmovie.repository;

import com.observability.com.rentmovie.entity.Rent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends MongoRepository<Rent, String> {

}
