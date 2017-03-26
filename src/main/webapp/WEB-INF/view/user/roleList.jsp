<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Lumino - Tables</title>

    <link href="../resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="../resources/css/datepicker3.css" rel="stylesheet">
    <link href="../resources/css/bootstrap-table.css" rel="stylesheet">
    <link href="../resources/css/styles.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="../resources/js/html5shiv.js"></script>
    <script src="../resources/js/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<jsp:include page="../top.jsp"/>>
<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
    <form role="search">
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Search">
        </div>
    </form>
    <ul class="nav menu">
        <jsp:include page="../menu.jsp"/>
        <li role="presentation" class="divider"></li>
    </ul>
    <div class="attribution">Template by <a href="http://www.medialoot.com/item/lumino-admin-bootstrap-template/">Medialoot</a>
    </div>
</div><!--/.sidebar-->

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
            <li class="active">user</li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">userList</h1>
        </div>
    </div><!--/.row-->


    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">userList information</div>
                <div class="panel-body">
                    <table data-toggle="table" data-show-refresh="true"
                           data-show-toggle="true" data-show-columns="true" data-search="true"
                           data-select-item-name="toolbar1" data-pagination="true" data-sort-name="status"
                           data-sort-order="asc">
                        <thead>
                        <tr>
                            <th data-field="status" data-sortable="true">no</th>
                            <th data-field="id" data-sortable="true">role id</th>
                            <th data-field="name" data-sortable="true">menu name</th>
                            <th data-field="type" data-sortable="true">role type</th>
                            <th data-field="operate" data-sortable="true">operate</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="role" varStatus="status" items="${roleList}">

                            <tr>
                                <td data-field="status" data-sortable="true">${status.index+1}</td>
                                <td data-field="id" data-sortable="true">${role.id}</td>
                                <td data-field="name" data-sortable="true">${role.roleName}</td>
                                <td data-field="type" data-sortable="true">${role.roleType}</td>
                                <td data-field="operate" data-sortable="true">
                                    <a href="javascript:void(0);" date-uid="${user.id}"><span class="glyphicon glyphicon-pencil">&nbsp;修改&nbsp;&nbsp;</span></a>
                                    <a href="javascript:void(0);" data-did="${user.id}">
                                        <span class="glyphicon glyphicon-trash">&nbsp;删除</span>
                                    </a>
                                </td>
                            </tr>

                        </c:forEach>
                        </tbody>

                    </table>
                </div>
            </div>
        </div>
    </div><!--/.row-->


</div><!--/.main-->

<script src="../resources/js/jquery-1.11.1.min.js"></script>
<script src="../resources/js/bootstrap.min.js"></script>
<script src="../resources/js/chart.min.js"></script>
<script src="../resources/js/chart-data.js"></script>
<script src="../resources/js/easypiechart.js"></script>
<script src="../resources/js/easypiechart-data.js"></script>
<script src="../resources/js/bootstrap-datepicker.js"></script>
<script src="../resources/js/bootstrap-table.js"></script>
<script>
    !function ($) {
        $(document).on("click", "ul.nav li.parent > a > span.icon", function () {
            $(this).find('em:first').toggleClass("glyphicon-minus");
        });
        $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
    }(window.jQuery);

    $(window).on('resize', function () {
        if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
    })
    $(window).on('resize', function () {
        if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
    })
</script>
</body>

</html>
