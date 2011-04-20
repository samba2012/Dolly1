<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<html>
<head>
<script type="text/javascript">	
		$(document).ready(function() {
		alert("hello");
			$("#msgid").html("This is Hello World by JQuery");
		
			// check name availability on focus lost
			$('#firstname').blur(function() {
				if ($('#firstname').val()) {	
					makeJASONCall();
				}
			});

		function makeJASONCall() {
			$.getJSON("ajax1.htm", { name: $('#firstname').val() }, function(data) {
				alert(data.firstname);
				$("#firstname").val(data.firstname);
			});
		}
	</script>

    <title> User Details </title>
</head>
<body>
<h2>User Details</h2>
<form:form method="post" action="addUser.htm" >
 
    <table>
    <tr>
        <td><form:label path="firstname">First Name</form:label></td>
        <td><form:input path="firstname" /></td>
    </tr>
    <tr>
        <td><form:label path="lastname">Last Name</form:label></td>
        <td><form:input path="lastname" /></td>
    </tr>
    <tr>
        <td><form:label path="lastname">Email</form:label></td>
        <td><form:input path="email" /></td>
    </tr>
    <tr>
        <td><form:label path="lastname">Telephone</form:label></td>
        <td><form:input path="telephone" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Add User"/>
        </td>
    </tr>
</table> 
 
</form:form>
</body>
</html>