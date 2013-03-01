<html>
<head>
    <style>
        #editor {
            border: 1px solid black;
            height: 250px;
            margin: 15px;
            padding: 10px;
            overflow: scroll;
        }
    </style>
    <script type="text/javascript">
        function load() {
            var finput = document.getElementById("data");
            var editor = document.getElementById("editor");

            var f = finput.files[0];

            if (f) {

                var r = new FileReader();
                r.onloadend = function(w){
                    if(w.target.readyState == FileReader.DONE){
                        window.alert(w.target.result);
                    }
                }
                r.onload = function (e) {
                    editor.innerHTML = e.target.result
                }
                r.readAsText(f);
//                r.readAsArrayBuffer(f);
            } else {
                editor.innerHTML = "Failed to load file"
            }
        }

        function format(c) {
            document.execCommand(c, false, false);
        }
    </script>
    <%--    <script type="text/javascript">
        function loadXml(){
            XML xmlDoc
            var group=xmlDoc.getElementsByTagName("group");

            for(var i=0; i<group.length; i++)
            {
                var groupName = group[i].getElementsByTagName("groupName");
                var groupNam = groupName[0].childNodes[0].nodeValue;

                document.write(groupNam + "<br/>");

                var word=group[i].getElementsByTagName("word")

                for(var j=0; j<word.length; j++)
                {
                    var w = word[j].childNodes[0].nodeValue;
                    document.write("!" + w);
                }

            }
        }
    </script>--%>
<%--
    <script type="text/javascript">
        if (window.XMLHttpRequest) {
            xhttp = new XMLHttpRequest();
        }
        else // IE 5/6
        {
            xhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xhttp.open("GET", "books.xml", false);
        xhttp.send();
        xmlDoc = xhttp.responseXML;
    </script>--%>

</head>
<body>

<h3>HTML File Reader Test</h3>

<p>Select a file:
    <input type="text" value="0" onchange="loadXML()"/>
    <input type="file" id="data"/>
    <a href="#" onclick="load()">Load</a>


</p>

<p>
    <a href="#" onclick="format('bold')">Bold</a>
    <a href="#" onclick="format('italic')">Italic</a>
    <a href="#" onclick="format('underline')">Underline</a>
</p>

<div id="editor" contentEditable="true"></div>
</body>
</html>