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
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#sidebar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><span>BOLG</span>SYSTEM</a>
            <ul class="user-menu">
                <li class="dropdown pull-right">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span
                            class="glyphicon glyphicon-user"></span> ${user.nickName} <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Profile</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-cog"></span> Settings</a></li>
                        <li><a href="/blogSystem/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div><!-- /.container-fluid -->
</nav>
<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
    <form role="search">
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Search">
        </div>
    </form>
    <ul class="nav menu">
        <jsp:include page="../menu.jsp"/>
        <li role="presentation" class="divider"></li>
        <li><a href="login"><span class="glyphicon glyphicon-user"></span> Login Page</a></li>
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
                           data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name"
                           data-sort-order="desc">
                        <thead>
                        <tr>
                            <th data-field="status" data-sortable="true">No</th>
                            <th data-field="nickname" data-sortable="true">Nick Name</th>
                            <th data-field="sex" data-sortable="true">Sex</th>
                            <th data-field="name" data-sortable="true">Login Name</th>
                            <th data-field="role" data-sortable="true">Role Type</th>
                            <th data-field="operate" data-sortable="true">operate</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="user" varStatus="status" items="${userList}">

                            <tr>
                                <td data-field="status" data-sortable="true">${status.index+1}</td>
                                <td data-field="nickName" data-sortable="true">${user.nickName}</td>
                                <td data-field="id" data-sortable="true">${user.sex==true?"male":"female"}</td>
                                <td data-field="name" data-sortable="true">${user.loginName}</td>
                                <td data-field="price" data-sortable="true">${user.roleType}</td>
                                <td data-field="operate" data-sortable="true">
                                    <a href="login"><span class="glyphicon glyphicon-pencil">修改</span></a>
                                    <a href="javascript:void(0);" data-id="${user.id}" id="deleteUser">
                                        <span class="glyphicon glyphicon-trash">删除</span>
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
