
<%@ include file= "common/header.jspf"%>
<%@ include file= "common/navigation.jspf"%>





    <div class="container">

        <h1>Your  Todos  </h1>
        <table class="table">
            <thead>
                <tr>
                    <th>id</th>
                    <th>description</th>
                    <th>Target Date </th>
                    <th>Is Done</th>
                </tr>

            </thead>
            <tbody>
                <c:forEach items="${todos}" var="todos">
                    <tr>
                        <td>${todos.id}</td>
                        <td>${todos.description}</td>
                        <td>${todos.targetDate}</td>
                        <td>${todos.done}</td>
                        <td><a href="delete-todo?id=${todos.id}" class="btn btn-warning" style= "margin-right:5px;" colour="Red">Delete</a>
                        <a href="update-todo?id=${todos.id}" class="btn btn-success" >Update </a></td>


                    </tr>

                </c:forEach>

            </tbody>
        </table>
        <a href="add-todo" class="btn btn-success"> Add Todos</a>

    </div>
 <%@ include file= "common/footer.jspf"%>