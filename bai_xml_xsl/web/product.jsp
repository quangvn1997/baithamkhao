<%--
  Created by IntelliJ IDEA.
  User: Quang
  Date: 4/23/2018
  Time: 6:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/xml;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml-stylesheet type="text/xsl" href="/product.xsl"?>
<products>
    <c:forEach var="product" items="${products}">
        <product>
            <ProductID>${product.productID}</ProductID>
            <ProductName>${product.productName}</ProductName>
            <supplierID>${product.supplierID}</supplierID>
            <categoryID>${product.categoryID}</categoryID>
            <quantityPerUnit>${product.quantityPerUnit}</quantityPerUnit>
            <unitPrice>${product.unitPrice}</unitPrice>
            <unitsInStock>${product.unitsInStock}</unitsInStock>
            <unitsOnOrder>${product.unitsOnOrder}</unitsOnOrder>
            <reorderLevel>${product.reorderLevel}</reorderLevel>
            <discontinued>${product.discontinued}</discontinued>
        </product>
    </c:forEach>
</products>
