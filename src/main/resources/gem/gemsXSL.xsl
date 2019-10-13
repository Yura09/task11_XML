<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body style="font-family: Arial; font-size: 14pt; background-color: #EEE">
                <div style="background-color: green; color: white;">
                    <h2 style=" text-align: center">GEMS</h2>
                </div>
                <style>
                    table {
                    width: 900px;
                    height: 400px;
                    border: 1px solid green;
                    margin: auto;

                    }
                    td {
                    text-align: center;
                    }
                </style>
                <table border="3">
                    <tr bgcolor="#2E9AFE">
                        <big>
                        <th>id</th>
                        <th>name</th>
                        <th>preciousness</th>
                        <th>origin</th>
                        <th>color</th>
                        <th>transparency</th>
                        <th>engraving</th>
                        <th>value</th>
                        </big>
                    </tr>

                    <xsl:for-each select="gems/gem">
                        <tr>
                            <td><xsl:value-of select="@id" /></td>
                            <td><xsl:value-of select="name"/></td>
                            <td><xsl:value-of select="preciousness"/></td>
                            <td><xsl:value-of select="origin"/></td>
                            <td><xsl:value-of select="visual/color"/></td>
                            <td><xsl:value-of select="visual/transparency"/>
                                <xsl:text> %</xsl:text></td>
                            <td><xsl:value-of select="visual/engraving"/></td>
                            <td><xsl:value-of select="value"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>