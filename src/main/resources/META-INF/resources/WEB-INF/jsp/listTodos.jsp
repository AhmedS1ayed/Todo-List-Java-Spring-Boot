<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <%@ include file="common/header.jspf"%>
    <body>
            <%@ include file="common/navigation.jspf"%>
            <div class="container" >
                <h1>Welcome ${name}</h1>
                    <table class = "table table-hover table-dark">
                        <caption>Your Todos</caption>
                        <thead>
                        <tr>
<%--                            <th>Id</th>--%>
                            <th>Description</th>
                            <th>Target Date</th>
                            <th>Is Done?</th>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${todos}" var="todo">
                            <c:if test = "${todo.isDone()}">
                            <tr class="table-success">
<%--                                <td>${todo.getId()}</td>--%>
                                <td>${todo.getDescription()}</td>
                                <td>${todo.getDate()}</td>
                                <td>${todo.isDone()}</td>
                                <td><a href = "delete-todo?id=${todo.getId()}" class="btn btn-warning">DELETE</a></td>
                                <td><a href = "update-todo?id=${todo.getId()}" class = "btn btn-success">UPDATE</a></td>
                            </tr>
                            </c:if>
                            <c:if test = "${!todo.isDone()}">
                                <tr class="table-danger">
<%--                                    <td>${todo.getId()}</td>--%>
                                    <td>${todo.getDescription()}</td>
                                    <td>${todo.getDate()}</td>
                                    <td>${todo.isDone()}</td>
                                    <td><a href = "delete-todo?id=${todo.getId()}" class="btn btn-warning">DELETE</a></td>
                                    <td><a href = "update-todo?id=${todo.getId()}" class = "btn btn-success">UPDATE</a></td>
                                </tr>
                            </c:if>
                        </c:forEach>
                        </tbody>
                    </table>

                    <a href = "add-todo" class="btn btn-success">Add Todo</a>
            </div>
<%--        <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>--%>
<%--        <script src="webjars/jquery/3.6.0/jquery.min.js"></script>--%>
    </body>
    <%@ include file="common/footer.jspf"%>
</html>