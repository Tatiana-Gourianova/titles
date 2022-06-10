<%--@elvariable id="text-in" type="TextIn"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Подтвердите</title>
</head>
<body>
Имя файла
${text_title}
<BR>
Путь
${text_path}
<%-- Содержимое
<br>
${titles}

<textarea>
    ${text_titles}
</textarea>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-2">
            <form action="/controller" method="post" class="form-horizontal">
                <input type="hidden" name="action" value="add_money">
                <div class="text-center">
                    <fmt:message key="message.balance"/> ${text.titles}
                </div>
                <div class="form-group">
                    <label for="balanceForm" class="col-sm-2 control-label"><fmt:message key="register.form.balance"/></label>
                    <div class="col-sm-10">

                        <input type="languige" step="1" id="balanceForm" name="languige" class="form-control" placeholder="<fmt:message key="register.form.balance.placeholder"/>"
                               onKeyup="checkData('balance')" max="1000" required pattern="[0-9]{1,6}">
                        <b id="balance" style="color: red; font-size: 10px"><fmt:message key="validation.balance"/></b>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary"><fmt:message key="balance.form.submit"/></button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
--%>
</body>
</html>
