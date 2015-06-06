<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Employee Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
    <script type="text/javascript">

        function validateEmail(inputText)
        {
        //    alert(inputText);
            var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
            if(inputText.value.match(mailformat))
            {
            //   document.employeeForm.text1.focus();
                return true;
            }
            else
            {
                alert("You have entered an invalid email address!");
                document.employeeForm.emailid.focus();
                document.getElementById("emailid").focus();
                return false;
            }
        }



    </script>

</head>
<body>


<h1>
Employee
</h1>

<c:url var="addAction" value="/employee/add" ></c:url>

<form:form action="${addAction}" commandName="employee" id="employeeForm">
<table>
	<c:if test="${!empty employee.id}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="employeeName">
				<spring:message text="Employee Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="employeeName" />
		</td> 
	</tr>
   

	<tr>
		<td>

			<form:label path="designation">
				<spring:message text="Designation"/>
			</form:label>
		</td>
		<td>
            <form:select path="designation">
                <form:option value="Java Developer">Java Developer</form:option>
                <form:option value="Project Manager">Project Manager</form:option>
                <form:option value="Designer">Designer</form:option>
                <form:option value="Analyst">Analyst</form:option>
            </form:select>
			
		</td>
	</tr>
<tr>
		<td>
			<form:label path="salary">
				<spring:message text="Salary"/>
			</form:label>
		</td>
		<td>
			<form:input path="salary" />
		</td> 
	</tr>
 
 <tr>
        <td>
            <form:label path="emailId">
                <spring:message text="Employee Email iD"/>
            </form:label>
        </td>
        <td>
            <form:input path="emailId" id="emailid" onblur = "validateEmail(this)" />
        </td>
    </tr>

 
	<tr>
		<td colspan="2">
			<c:if test="${!empty employee.employeeName}">
				<input type="submit"
					value="<spring:message text="Edit Employee"/>" />
			</c:if>
			<c:if test="${empty employee.employeeName}">
				<input type="submit"
					value="<spring:message text="Add Employee"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Employee List</h3>
<c:if test="${!empty listEmployees}">
	<table class="tg">
	<tr>
		<th width="80">Employee ID</th>
		<th width="120">Employee Name</th>
        <th width="120">Employee Email</th>
		<th width="120">Employee Designation</th>
        <th width="120">Employee Salary</th>
        
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listEmployees}" var="employee">
		<tr>
			<td>${employee.id}</td>
			<td>${employee.employeeName}</td>
            <td>${employee.emailId}</td>
			<td>${employee.designation}</td>
            <td>${employee.salary}</td>
            
			<td><a href="<c:url value='/editEmployee/${employee.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/removeEmployee/${employee.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
