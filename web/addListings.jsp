<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 5/7/2016
  Time: 1:09 PM
  To change this template use File | Settings | File Templates.
--%>

<div class="col-xs-12 col-md-8" id="yourListing">
    <h3 class="container-heading">Add Listings</h3>
    <form class="form-inline"
          action="/verifyListing"
          method="get">
        <div class="form-group form-group-sm ">
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
        </div>
        <button type="submit" class="btn btn-default">Verify</button>
    </form>
    </br>
    <c:import url="verifyListing.jsp"/>

</div>