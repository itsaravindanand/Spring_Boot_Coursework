<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet">
    <title>Add Todo Page</title>
</head>
<body>
<div class="container">
    <h1>Enter Todo Details</h1>
    <hr>
    <%--@elvariable id="todo" type="com.in28minutes.springboot.myfirstwebapplication.todo.Todo"--%>
    <form:form method="post" modelAttribute="todo">
        <fieldset class="mb-3">
                <%--        label for description field--%>
            <form:label path="description">Description</form:label>
                <%--        Input and path for the description field--%>
            <form:input type="text" path="description" required="required"/>
                <%--        Error management for the description field--%>
            <form:errors path = "description" cssClass="text-warning"></form:errors>
        </fieldset>

        <fieldset class="mb-3">
                <%--        label for Targetdate field--%>
            <form:label path="targetDate">Target Date</form:label>
                <%--        Input and path for the Targetdate field--%>
            <form:input type="text" path="targetDate" required="required"/>
                <%--        Error management for the Targetdate field--%>
            <form:errors path = "targetDate" cssClass="text-warning"></form:errors>
        </fieldset>


        <form:input type="hidden" path="id"/>

        <form:input type="hidden" path="done"/>

        <div><input type="submit" class="btn btn-success"/></div>
    </form:form>
</div>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript">
    var today = new Date();
    $('#targetDate').datepicker({
        format: 'yyyy-mm-dd',
        startDate: today
    });
</script>
</body>
</html>