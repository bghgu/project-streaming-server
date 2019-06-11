<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>

<!-- Head -->
<c:import url="common/head.jsp"/>

<body>
<input class="btn btn-default" type="button" value="index" onClick="location.href='/'">
<video controls src="/download?fileName=${fileName}">
    not use video
</video>
</body>
</html>