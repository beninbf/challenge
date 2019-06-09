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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
        <c:url value="/css/main.css" var="jstlCss" />
        <link href="${jstlCss}" rel="stylesheet" />
        <script type="text/javascript">
            $(document).ready(function() {
                $("#organizationForm").submit(function(e) {
                  if ($('#organizationField').val() == 'Select') {
                    alert('Your must select a valid field');
                    e.preventDefault(e);
                  }
                });
            });
        </script>
    </head>
    <body>
        <div class="container">
            <a href="/" class="zendesk-logo"></a>
            <div class="navbar-header">
                <a class="navbar-brand" style="padding: 15px 0;" href="/">Back</a>
            </div>
        </div>
       <div class="container">
            <div class="starter-template">
                <h2 style="color: #03363d;" class="display-2">ORGANIZATION SEARCH PAGE</h2>
                 <form id="organizationForm" action="/organization">
                    <table class="table table-striped table-bordered">
                        <thead class="thead-light">
                            <tr>
                                <th scope="col">CHOOSE FIELD</th>
                                <th scope="col">ENTER VALUE</th>
                            <tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <select id="organizationField" name="field">
                                        <option value="Select">Select the Organization Field</option>
                                        <c:forEach var="fieldName" items="${fieldNames}">
                                                <option value="${fieldName}"> ${fieldName} </option>
                                        </c:forEach>
                                    </select>
                                </td>
                                <td>
                                    <input type="text" style="width:200px;" id="value" name="value" placeholder="leave blank for null search"><br>
                                </td>
                            </tr>
                            <tr>
                                <td><button id="submit" style="background-color: #30aabc;" class="btn btn-primary">Submit</button></td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>
