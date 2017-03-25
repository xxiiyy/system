<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: lhd
  Date: 2017/3/25
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
    <li><a href=""><span class="glyphicon glyphicon-dashboard"></span> ${user.loginName}</a></li>
    <li class="active"><a href=""><span class="glyphicon glyphicon-dashboard"></span> Dashboard</a></li>
    <li><a href="widgets.jsp"><span class="glyphicon glyphicon-th"></span> Widgets</a></li>
    <li><a href="charts.jsp"><span class="glyphicon glyphicon-stats"></span> Charts</a></li>
    <li><a href="tables"><span class="glyphicon glyphicon-list-alt"></span> Tables</a></li>
    <li><a href="forms.jsp"><span class="glyphicon glyphicon-pencil"></span> Forms</a></li>
    <li><a href="panels.jsp"><span class="glyphicon glyphicon-info-sign"></span> Alerts &amp; Panels</a></li>
    <li class="parent ">
        <a href="#">
            <span class="glyphicon glyphicon-list"></span> Dropdown <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span>
        </a>
        <ul class="children collapse" id="sub-item-1">
            <li>
                <a class="" href="#">
                    <span class="glyphicon glyphicon-share-alt"></span> Sub Item 1<span data-toggle="collapse" href="#sub-item-2" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span>
                </a>
                <ul class="children collapse" id="sub-item-2">
                    <li>
                        <a class="" href="#">
                            <span></span> Sub Item 1
                        </a>
                    </li>
                    <li>
                        <a class="" href="#">
                            <span></span> Sub Item 2
                        </a>
                    </li>
                    <li>
                        <a class="" href="#">
                            <span></span> Sub Item 3
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a class="" href="#">
                    <span class="glyphicon glyphicon-share-alt"></span> Sub Item 2
                </a>
            </li>
            <li>
                <a class="" href="#">
                    <span class="glyphicon glyphicon-share-alt"></span> Sub Item 3
                </a>
            </li>
        </ul>
    </li>

--%>

    <c:forEach items="${menus}" var="menu" varStatus="status">
        <c:if test="${menu.childMenus!=null}">
            <li class="parent ">
                <a href="${menu.href}">
                    <span class="${menu.icon}"></span> ${menu.name}
                    <span data-toggle="collapse" href="#sub-item-${status.index}" class="icon pull-right">
                        <em class="glyphicon glyphicon-s glyphicon-plus"></em>
                    </span>
                </a>
                <ul class="children collapse" id="sub-item-${status.index}">
                    <c:set var="menus" value="${menu.childMenus}" scope="request" />
                    <jsp:include page="menu.jsp" />
                </ul>
            </li>
        </c:if>
        <c:if test="${menu.childMenus==null}">
            <li>
                <a href="${menu.href}">
                    <span class="${menu.icon}"></span> ${menu.name}
                </a>
            </li>
        </c:if>
    </c:forEach>
