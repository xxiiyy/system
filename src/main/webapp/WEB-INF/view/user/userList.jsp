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

    <link href="/blogSystem/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/blogSystem/resources/css/datepicker3.css" rel="stylesheet">
    <link href="/blogSystem/resources/css/bootstrap-table.css" rel="stylesheet">
    <link href="/blogSystem/resources/css/styles.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="/blogSystem/resources/js/html5shiv.js"></script>
    <script src="/blogSystem/resources/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<jsp:include page="../top.jsp"/>
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
                <div class="panel-heading">
                    <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal1">
                        add user
                    </button>
                </div>
                <div class="panel-body">
                    <table data-toggle="table" data-show-refresh="true"
                           data-show-toggle="true" data-show-columns="true" data-search="true"
                           data-select-item-name="toolbar1" data-pagination="true" data-sort-name="status"
                           data-sort-order="asc">
                        <thead>
                        <tr>
                            <th data-field="status" data-sortable="true">no</th>
                            <th data-field="nickname" data-sortable="true">nick name</th>
                            <th data-field="sex" data-sortable="true">sex</th>
                            <th data-field="name" data-sortable="true">login name</th>
                            <th data-field="role" data-sortable="true">role type</th>
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
                                    <a href="javascript:void(0);" class="updateUser" data-toggle="modal"
                                       data-target="#myModal" data-uid="${user.loginName}">
                                        <span class="glyphicon glyphicon-pencil">&nbsp;修改&nbsp;&nbsp;</span>
                                    </a>
                                    <a href="deleteUser/${user.loginName}" class="deleteUser" data-did="${user.id}">
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
    <!-- 按钮触发模态框 -->

    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel1">
                        add user
                    </h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" role="form" action="addUser">
                        <div class="form-group">
                            <label for="loginName" class="col-sm-3 control-label">login name</label>
                            <div class="col-sm-8">
                                <input type="text" required class="form-control" name="loginName">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-3 control-label">password</label>
                            <div class="col-sm-8">
                                <input type="password" required class="form-control" name="password" id="password">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="nickName" class="col-sm-3 control-label">nick name</label>
                            <div class="col-sm-8">
                                <input type="text" required class="form-control" name="nickName"
                                       placeholder="请输入名字">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="sex" class="col-sm-3 control-label">sex</label>
                            <div class="col-sm-8">
                                <label>
                                    <input type="radio" name="sex" value="1" checked> male&nbsp&nbsp
                                </label>
                                <label>
                                    <input type="radio" name="sex" value="0">female
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="roleType" class="col-sm-3 control-label">role type</label>
                            <div class="col-sm-8">
                                <select class="form-control" name="roleType">
                                    <c:forEach var="role" items="${roleList}">
                                        <option value="${role.roleType}">${role.roleName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button type="submit" class="btn btn-primary">提交更改</button>
                        </div>
                    </form>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>


</div><!--/.main-->
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">update user information</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" id="updateForm" action="updateSubmit">
                    <div class="form-group">
                        <label for="loginName" class="col-sm-3 control-label">login name</label>
                        <div class="col-sm-8">
                            <input type="text" required name="loginName" class="form-control" id="loginName"
                                   readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="nickName" class="col-sm-3 control-label">nick name</label>
                        <div class="col-sm-8">
                            <input type="text" required name="nickName" class="form-control" id="nickName"
                                   placeholder="请输入名字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="sex" class="col-sm-3 control-label">sex</label>
                        <div class="col-sm-8">
                            <label>
                                <input type="radio" name="sex" id="sex" value="1" checked> male&nbsp&nbsp
                            </label>
                            <label>
                                <input type="radio" name="sex" id="sex1" value="0">female
                            </label>
                        </div>

                    </div>
                    <div class="form-group">
                        <label for="roleType" class="col-sm-3 control-label">role type</label>
                        <div class="col-sm-8">
                            <select class="form-control" id="roleType" name="roleType">
                                <c:forEach var="role" items="${roleList}">
                                    <option value="${role.roleType}">${role.roleName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="submit" id="submitUpdate" class="btn btn-primary">提交更改</button>
                    </div>
                </form>
            </div>

        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<script src="/blogSystem/resources/js/jquery-1.11.1.min.js"></script>
<script src="/blogSystem/resources/js/bootstrap.min.js"></script>
<script src="/blogSystem/resources/js/chart.min.js"></script>
<script src="/blogSystem/resources/js/chart-data.js"></script>
<script src="/blogSystem/resources/js/easypiechart.js"></script>
<script src="/blogSystem/resources/js/easypiechart-data.js"></script>
<script src="/blogSystem/resources/js/bootstrap-datepicker.js"></script>
<script src="/blogSystem/resources/js/bootstrap-table.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $(".updateUser").click(function () {
            var loginName = $(this).data('uid');
            $("#loginName").val(loginName);
            jQuery.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                type: "POST",
                url: "update/" + loginName,
                //data : JSON.stringify(loginName),
                success: function (reslut, tst, jqXHR) {
                    $("#loginName").val(reslut.loginName);
                    $("#nickName").val(reslut.nickName);
                    if (reslut.sex == 1) {
                        $("#sex").attr("checked", "checked");
                    } else {
                        $("#sex1").attr("checked", "checked");
                    }
                    $("#roleType").val(reslut.roleType);
                    //$("#sex").val(reslut.sex);
                }
            });
        })
    })

    /*$(document).ready(function () {
     $("#submitUpdate").click(function () {
     $("#updateForm").submit;
     })
     })*/

</script>
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
