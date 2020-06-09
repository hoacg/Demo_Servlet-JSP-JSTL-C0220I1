<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:layout>


    <jsp:body>

        <form action="/cart" method="post">

            <input type="text" name="id" placeholder="Product Id Here"/>
            <button type="submit">Add To Cart</button>

        </form>

        <table class="table">
            <tr>
                <td>Thứ tự</td>
                <td>Tên sản phẩm</td>
                <td>Giá</td>
                <td>Số lượng</td>
                <td></td>
            </tr>
            <c:forEach items="${cart}" var="cartItem" varStatus="loop">
                <tr>
                    <td>
                        <c:out value="${loop.index + 1}"></c:out>
                    </td>
                    <td>
                        <c:out value="${cartItem.getProduct().getName()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${cartItem.getProduct().getPrice()}"></c:out>
                    </td>
                    <td>
                        <input type="text" name="quantity"
                               value="<c:out value='${cartItem.getQuantity()}'></c:out>"
                        />
                    </td>
                    <td>
                        <a href="./cart?command=delete&id=${product.getId()}">Xoá</a>
                    </td>
                </tr>

            </c:forEach>
        </table>

    </jsp:body>

</t:layout>
