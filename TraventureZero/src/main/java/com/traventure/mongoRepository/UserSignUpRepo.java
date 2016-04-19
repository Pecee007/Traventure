package com.traventure.mongoRepository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.traventure.domain.User;

public interface UserSignUpRepo extends CrudRepository<User, Long>{
	
	@Query("{'_id' : ?0}")
	public User getDisplayName(String username);
}
