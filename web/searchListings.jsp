<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 5/7/2016
  Time: 1:09 PM
  To change this template use File | Settings | File Templates.
--%>

<div class="col-xs-12 col-md-8" id="yourListing">
    <h3>Search Listings</h3>
    <form class="form-inline">
        <div class="form-group">
            <label for="searchTerm">Search Term</label>
            <input type="text" class="form-control" id="searchTerm">
            <input type="submit" class="btn btn-default" name="" value="Enter" />
            </br>
            <label class="radio-inline"><input type="radio" name="searchRadio" value="instructor">Instructor Last Name</label>
            <label class="radio-inline"><input type="radio" name="searchRadio" value="course">Course</label>
            <label class="radio-inline"><input type="radio" name="searchRadio" value="isbn">Isbn</label>
        </div>
    </form>
    <c:choose>
        <c:when test="${true}">
            <c:choose>
                <c:when test="${true}">
                    <h4>Search Results</h4>

                    <div class="table-responsive">
                        <table class="table">

                            <tr>
                                <th></th>
                                <th>Instructor</th>
                                <th>Course</th>
                                <th>Title</th>
                                <th>Author</th>
                                <th>Isbn</th>
                                <th>Price</th>

                            </tr>

                            <c:forEach var="listing" items="${project4Search.results}">
                                <tr>
                                    <form class="form-horizontal"
                                          action="/addContact"
                                          method="post">
                                        <td>
                                            <button type="submit" >add</button>
                                            <input type="hidden" value="${listing.listingId}" name="listingId">
                                            <input type="hidden" value="${listing.title}" name="title">
                                        </td>
                                        <td>${listing.instructor}</td>
                                        <td>${listing.course}</td>
                                        <td>${listing.title}</td>
                                        <td>${listing.author}</td>
                                        <td>${listing.isbn}</td>
                                        <td>${listing.price}</td>
                                    </form>
                                </tr>
                            </c:forEach>
                            </tr>
                        </table>
                    </div>

                </c:when>
                <c:otherwise>
                    <h3>No Results Found</h3>
                </c:otherwise>
            </c:choose>
        </c:when>
        <c:otherwise>
        </c:otherwise>
    </c:choose>
</div>