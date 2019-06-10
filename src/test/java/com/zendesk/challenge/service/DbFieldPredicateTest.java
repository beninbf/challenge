package com.zendesk.challenge.service;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * <code>DbFieldPredicateTest</code> is a class that test Predicates regarding a db fields.
 * <p>
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      Jan 24, 2019    PF-20630: Creating new API for generating legal documents.
 * </pre>
 *
 * @author Benin Bryant
 * @since Jan 24, 2019
 */
public class DbFieldPredicateTest {

    @Test
    public void testIsTimeField() {
        boolean isTimeField = DbFieldPredicate.isTimeField().test(DbFieldPredicate.CREATED_DATE);
        assertTrue("createdDate is a time field", isTimeField);

        isTimeField = DbFieldPredicate.isTimeField().test(DbFieldPredicate.LAST_LOGIN_DATE);
        assertTrue("lastLoginDate is a time field", isTimeField);

        isTimeField = DbFieldPredicate.isTimeField().test(DbFieldPredicate.DUE_DATE);
        assertTrue("dueDate is a time field", isTimeField);

        isTimeField = DbFieldPredicate.isTimeField().test(DbFieldPredicate.SHARED_TICKETS);
        assertFalse("sharedTickets is not a time field", isTimeField);

        isTimeField = DbFieldPredicate.isTimeField().test(DbFieldPredicate.SHARED);
        assertFalse("shared is not a time field", isTimeField);

        isTimeField = DbFieldPredicate.isTimeField().test(DbFieldPredicate.VERIFIED);
        assertFalse("verified is not a time field", isTimeField);

        isTimeField = DbFieldPredicate.isTimeField().test(DbFieldPredicate.ACTIVE);
        assertFalse("active is not a time field", isTimeField);

        isTimeField = DbFieldPredicate.isTimeField().test(DbFieldPredicate.SUSPENDED);
        assertFalse("suspended is not a time field", isTimeField);

        isTimeField = DbFieldPredicate.isTimeField().test(DbFieldPredicate.HAS_INCIDENTS);
        assertFalse("hasIncidents is not a time field", isTimeField);

        isTimeField = DbFieldPredicate.isTimeField().test(DbFieldPredicate.ASSIGNEE);
        assertFalse("assignee is not a time field", isTimeField);

        isTimeField = DbFieldPredicate.isTimeField().test(DbFieldPredicate.SUBMITTER);
        assertFalse("submitter is not a time field", isTimeField);

        isTimeField = DbFieldPredicate.isTimeField().test(DbFieldPredicate.ORGANIZATION);
        assertFalse("organization is not a time field", isTimeField);
    }

    @Test
    public void testIsBooleanField() {
        boolean isBooleanField = DbFieldPredicate.isBooleanField().test(DbFieldPredicate.CREATED_DATE);
        assertFalse("createdDate is not a boolean field", isBooleanField);

        isBooleanField = DbFieldPredicate.isBooleanField().test(DbFieldPredicate.LAST_LOGIN_DATE);
        assertFalse("lastLoginDate is not a boolean field", isBooleanField);

        isBooleanField = DbFieldPredicate.isBooleanField().test(DbFieldPredicate.DUE_DATE);
        assertFalse("dueDate is not a boolean field", isBooleanField);

        isBooleanField = DbFieldPredicate.isBooleanField().test(DbFieldPredicate.SHARED_TICKETS);
        assertTrue("sharedTickets is a boolean field", isBooleanField);

        isBooleanField = DbFieldPredicate.isBooleanField().test(DbFieldPredicate.SHARED);
        assertTrue("shared is a boolean field", isBooleanField);

        isBooleanField = DbFieldPredicate.isBooleanField().test(DbFieldPredicate.VERIFIED);
        assertTrue("verified is a boolean field", isBooleanField);

        isBooleanField = DbFieldPredicate.isBooleanField().test(DbFieldPredicate.ACTIVE);
        assertTrue("active is a boolean field", isBooleanField);

        isBooleanField = DbFieldPredicate.isBooleanField().test(DbFieldPredicate.SUSPENDED);
        assertTrue("suspended is a boolean field", isBooleanField);

        isBooleanField = DbFieldPredicate.isBooleanField().test(DbFieldPredicate.HAS_INCIDENTS);
        assertTrue("hasIncidents is a boolean field", isBooleanField);

        isBooleanField = DbFieldPredicate.isBooleanField().test(DbFieldPredicate.ASSIGNEE);
        assertFalse("assignee is not a boolean field", isBooleanField);

        isBooleanField = DbFieldPredicate.isBooleanField().test(DbFieldPredicate.SUBMITTER);
        assertFalse("submitter is not a boolean field", isBooleanField);

        isBooleanField = DbFieldPredicate.isBooleanField().test(DbFieldPredicate.ORGANIZATION);
        assertFalse("organization is not a boolean field", isBooleanField);
    }

    @Test
    public void testIsUserField() {
        boolean isUserField = DbFieldPredicate.isUserField().test(DbFieldPredicate.CREATED_DATE);
        assertFalse("createdDate is not a user field", isUserField);

        isUserField = DbFieldPredicate.isBooleanField().test(DbFieldPredicate.LAST_LOGIN_DATE);
        assertFalse("lastLoginDate is not a user field", isUserField);

        isUserField = DbFieldPredicate.isUserField().test(DbFieldPredicate.DUE_DATE);
        assertFalse("dueDate is not a user field", isUserField);

        isUserField = DbFieldPredicate.isUserField().test(DbFieldPredicate.SHARED_TICKETS);
        assertFalse("sharedTickets is not a user field", isUserField);

        isUserField = DbFieldPredicate.isUserField().test(DbFieldPredicate.SHARED);
        assertFalse("shared is not a user field", isUserField);

        isUserField = DbFieldPredicate.isUserField().test(DbFieldPredicate.VERIFIED);
        assertFalse("verified is a user field", isUserField);

        isUserField = DbFieldPredicate.isUserField().test(DbFieldPredicate.ACTIVE);
        assertFalse("active is a user field", isUserField);

        isUserField = DbFieldPredicate.isUserField().test(DbFieldPredicate.SUSPENDED);
        assertFalse("suspended is not a user field", isUserField);

        isUserField = DbFieldPredicate.isUserField().test(DbFieldPredicate.HAS_INCIDENTS);
        assertFalse("hasIncidents is not a user field", isUserField);

        isUserField = DbFieldPredicate.isUserField().test(DbFieldPredicate.ASSIGNEE);
        assertTrue("assignee is a user field", isUserField);

        isUserField = DbFieldPredicate.isUserField().test(DbFieldPredicate.SUBMITTER);
        assertTrue("submitter is a user field", isUserField);

        isUserField = DbFieldPredicate.isUserField().test(DbFieldPredicate.ORGANIZATION);
        assertFalse("organization is not a user field", isUserField);
    }

    @Test
    public void testIsOrganizationField() {
        boolean isOrganizationField = DbFieldPredicate.isOrganizationField().test(DbFieldPredicate.CREATED_DATE);
        assertFalse("createdDate is not an organization field", isOrganizationField);

        isOrganizationField = DbFieldPredicate.isOrganizationField().test(DbFieldPredicate.LAST_LOGIN_DATE);
        assertFalse("lastLoginDate is not an organization field", isOrganizationField);

        isOrganizationField = DbFieldPredicate.isOrganizationField().test(DbFieldPredicate.DUE_DATE);
        assertFalse("dueDate is not an organization field", isOrganizationField);

        isOrganizationField = DbFieldPredicate.isOrganizationField().test(DbFieldPredicate.SHARED_TICKETS);
        assertFalse("sharedTickets is not an organization field", isOrganizationField);

        isOrganizationField = DbFieldPredicate.isOrganizationField().test(DbFieldPredicate.SHARED);
        assertFalse("shared is not an organization field", isOrganizationField);

        isOrganizationField = DbFieldPredicate.isOrganizationField().test(DbFieldPredicate.VERIFIED);
        assertFalse("verified is not an organization field", isOrganizationField);

        isOrganizationField = DbFieldPredicate.isOrganizationField().test(DbFieldPredicate.ACTIVE);
        assertFalse("active is not an organization field", isOrganizationField);

        isOrganizationField = DbFieldPredicate.isOrganizationField().test(DbFieldPredicate.SUSPENDED);
        assertFalse("suspended is not an organization field", isOrganizationField);

        isOrganizationField = DbFieldPredicate.isOrganizationField().test(DbFieldPredicate.HAS_INCIDENTS);
        assertFalse("hasIncidents is not an organization field", isOrganizationField);

        isOrganizationField = DbFieldPredicate.isOrganizationField().test(DbFieldPredicate.ASSIGNEE);
        assertFalse("assignee is not an organization field", isOrganizationField);

        isOrganizationField = DbFieldPredicate.isOrganizationField().test(DbFieldPredicate.SUBMITTER);
        assertFalse("submitter is not an organization field", isOrganizationField);

        isOrganizationField = DbFieldPredicate.isOrganizationField().test(DbFieldPredicate.ORGANIZATION);
        assertTrue("organization is an organization field", isOrganizationField);
    }
}
