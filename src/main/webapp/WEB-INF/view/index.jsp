<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Lumino - Dashboard</title>

<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/datepicker3.css" rel="stylesheet">
<link href="resources/css/styles.css" rel="stylesheet">

<!--[if lt IE 9]>
    <script src="resources/js/html5shiv.js"></script>
    <script src="resources/js/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	<jsp:include page="top.jsp"/>

	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<form role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
		</form>
		<ul class="nav menu">
			<jsp:include page="menu.jsp" />
			<li role="presentation" class="divider"></li>
		</ul>
	</div><!--/.sidebar-->

	<div class="right-iframe">
		<iframe src="dashboard" frameborder="0" name="mainFrame" scrolling="auto"
				marginheight="0" marginwidth="0" id="iframepage"
				onLoad="iFrameHeight()" width="100%" height="800px">
		</iframe>
		<script type="text/javascript" language="javascript">
            function iFrameHeight(){
                var ifm= document.getElementById('iframepage');
                var subWeb = document.frames ? document.frames['iframepage'].document : ifm.contentDocument;
                if(ifm != null && subWeb != null) {
                    ifm.height = subWeb.body.scrollHeight;
                    ifm.width = subWeb.body.scrollWidth;
                }
            }
		</script>
	</div>

	<script src="resources/js/jquery-1.11.1.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/chart.min.js"></script>
	<script src="resources/js/chart-data.js"></script>
	<script src="resources/js/easypiechart.js"></script>
	<script src="resources/js/easypiechart-data.js"></script>
	<script src="resources/js/bootstrap-datepicker.js"></script>
	<script>
		$('#calendar').datepicker({
		});
		!function ($) {
		    $(document).on("click","ul.nav li.parent > a > span.icon", function(){
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
