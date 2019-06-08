package com.zendesk.challenge.data.domain.repository;

import com.zendesk.challenge.data.domain.jpa.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends OrganizationDao, JpaRepository<Organization, Long> {

    /**
     * Retrieves organization by the id.
     *
     * @return Organization Object
     */
    Organization findByOrganizationId(long id);
}
