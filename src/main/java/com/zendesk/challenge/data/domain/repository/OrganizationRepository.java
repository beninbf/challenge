package com.zendesk.challenge.data.domain.repository;

import com.zendesk.challenge.data.domain.jpa.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *
 * <code>OrganizationRepository</code> repository for querying organization data.
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
public interface OrganizationRepository extends OrganizationDao, JpaRepository<Organization, Long> {

    /**
     * Retrieves organization by the id.
     *
     * @return Organization Object
     */
    Optional<Organization> findById(Long id);
}
