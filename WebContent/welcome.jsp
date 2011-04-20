<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% response.sendRedirect("ajax.htm"); %>
  
<!--<script type="text/javascript">

$(document).ready(function(){
 $("#msgid").html("This is Hello World by JQuery");
});
       $(document).ready(function() {
              $("#getWeatherReport").click(function(){
                $cityName = document.getElementById("cityName").value;
                $.post("/WeatherServlet", {cityName:$cityName}, function(xml) {
               $("#weatherReport").html(
                 $("report", xml).text()
               );         
                });
            });
        });
</script>-->