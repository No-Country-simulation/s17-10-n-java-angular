package com.dev.ForoEscolar.repository;

import com.dev.ForoEscolar.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends GenericRepository<User, Long>{

}
