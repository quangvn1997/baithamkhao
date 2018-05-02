<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body style="font-family:Arial;font-size:12pt;background-color:#EEEEEE">
                <h2>Display data</h2>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th>ProductID</th>
                        <th>ProductName</th>
                        <th>SupplierID</th>
                        <th>CategoryID</th>
                        <th>QuantityPerUnit</th>
                        <th>UnitPrice</th>
                        <th>UnitsInStock</th>
                        <th>UnitsOnOrder</th>
                        <th>ReorderLevel</th>
                        <th>Discontinued</th>
                    </tr>
                    <xsl:for-each select="products/product">
                        <tr>
                            <td>
                                <xsl:value-of select="ProductID"/>
                            </td>
                            <td>
                                <xsl:value-of select="ProductName"/>
                            </td>
                            <td>
                                <xsl:value-of select="supplierID"/>
                            </td>
                            <td>
                                <xsl:value-of select="categoryID"/>
                            </td>
                            <td>
                                <xsl:value-of select="quantityPerUnit"/>
                            </td>
                            <td>
                                <xsl:value-of select="unitPrice"/>
                            </td>
                            <td>
                                <xsl:value-of select="unitsInStock"/>
                            </td>
                            <td>
                                <xsl:value-of select="unitsOnOrder"/>
                            </td>
                            <td>
                                <xsl:value-of select="reorderLevel"/>
                            </td>
                            <td>
                                <xsl:value-of select="discontinued"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>