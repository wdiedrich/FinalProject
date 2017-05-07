<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="model.Customers"%>
<% Customers c = (Customers) request.getAttribute("c");%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update A Customer</title>
        <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
    <body>
        <div class="wrap">

            <%@ include file="includes/header.jsp" %>
            <%@ include file="includes/menu.jsp" %>
            <h1>Update A Customer</h1>
            <div class="centerText">
                * required
            </div>
            <div class="main">
                <form name="updateForm" action="updateCustomer" method="post">

                    
                    <label>*ID:</label>
                    <br>
                    <input type="text" name="custID" readOnly ="True" value="<%= c.getCustID()%>"/>
                    <br>
                    <label>*First Name:</label>
                    <br>
                    <input type="text" name="fname" value="<%= c.getFirstName()%>" required/>
                    <br>
                    <label>*Last Name</label>
                    <br>
                    <input type="text" name="lname" value="<%= c.getLastName()%>" required/>
                    <br>
                    <label>*Address 1</label>
                    <br>
                    <input type="text" name="addr1" value="<%= c.getAddr1()%>" required/>
                    <br>
                    <label>Address 2:</label>
                    <br>
                    <input type="text" name="addr2" value="<%= c.getAddr2()%>" />
                    <br>
                    <label>*City:</label>
                    <br>
                    <input type="text" name="city" value="<%= c.getCity()%>" required/>
                    <br>
                    <label>*State:</label>
                    <br>
                    <input type="text" name="cState" maxlength="2" value="<%= c.getcState()%>" required/>
                    <br>
                    <label>*Zip:</label>
                    <br>
                    <input type="text" name="zip" maxlength="5" value="<%= c.getZip()%>" required/>
                    <br>
                    <label>Email</label>
                    <br>
                    <input type="email" name="email" value="<%= c.getEmail()%>" />
                    <br><br>

                    <input type="reset" name="reset" value="Clear" />
                    <input type="submit" name="submit" value="Update" />
                </form>
            </div> 

            <%@ include file="includes/footer.jsp" %>


        </div>
    </body>
</html>
