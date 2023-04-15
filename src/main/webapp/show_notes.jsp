<%@ page import="org.hibernate.Session" %>
<%@ page import="com.helper.FactoryProvider" %>
<%@ page import="org.hibernate.query.Query" %>
<%@ page import="com.notes.Note" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: darkp
  Date: 14-04-2023
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Notes</title>
    <%@include file="all_js_css.jsp"%>
</head>
<body>
<div class="container">
    <%@include file="navbar.jsp"%>
    <br>
    <h2>All Notes: </h2>
    <br>


    <div class="row">
        <div class="col-12">
            <%
                Session session1= FactoryProvider.getFactory().openSession();
                Query q = session1.createQuery("from Note");
                List<Note> list = q.list();

                for(Note note:list)
                {
            %>

            <div class="card mt-3">
                <img class="card-img-top" style="max-width: 35px" src="image/comment.png" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title"><% out.println(note.getTitle());%></h5>
                    <p class="card-text"><%out.println(note.getContent());%></p>
                    <div class="container text-center">
                        <a href="DeleteServlet?note_id=<%=note.getId()%>" class="btn btn-danger">Delete</a>
                        <a href="#" class="btn btn-primary">Update</a>
                    </div>

                </div>
            </div>

            <%
                }
                session1.close();
            %>
        </div>
    </div>


</div>
</body>
</html>
