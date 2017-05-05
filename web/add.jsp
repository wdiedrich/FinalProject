<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add A Customer</title>
        <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
    <body>
        <div class="wrap">

            <%@ include file="includes/header.jsp" %>
            <%@ include file="includes/menu.jsp" %>
            <h1>Add A Customer</h1>

            <div class="main">
                <form name="addForm" action="addCustomer" method="get">

                    <label>First Name:</label>
                    <br>
                    <input type="text" name="fname" value="" />
                    <br>
                    <label>Last Name</label>
                    <br>
                    <input type="text" name="lname" value="" />
                    <br>
                    <label>Address 1</label>
                    <br>
                    <input type="text" name="addr1" value="" />
                    <br>
                    <label>Address 2:</label>
                    <br>
                    <input type="text" name="addr2" value="" />
                    <br>
                    <label>City:</label>
                    <br>
                    <input type="text" name="city" value="" />
                    <br>
                    <label>State:</label>
                    <br>
                    <input type="text" name="cState" value="" />
                    <br>
                    <label>Zip:</label>
                    <br>
                    <input type="text" name="zip" value="" />
                    <br>
                    <label>Email</label>
                    <br>
                    <input type="text" name="email" value="" />
                    <br><br>

                    <input type="reset" name="reset" value="Clear" />
                    <input type="submit" name="submit" value="Submit" />
                </form>
            </div> 

            <%@ include file="includes/footer.jsp" %>


        </div>
    </body>
</html>
