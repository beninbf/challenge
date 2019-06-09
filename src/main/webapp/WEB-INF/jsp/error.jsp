<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
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
    <head>
        <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
        <c:url value="/css/main.css" var="jstlCss" />
        <link href="${jstlCss}" rel="stylesheet" />
    </head>
    <body>
        <div class="container">
            <a href="/" class="zendesk-logo"></a>
            <div class="navbar-header">
                <a class="navbar-brand" style="padding: 15px 0;" href="/">Start Page</a>
            </div>
        </div>
        <div class="container">
            <div class="starter-template">
                <h1 style="color: #03363d;" class="display-2">AN ERROR HAS OCCURED</h1>
            </div>
        </div>
        <script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>

