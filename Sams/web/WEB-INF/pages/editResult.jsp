<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>


<body>

    <s:form commandName="extendedClass" method="POST">
        <table>
            <tr>
                <td>First Name</td>
                <td>${addEditCustomerParameters.firstName}</td>
            </tr>

            <tr>
                <td>Last Name</td>
                <td>${addEditCustomerParameters.lastName}</td>
            </tr>

            <tr>
                <td>Phone Number</td>
                <td><${addEditCustomerParameters.phoneNumber}</td>
            </tr>

            <tr>
                <td>Postal Code</td>
                <td>${addEditCustomerParameters.postaCode}</td>
            </tr>

            <tr>
                <td>Test </td>
                <td><s:input path="testField"/></td>
            </tr>

            <tr>
                <td>><a href="editResult.do?id=0" class="button">Save</a></td>


            </tr>
        </table>
        
    </s:form>

</body>
</html>