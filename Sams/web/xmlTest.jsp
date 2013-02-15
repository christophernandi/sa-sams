

<html>
<head>
    <script type="text/javascript">
        function loadXML() {
            var files = document.getElementById("data").files;
            document.write(files.value);
            window.alert(document.getElementById("data").value);
            if (!files.length) {
                alert('Please select a file!');
                return;
            }

            var file = files[0];
            if (file) {
                var reader = new FileReader();
            } else {
                window.alert("Failed to load File");
            }
            var docElement = xmlhttp.responseXML.documentElement;


        }

        var ie = (typeof window.ActiveXObject != 'undefined');
        var moz = (typeof document.implementation != 'undefined') &&
                (typeof document.implementation.createDocument != 'undefined');
        var xmlDoc;
        function importXML(file) {
            if (moz) {
                xmlDoc = document.implementation.createDocument("", "doc", null);
                xmlDoc.onload = readXML;
                xmlDoc.load(file);
            } else if (ie) {
                xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
                xmlDoc.async = false;
                while (xmlDoc.readyState != 4) {
                }
                ;
                xmlDoc.load(file);
                readXML();
            }
        }

        importXML("myFileName.xml");

        function readXML() {
            root = xmlDoc.documentElement;
// now do whatever you like with it!
        }


        //        xmlDoc=loadXMLDoc("books.xml");
        //
        //        x=xmlDoc.getElementsByTagName("title");
        //
        //        for (i=0;i<x.length;i++)
        //        {
        //            document.write(x[i].childNodes[0].nodeValue);
        //            document.write("
        //            ");
        //        }

    </script>
</head>
<body>
<p>Select a file:
    <input type="file" id="data"/>
    <a href="#" onclick="loadXML()">Load</a>
</p>

</body>
</html>

<%--text="<bookstore><book>";--%>
<%--text=text+"<title>Everyday Italian</title>";--%>
<%--text=text+"<author>Giada De Laurentiis</author>";--%>
<%--text=text+"<year>2005</year>";--%>
<%--text=text+"</book></bookstore>";--%>

<%--xmlDoc=loadXMLString(text);--%>

<%--document.write(xmlDoc.getElementsByTagName("title")[0].childNodes[0].nodeValue);--%>
<%--document.write("<br>");--%>
<%--document.write(xmlDoc.getElementsByTagName("author")[0].childNodes[0].nodeValue);--%>
<%--document.write("<br>");--%>
<%--document.write(xmlDoc.getElementsByTagName("year")[0].childNodes[0].nodeValue);--%>
<%--</script>--%>