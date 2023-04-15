<%--
  Created by IntelliJ IDEA.
  User: darkp
  Date: 14-04-2023
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Notes</title>
    <%@include file="all_js_css.jsp"%>
</head>
<body>
<div class="container">
    <%@include file="navbar.jsp"%>
    <br>
    <h2>Please fill your note detail</h2>
    <br>
    <form action="SaveNoteServlet" method="post">

        <div class="form-group">
            <label for="title">Note title</label>
            <input name="title" required type="text" class="form-control" id="title" aria-describedby="emailHelp" placeholder="Enter your task title">
        </div>

        <div class="form-group">
            <label for="content">Content</label>
            <textarea
                    name="content"
                    required
                    id="content"
                    placeholder="Enter your content here"
                    class="form-control"
                    style="hight:300px"
            ></textarea>
        </div>
        <div class="container text-centre">
            <button type="submit" class="btn btn-primary">Add</button>
        </div>

    </form>

</div>
</body>
</html>
