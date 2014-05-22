<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ValentinBlokhin
  Date: 4/21/2014
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<script src="http://code.jquery.com/jquery-1.10.2.min.js" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#test").click(function () {
            $.get("/ajaxtest", function (data, status) {
                alert("Data: " + data + "\nStatus: " + status);
            });
        });
    });
</script>
<body>
<button id="test">Load</button>
</body>
</html>