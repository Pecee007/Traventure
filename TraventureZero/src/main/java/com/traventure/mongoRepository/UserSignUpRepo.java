package com.traventure.mongoRepository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.traventure.domain.User;

public interface UserSignUpRepo extends CrudRepository<User, Long>{
	
	@Query("{'_id' : ?0},{_id:1}")
	public User getUser(String username);
	
	@Query("{'_id' : ?0},{_id:1}")
	public String getDisplayName(String username);
	
	@Query("{'_id' : ?0},{location:1,_id:0}")
	public String getUserLocation(String displayName);
	
	@Query("{'_id' : ?0},{{password:1},_id:0}")
	public String getUserPassword(String displayName);
}
