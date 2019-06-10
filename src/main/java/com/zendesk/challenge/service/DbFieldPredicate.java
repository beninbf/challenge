package com.zendesk.challenge.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public final class DbFieldPredicate {

    /* BOOLEAN FIELDS */
    public static final String SHARED_TICKETS = "sharedTickets";

    public static final String VERIFIED = "verified";

    public static final String ACTIVE = "active";

    public static final String SHARED = "shared";

    public static final String SUSPENDED = "suspended";

    public static final String HAS_INCIDENTS = "hasIncidents";

    /* TIME FIELDS */
    public static final String CREATED_DATE = "createdDate";

    public static final String LAST_LOGIN_DATE = "lastLoginDate";

    public static final String DUE_DATE = "dueDate";

    /* USER FIELDS*/
    public static final String ASSIGNEE = "assignee";

    public static final String SUBMITTER = "submitter";

    /* ORGANIZATION FIELDS*/
    public static final String ORGANIZATION = "organization";

    private static final Set<String> booleanFields = new HashSet<>(
        Arrays.asList(VERIFIED, ACTIVE, SHARED, SUSPENDED, SHARED_TICKETS, HAS_INCIDENTS)
    );

    private static final Set<String> timeFields = new HashSet<>(Arrays.asList(CREATED_DATE, LAST_LOGIN_DATE, DUE_DATE));

    private static final Set<String> organizaitonFields = new HashSet<>(Arrays.asList(ORGANIZATION));

    private static final Set<String> userFields = new HashSet<>(Arrays.asList(ASSIGNEE, SUBMITTER));

    private DbFieldPredicate() {}

    public static Predicate<String> isBooleanField() { return field -> booleanFields.contains(field); }

    public static Predicate<String> isTimeField() { return field -> timeFields.contains(field); }

    public static Predicate<String> isUserField() { return field -> userFields.contains(field); }

    public static Predicate<String> isAssignee() { return field -> ASSIGNEE.equals(field); }

    public static Predicate<String> isSubmitter() { return field -> SUBMITTER.equals(field); }

    public static Predicate<String> isOrganizationField() { return field -> organizaitonFields.contains(field); }

}
