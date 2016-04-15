package com.traventure.mongoRepository;

import org.springframework.data.repository.CrudRepository;

import com.traventure.domain.User;

public interface UserSignUpRepo extends CrudRepository<User, Long>{

}
