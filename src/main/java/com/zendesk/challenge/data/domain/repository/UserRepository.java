package com.zendesk.challenge.data.domain.repository;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.data.domain.jpa.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 *
 * <code>UserRepository</code> repository for querying user data.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 6, 2019    Creating a basic search.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 6, 2019
 */
@Repository
public interface UserRepository extends UserDao, JpaRepository<User, Long> {

    /**
     * Retrieves a user by the user id.
     *
     * @return User Object
     */
    Optional<User> findById(Long id);

    /**
     * Restrieves user by their organization.
     *
     * @param organization
     * @return List of Users
     */
    List<User> findByOrganization(Organization organization);
}
