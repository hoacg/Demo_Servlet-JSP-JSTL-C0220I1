<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:layout>

    <jsp:body>
        <table class="table">
            <tr>
                <td>Thứ tự</td>
                <td>Họ tên</td>
                <td></td>
            </tr>
            <c:forEach items="${customers}" var="customer" varStatus="loop">
                <tr>
                    <td>
                        <c:out value="${loop.index + 1}"></c:out>
                    </td>
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
