

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <c:set var="listingData" value="Employee Search" scope="request"/>
    <c:import url="head.jsp"/>

    <body>
        <div class="container-fluid">
            <div class="row">

            <c:import url="messaging.jsp"/>

            <c:import url="addListings.jsp"/>

            <c:import url="searchListings.jsp"/>

            </div>
        </div>

    </body>
</html>
