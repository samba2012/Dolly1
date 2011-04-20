package com.project.web.ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * Servlet implementation class AjaxServlet
 */

public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AjaxServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		
		response.setContentType("application/json");
		String city = request.getParameter("cityName");
		String ajaxName = request.getParameter("ajaxName");
		
		String report = getWeather(city);
		try{
		String jsonValue= getJsonValue(city, report);
		PrintWriter out = response.getWriter();
		System.out.println("jsonValue : "+jsonValue);
		out.println(jsonValue);
		out.flush();
		out.close();
		}catch(Exception e){ }

/*		
 * jsp:
 *    $("#getWeatherReport").click(function(){
      $cityName = document.getElementById("cityName").value;
      $.post("/Dolly/WeatherServlet", {cityName:$cityName}, function(xml) {
     $("#weatherReport").html(
       $("report", xml).text()
     );         
      });
  });
System.out.println("***********");
String city = request.getParameter("cityName");
String report = getWeather(city);
response.setContentType("text/xml");
PrintWriter out = response.getWriter();
out.println("<weather><report>" + report + "</report></weather>");
out.flush();
out.close();
*/
}
	
	private String getJsonValue(String city,String report) throws JSONException{
		JSONObject obj = new JSONObject();
		obj.put("city",city);
		obj.put("report", report);
		
		return obj.toString();
		//return null;
		
	}
private String getWeather(String city) {
String report;

if (city.toLowerCase().equals("chicago"))
    report = "Currently it is not raining in Chicago. Average temperature is 20";
else if (city.toLowerCase().equals("chennai"))
    report = "It’s a rainy season in Chennai now. Better get a umbrella before going out.";
else if (city.toLowerCase().equals("bangalore"))
    report = "It’s mostly cloudy in Bangalore. Good weather for a cricket match.";
else
    report = "The City you have entered is not present in our system. May be it has been destroyed "
            + "in last World War or not yet built by the mankind";
System.out.println(report);
return report;
}

}
