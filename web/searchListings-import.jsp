<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="searchListings" value="${searchListings}" scope="request" />

<div class="container-fluid text-center" id="yourListing">
    <br class="row content" >
    <h3>Search For Other People's Listings</h3>
    </br>
    <form class="form-inline"
          action="/getListing"
          method="get">
        <div class="form-group form-group-sm">
            <label for="searchTerm">Search Term</label>
            <input type="text" class="form-control" name="searchTerm"  id="searchTerm">
            <input type="submit" class="btn btn-default" name="" value="Enter" />
            </br>
            <label class="radio-inline"><input type="radio" name="searchType" value="instructor">Instructor Last Name</label>
            <label class="radio-inline"><input type="radio" name="searchType" value="course">Course</label>
            <label class="radio-inline"><input type="radio" name="searchType" value="isbn">Isbn</label>
        </div>
    </form>
    <c:choose>
        <c:when test="${requestScope.searchListings.size() > 0}">
            </br>
            <c:choose>
                <c:when test="${bookTitle != NULL}">
                    <h5>${bookTitle} was added to the messaging center!</h5>
                </c:when>
            </c:choose>
            </br>
            <div class="col-md-10 col-md-offset-1">
                <div class="table-responsive">
                    <table class="table table-condensed">
                        <tr>
                            <th></th>
                            <th>Price</th>
                            <th>Title</th>
                            <th>Author</th>
                            <th>Isbn</th>
                            <th>Instructor</th>
                            <th>Course</th>
                        </tr>
                        <c:forEach var="listing" items="${requestScope.searchListings}">
                            <tr>
                                <form class="form-horizontal"
                                      action="/postContact"
                                      method="post">
                                    <td>
                                        <button type="submit" class="asText">add</button>
                                        <input type="hidden" value="${listing.listingId}" name="listingId">
                                        <input type="hidden" value="${listing.bookTitle}" name="bookTitle">
                                        <input type="hidden" value="${listing.userName}" name="userName">
                                    </td>
                                    <td>$${listing.price}</td>
                                    <td>${listing.bookTitle}</td>
                                    <td>${listing.bookAuthor}</td>
                                    <td>${listing.isbn}</td>
                                    <td>${listing.instructorFirstName}&nbsp${listing.instructorFirstName}</td>
                                    <td>${listing.course}</td>
                                </form>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </c:when>
        <c:when test="${noResultsFound}">
            <h3>No Results Found</h3>
        </c:when>
        <c:otherwise>

        </c:otherwise>
    </c:choose>
</div>
