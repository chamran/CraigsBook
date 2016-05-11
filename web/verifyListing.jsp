<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="text">
    <c:choose>
        <c:when test="${listingData.resultsFound != true}">

            <p>
            <table class="table table-striped">
                <tr>
                    <th>Instructor Name</th>
                    <th>Course</th>
                    <th>Book Title</th>
                    <th>Book Author</th>
                    <th>Isbn</th>
                    <th>Price $</th>
                </tr>

                <tr>
                    <td>${listingData.instructor}</td>
                    <td>${listingData.course}</td>
                    <td>${listingData.bookTitle}</td>
                    <td>${listingData.bookAuthor}</td>
                    <td>${listingData.isbn}</td>
                    <td>${listingData.price}</td>

                </tr>


            </table>
            </p>
        </c:when>
        <c:otherwise>
            <h4>No Results Found</h4>
        </c:otherwise>
    </c:choose>
</div>