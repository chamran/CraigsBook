
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid text-center" id="yourListing">
    <div class="row content">
    <h3 class="container-heading">Add A Listing Of Your Own</h3>
    </br>
    <form class="form-inline"
          action="/postListing"
          method="post">
        <div class="form-group-sm ">
            <label>Instructor</label>
            <label class="sr-only" for="firstName">Instructor</label>
            <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First Name">
            <label class="sr-only" for="lastName">Instructor</label>
            <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last Name">
            <label for="course">Course</label>
            <input type="text" class="form-control" id="course" name="course"/>
            <label for="isbn">Isbn</label>
            <input type="text" class="form-control" id="isbn" name="isbn"  size = "13" maxlength="13" placeholder="ex. 143024626X">
            <label for="price">Price $</label>
            <input type="text" class="form-control" id="price" name="price" size="2" maxlength="6" placeholder="999.99">
        <button type="submit" class="btn btn-default">Add</button>
        </div>
    </form>
    </br>
</div>
<div id="text">
    <c:choose>
        <c:when test="${badIsbn}">
            <h4>problem with isbn #</h4>
        </c:when>
        <c:when test="${myListings.size() > 0}">
            <div class="col-md-10 col-md-offset-1">
            <p>
            <div class="table-responsive">
            <table class="table table-condensed">
                <tr>
                    <th></th>
                    <th>Instructor Name</th>
                    <th>Course</th>
                    <th>Book Title</th>
                    <th>Book Author</th>
                    <th>Isbn</th>
                    <th>Price $</th>
                </tr>
                <c:forEach var="listing" items="${myListings}">
                <tr>
                    <td>
                        <form class="form-inline"
                              action="/deleteListing"
                              method="post">
                            <button type="submit" class="asText" >remove</button>
                            <input type="hidden" value="${listing.listingId}" name="listingId">
                        </form>
                    </td>
                    <td>${listing.instructorFirstName}&nbsp${listing.instructorLastName}</td>
                    <td>${listing.course}</td>
                    <td>${listing.bookTitle}</td>
                    <td>${listing.bookAuthor}</td>
                    <td>${listing.isbn}</td>
                    <td>${listing.price}</td>
                </tr>
                </c:forEach>
            </table>
            </div>
            </p>
            </div>
        </c:when>
        <c:otherwise>
            <h4>You Have No Listings</h4>
        </c:otherwise>
    </c:choose>
</div>
</div>