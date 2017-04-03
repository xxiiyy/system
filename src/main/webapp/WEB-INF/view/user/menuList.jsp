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
                <div class="panel-body">
                    <table data-toggle="table" data-show-refresh="true"
                           data-show-toggle="true" data-show-columns="true" data-search="true"
                           data-select-item-name="toolbar1" data-pagination="true" data-sort-name="status"
                           data-sort-order="asc">
                        <thead>
                        <tr>
                            <th data-field="status" data-sortable="true">no</th>
                            <th data-field="id" data-sortable="true">menu id</th>
                            <th data-field="pid" data-sortable="true">menu pid</th>
                            <th data-field="name" data-sortable="true">menu name</th>
                            <th data-field="href" data-sortable="true">menu href</th>
                            <th data-field="icon" data-sortable="true">menu icon</th>
                            <th data-field="operate" data-sortable="true">operate</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="menu" varStatus="status" items="${rm.list}">
                            <tr>
                                <td data-field="status" data-sortable="true">${status.index+1}</td>
                                <td data-field="nickName" data-sortable="true">${menu.id}</td>
                                <td data-field="id" data-sortable="true">${menu.pId}</td>
                                <td data-field="name" data-sortable="true">${menu.name}</td>
                                <td data-field="price" data-sortable="true">${menu.href}</td>
                                <td data-field="price" data-sortable="true">${menu.icon}</td>
                                <td data-field="operate" data-sortable="true">
                                    <a href="javascript:void(0);" class="updateMenu" data-toggle="modal"
                                       data-target="#myModal" data-uid="${menu.id}">
                                        <span class="glyphicon glyphicon-pencil">修改</span>
                                    </a>
                                    <a href="javascript:void(0);" data-did="${user.id}">
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


<!-- menu更新 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">menu</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" id="updateForm" action="/blogSystem/menu/menuUpdate">
                    <div class="form-group">
                        <label for="id" class="col-sm-3 control-label">menu id</label>
                        <div class="col-sm-8">
                            <input type="text" required name="id" class="form-control" id="id"
                                   readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="pId" class="col-sm-3 control-label">parent id</label>
                        <div class="col-sm-8">
                            <input type="text" required name="pId" class="form-control" id="pId"
                                   placeholder="父菜单">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-3 control-label">menu name</label>
                        <div class="col-sm-8">
                            <input type="text" required name="name" class="form-control" id="name"
                                   placeholder="菜单名字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="show" class="col-sm-3 control-label">是否可用</label>
                        <div class="col-sm-8">
                            <label>
                                <input type="radio" id="show" name="show" value="1" checked> 可用&nbsp&nbsp
                            </label>
                            <label>
                                <input type="radio" id="show1" name="show" value="0">不可用
                            </label>
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

<script src="../resources/js/jquery-1.11.1.min.js"></script>
<script src="../resources/js/bootstrap.min.js"></script>
<script src="../resources/js/chart.min.js"></script>
<script src="../resources/js/chart-data.js"></script>
<script src="../resources/js/easypiechart.js"></script>
<script src="../resources/js/easypiechart-data.js"></script>
<script src="../resources/js/bootstrap-datepicker.js"></script>
<script src="../resources/js/bootstrap-table.js"></script>
<script>


    $(document).ready(function () {
        $(".updateMenu").click(function () {
            var menuId = $(this).data('uid');
            $("#id").val(menuId);
            jQuery.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                type: "POST",
                url: "menuUpdateInfo/" + menuId,
                //data : JSON.stringify(loginName),
                success: function (reslut, tst, jqXHR) {
                    if(reslut.result == true){
                        $('#pId').val(reslut.object.pId);
                        $('#name').val(reslut.object.name);
                        if (reslut.object.show == true) {
                            $('#show').attr("checked", "checked");
                        } else {
                            $('#show1').attr("checked", "checked");
                        }
                    }
                },
                error:function (result) {

                }
            });
        })
    })

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
