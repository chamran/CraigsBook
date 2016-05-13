<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid text-center">
    <div>
        <h3>Start Messaging To Get A Book</h3>
    </div>
</div>
</br>
</br>
<c:choose>
    <c:when test="${myContacts.size() > 0}">
        <c:forEach var="contact" items="${myContacts}">
            <div class="container-fluid text-center">
                <div class="row content" >
                    <div class="col-sm-2 col-sm-offset-5">
                        <div class="table-responsive">
                            <table class="table table-condensed">
                            <td>
                                <form class="form-inline"
                                      action="/deleteContact"
                                      method="post">
                                    <div class="form-group-sm textAlignRight">
                                        <button type="submit" class="btn btn-default asText" >x</button>
                                        <input type="hidden" value="${contact.contactId}" name="contactId">
                                    </div>
                                </form>
                            </td>
                            <td style="">
                                <form class="form-inline"
                                      action="GetMessage"
                                      method="post">
                                    <div class="form-group-sm">
                                        <button type="submit" class="btn btn-default asText" >${contact.listingWantedBy}</button>
                                        <input type="hidden" value="${contact.contactId}" name="contactId">
                                    </div>
                                </form>
                            </td>
                        </table>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </c:when>
</c:choose>
<div class="container-fluid text-center">
    <div class="row content" >
        <form class="form-inline"
              action="/postMessage"
              method="post">
            <div class="form-group-sm">
                <button type="submit" class="btn btn-default">Send</button>
                <input type="text" class="form-control" name="message">
                <input type="hidden" value="${contactId}" name="contactId">
            </div>
        </form>
    </div>
</div>
<div class="container-fluid text-center">
    <div class="row content" >
        <c:choose>
            <c:when test="${messages.size() > 0}">
                <c:forEach var="message" items="${messages}">
                    <p>${message.userName}:&nbsp${message.userMessage}</p>
                </c:forEach>
            </c:when>
        </c:choose>
    </div>
</div>
