<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Dream Cars Database</title>
        <link rel="stylesheet" type="text/css" href="style.css" />
    </head>

    <% String table = (String) request.getAttribute("table");%>

    <body>
        <div class="wrap">
            
            <%@ include file="includes/header.jsp" %>
            <%@ include file="includes/menu.jsp" %>
            <h1>View Customers</h1>
            
            <div class="main">
                <%=table%>
            </div>


            <%@ include file="includes/footer.jsp" %>
        </div>
    </body>
</html>
