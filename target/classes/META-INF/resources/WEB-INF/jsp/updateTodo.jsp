<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<%@ include file="common/header.jspf"%>

<body>
<%@ include file="common/navigation.jspf"%>
<div class="container">
    <h1>Enter Todo Details :</h1>

    <form:form action = "/update-todo" method="post" modelAttribute="todo">
        <label for="description">Description : </label><br>
        <form:input type="text" path="description" id ="description" required="required"/><br>
        <form:errors path = "description" cssClass="text-warning"/><br>

        <label for="done">Done?</label><br>
        <form:checkbox path="done" value="${todo.isDone()}" id ="done"/><br>


        <form:input type="hidden" path="id" id ="id" required="required"/><br>
        <input type="submit" class="btn btn-success" id ="submit">
    </form:form>
</div>
</body>
<%@ include file="common/footer.jspf"%>
</html>