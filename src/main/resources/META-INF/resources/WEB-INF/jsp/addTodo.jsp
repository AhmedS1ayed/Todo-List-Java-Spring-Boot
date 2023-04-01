<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<%@ include file="common/header.jspf"%>

<body>
<%@ include file="common/navigation.jspf"%>
<div class="container">
    <h1>Enter Todo Details :</h1>

    <form:form action = "/add-todo" method="post" modelAttribute="todo">
        <label for="description">Description : </label><br>
        <form:input type="text" path="description" id ="description" required="required"/><br>
        <form:errors path = "description" cssClass="text-warning"/>
        <form:input type="hidden" path="id" id ="id"/><br>
        <form:input type="hidden" path="done" id ="done"/><br>

        <input type="submit" class="btn btn-success" id ="submit">
    </form:form>
</div>
</body>

<%@ include file="common/footer.jspf"%>
</html>