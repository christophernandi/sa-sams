<%@ page import="za.co.sasams.dto.AddEditCustomerParameters" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="../../scripts/jquery-1.9.1.js">
        $(document).ready(function () {
            $.ajax({
                type:"GET",
                url:"jquery_xml.xml",
                dataType:"xml",
                success:parseXml
            });
        });
    </script>
    <script type="text/javascript">
        function parseXml(xml) {
            //find every Tutorial and print the author
            $(xml).find("Tutorial").each(function () {
                        $("#output").append($(this).attr("TITLE") + "<br />");
                          document.writeln("1");
                    }

            );
        }
        function loadXMLDoc() {
            var xml = document.getElementById("files");
            parseXml(xml);
        }
    </script>
</head>
<body>
<p>Select a file:
    <input type="file" id="data"/>
    <a href="#" onclick="loadXMLDoc()">Load</a>
</p>
<div id="output"></div>


</body>
</html>