<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>

    <!-- Head -->
    <c:import url="common/head.jsp"/>

    <body>

        <!-- Main -->
        <div id="main-wrapper">
            <div class="container">

                <!-- Content -->
                <article class="box post">
                    <header>
                        <h2>List</h2>
                    </header>

                    <table class="table">
                        <thead>
                        <tr>
                            <th>Directory</th>
                            <th>Title</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="content" items="${contents}">
                            <tr>
                                <td>${content.directory}</td>
                                <td onClick="location.href='/view?title=${content.title}'" style="cursor:pointer;">${content.title}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </article>

            </div>
        </div>

    </body>
</html>