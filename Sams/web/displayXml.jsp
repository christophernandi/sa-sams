<html>
<head>
    <script type="text/javascript">
        function loadXMLDoc()
        {
            if (window.XMLHttpRequest)
            {// code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp=new XMLHttpRequest();
            }
            else
            {// code for IE6, IE5
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange=function()
            {
                if (xmlhttp.readyState==4 && xmlhttp.status==200)
                {
                    xmlDoc=xmlhttp.responseXML;
                    var txt="";
                    x=xmlDoc.getElementsByTagName("TITLE");
                    y=xmlDoc.getElementsByTagName("ARTIST");
                    z=xmlDoc.getElementsByTagName("COUNTRY");

                    alert(x);
                    for (i=0;i<x.length;i++)
                    {
                        txt=txt + x[i].childNodes[0].nodeValue +" ";
                        txt=txt + y[i].childNodes[0].nodeValue +" ";
                        txt=txt + z[i].childNodes[0].nodeValue +"<br />";
                    }
                    document.getElementById("myDiv").innerHTML=txt;
                }
            }
            xmlhttp.open("GET","/home/magwa/roseindia.xml",true);
            xmlhttp.send();
        }
    </script>
</head>

<body>

<h2>My CD Collection:</h2>
<div id="myDiv"></div>
<button type="button" onClick="loadXMLDoc()">Get my CD collection</button>

</body>
</html>