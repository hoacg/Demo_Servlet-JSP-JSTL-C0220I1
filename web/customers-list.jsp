<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:layout>

    <jsp:attribute name="header">
      <h1>Customers</h1>
    </jsp:attribute>
    <jsp:attribute name="footer">
      <p id="copyright">CodeGym.vn</p>
    </jsp:attribute>

    <jsp:body>
        <table class="table">
            <tr>
                <td>Thứ tự</td>
                <td>Họ tên</td>
                <td></td>
            </tr>
            <c:forEach items="${customers}" var="customer">
                <tr>
                    <td></td>
                    <td>
                        <c:out value="${customer.getName()}"></c:out>
                    </td>
                    <td>
                        <a href="./customers?command=delete&id=${customer.getId()}">Xoá</a>
                    </td>
                </tr>

            </c:forEach>
        </table>
    </jsp:body>

</t:layout>
