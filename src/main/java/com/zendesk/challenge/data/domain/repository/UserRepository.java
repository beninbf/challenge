package com.zendesk.challenge.data.domain.repository;

import com.zendesk.challenge.data.domain.jpa.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends UserDao, JpaRepository<User, Long> {

    /**
     * Retrieves a user by the user id.
     *
     * @return User Object
     */
    User findByUserId(Long id);
}
