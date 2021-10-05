package com.newton.aaw.provaav1.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.newton.aaw.provaav1.domain.entity.Revista;

public interface RevistaRepository extends MongoRepository<Revista, String> {
	
}
