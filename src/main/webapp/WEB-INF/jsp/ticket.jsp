<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
    <head>
        <style>
            .zendesk-logo {
                display: block;
                -ms-flex: 0 0 auto;
                flex: 0 0 auto;
                width: 200px;
                height: 40px;
                background: url(//d1eipm3vz40hy0.cloudfront.net/images/navigation/header/zendesk-logo.svg) left top no-repeat transparent;
                overflow: hidden;
                text-indent: -9999px;
                border: none;
                margin-top: 5%;
            }
        </style>
        <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
        <c:url value="/css/main.css" var="jstlCss" />
        <link href="${jstlCss}" rel="stylesheet" />
    </head>
    <body>
        <div class="container">
            <a href="/" class="zendesk-logo"></a>
            <div class="navbar-header">
                <a class="navbar-brand" style="padding: 15px 0;" href="/ticket-options">Back</a>
            </div>
        </div>
        <div class="container">
            <div class="starter-template">
                <h2 style="color: #03363d;" class="display-2">Ticket Search Results</h2>
                <table class="table table-bordered" style="max-width:30%;">
                    <thead class="thead-light">
                        <tr>
                            <th scope="col">TICKET FIELD</th>
                            <th scope="col">FIELD VALUE</th>
                            <th scope="col">NUMBER OF TICKETS</th>
                        <tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>${field}</td>
                            <td>
                                <c:if test="${empty value}">
                                    NULL
                                </c:if>
                                <c:if test="${not empty value}">
                                    ${value}
                                </c:if>
                            </td>
                            <td>${ticketsCount}</td>
                        </tr>
                    </tbody>
                </table>
                <table class="table table-striped table-bordered">
                    <thead class="thead-light">
                        <tr>
                            <th>TICKET ID</th>
                            <th>URL</th>
                            <th>EXTERNAL ID</th>
                            <th>CREATED_AT</th>
                            <th>TYPE</th>
                            <th>SUBJECT</th>
                            <th>DESCRIPTION</th>
                            <th>PRIORITY</th>
                            <th>STATUS</th>
                            <th>SUBMITTER ID</th>
                            <th>ASSIGNEE ID</th>
                            <th>ORGANIZATION ID</th>
                            <th>TAGS</th>
                            <th>HAS_INCIDENTS</th>
                            <th>DUE AT</th>
                            <th>VIA</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="ticket" items="${tickets}">
                           <tr>
                               <td>${ticket.id}</td>
                               <td>${ticket.url}</td>
                               <td>${ticket.externalId}</td>
                               <td>${ticket.createdAt}</td>
                               <td>${ticket.type}</td>
                               <td>${ticket.subject}</td>
                               <td>${ticket.description}</td>
                               <td>${ticket.priority}</td>
                               <td>${ticket.status}</td>
                               <td>${ticket.submitterId}</td>
                               <td>${ticket.assigneeId}</td>
                               <td>${ticket.organizationId}</td>
                               <td>${ticket.tags}</td>
                               <td>${ticket.hasIncidents}</td>
                               <td>${ticket.dueAt}</td>
                               <td>${ticket.via}</td>
                           </tr>
                        </c:forEach>
                    </tbody>
               </table>
                <h2 style="color: #03363d;" class="display-2">Assignees for Tickets</h2>
                <table class="table table-bordered" style="max-width:30%;">
                    <thead class="thead-light">
                        <tr>
                            <th scope="col">USER FIELD</th>
                            <th scope="col">FIELD VALUE</th>
                            <th scope="col">NUMBER OF ASSIGNEES</th>
                        <tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>${field}</td>
                            <td>
                                <c:if test="${empty value}">
                                    NULL
                                </c:if>
                                <c:if test="${not empty value}">
                                    ${value}
                                </c:if>
                            </td>
                            <td>${assigneesCount}</td>
                        </tr>
                    </tbody>
                </table>
                <table class="table table-striped table-bordered">
                    <thead class="thead-light">
                       <tr>
                           <th scope="col">USER ID</th>
                           <th scope="col">URL</th>
                           <th scope="col">EXTERNAL ID</th>
                           <th scope="col">NAME</th>
                           <th scope="col">ALIAS</th>
                           <th scope="col">CREATED_AT</th>
                           <th scope="col">ACTIVE</th>
                           <th scope="col">VERIFIED</th>
                           <th scope="col">SHARED</th>
                           <th scope="col">LOCALE</th>
                           <th scope="col">TIMEZONE</th>
                           <th scope="col">LAST LOGIN AT</th>
                           <th scope="col">EMAIL</th>
                           <th scope="col">PHONE</th>
                           <th scope="col">SIGNATURE</th>
                           <th scope="col">ORGANIZATION ID</th>
                           <th scope="col">TAGS</th>
                           <th scope="col">SUSPENDED</th>
                           <th scope="col">ROLE</th>
                       </tr>
                    </thead>
                    <tbody>
                      <c:forEach var="assignee" items="${assignees}">
                          <tr>
                              <td>${assignee.id}</td>
                              <td>${assignee.url}</td>
                              <td>${assignee.externalId}</td>
                              <td>${assignee.name}</td>
                              <td>${assignee.alias}</td>
                              <td>${assignee.createdAt}</td>
                              <td>${assignee.active}</td>
                              <td>${assignee.verified}</td>
                              <td>${assignee.shared}</td>
                              <td>${assignee.locale}</td>
                              <td>${assignee.timezone}</td>
                              <td>${assignee.lastLoginAt}</td>
                              <td>${assignee.email}</td>
                              <td>${assignee.phone}</td>
                              <td>${assignee.signature}</td>
                              <td>${assignee.organizationId}</td>
                              <td>${assignee.tags}</td>
                              <td>${assignee.suspended}</td>
                              <td>${assignee.role}</td>
                          </tr>
                       </c:forEach>
                    </tbody>
                </table>
                <h2 style="color: #03363d;" class="display-2">Submitters for Tickets</h2>
                <table class="table table-bordered" style="max-width:30%;">
                    <thead class="thead-light">
                        <tr>
                            <th scope="col">USER FIELD</th>
                            <th scope="col">FIELD VALUE</th>
                            <th scope="col">NUMBER OF SUBMITTERS</th>
                        <tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>${field}</td>
                            <td>
                                <c:if test="${empty value}">
                                    NULL
                                </c:if>
                                <c:if test="${not empty value}">
                                    ${value}
                                </c:if>
                            </td>
                            <td>${submittersCount}</td>
                        </tr>
                    </tbody>
                </table>
                <table class="table table-striped table-bordered">
                    <thead class="thead-light">
                        <tr>
                             <th scope="col">USER ID</th>
                             <th scope="col">URL</th>
                             <th scope="col">EXTERNAL ID</th>
                             <th scope="col">NAME</th>
                             <th scope="col">ALIAS</th>
                             <th scope="col">CREATED_AT</th>
                             <th scope="col">ACTIVE</th>
                             <th scope="col">VERIFIED</th>
                             <th scope="col">SHARED</th>
                             <th scope="col">LOCALE</th>
                             <th scope="col">TIMEZONE</th>
                             <th scope="col">LAST LOGIN AT</th>
                             <th scope="col">EMAIL</th>
                             <th scope="col">PHONE</th>
                             <th scope="col">SIGNATURE</th>
                             <th scope="col">ORGANIZATION ID</th>
                             <th scope="col">TAGS</th>
                             <th scope="col">SUSPENDED</th>
                             <th scope="col">ROLE</th>
                        </tr>
                     </thead>
                    <tbody>
                        <c:forEach var="submitter" items="${submitters}">
                            <tr>
                                <td>${submitter.id}</td>
                                <td>${submitter.url}</td>
                                <td>${submitter.externalId}</td>
                                <td>${submitter.name}</td>
                                <td>${submitter.alias}</td>
                                <td>${submitter.createdAt}</td>
                                <td>${submitter.active}</td>
                                <td>${submitter.verified}</td>
                                <td>${submitter.shared}</td>
                                <td>${submitter.locale}</td>
                                <td>${submitter.timezone}</td>
                                <td>${submitter.lastLoginAt}</td>
                                <td>${submitter.email}</td>
                                <td>${submitter.phone}</td>
                                <td>${submitter.signature}</td>
                                <td>${submitter.organizationId}</td>
                                <td>${submitter.tags}</td>
                                <td>${submitter.suspended}</td>
                                <td>${submitter.role}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <h2 style="color: #03363d;" class="display-2">Organization related to Tickets</h2>
                <table class="table table-bordered" style="max-width:30%;">
                   <thead class="thead-light">
                       <tr>
                           <th scope="col">ORGANIZATION FIELD</th>
                           <th scope="col">FIELD VALUE</th>
                           <th scope="col">NUMBER OF ORGANIZATIONS</th>
                       <tr>
                   </thead>
                   <tbody>
                       <tr>
                           <td>${field}</td>
                            <td>
                                <c:if test="${empty value}">
                                    NULL
                                </c:if>
                                <c:if test="${not empty value}">
                                    ${value}
                                </c:if>
                            </td>
                           <td>${organizationsCount}</td>
                       </tr>
                   </tbody>
               </table>
                <table class="table table-striped table-bordered">
                    <thead class="thead-light">
                        <tr>
                            <th>ORGANIZATION ID</th>
                            <th>URL</th>
                            <th>EXTERNAL ID</th>
                            <th>NAME</th>
                            <th>DOMAIN NAMES</th>
                            <th>CREATED_AT</th>
                            <th>DETAILS</th>
                            <th>SHARED_TICKETS</th>
                            <th>TAGS</th>
                        </tr>
                    </thead>
                    <tbody>
                       <c:forEach var="organization" items="${organizations}">
                           <tr>
                               <td>${organization.id}</td>
                               <td>${organization.url}</td>
                               <td>${organization.externalId}</td>
                               <td>${organization.name}</td>
                               <td>${organization.domainNames}</td>
                               <td>${organization.createdAt}</td>
                               <td>${organization.details}</td>
                               <td>${organization.sharedTickets}</td>
                               <td>${organization.tags}</td>
                           </tr>
                        </c:forEach>
                    </tbody>
               </table>
            </div>
        </div>
        <script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>
