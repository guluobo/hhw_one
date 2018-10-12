<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>大佬鼠音乐播放器</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<link href="${pageContext.request.contextPath }/css/bootstrap.css" rel='stylesheet' type='text/css' />
		<link href="${pageContext.request.contextPath }/css/style.css" rel='stylesheet' type='text/css' />
		<link href="${pageContext.request.contextPath }/css/font-awesome.css" rel="stylesheet"> 
		<script src="${pageContext.request.contextPath }/js/jquery-1.11.1.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/modernizr.custom.js"></script>
		<link href='#css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
		<link href="${pageContext.request.contextPath }/css/animate.css" rel="stylesheet" type="text/css" media="all">
		<script src="${pageContext.request.contextPath }/js/wow.min.js"></script>
		<script>
			 new WOW().init();
		</script>
		<script src="${pageContext.request.contextPath }/js/metisMenu.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/custom.js"></script>
		<link href="${pageContext.request.contextPath }/css/custom.css" rel="stylesheet">
		
		<style>
			label {
				font-family: "微软雅黑";
				font-size: 20px;
				color: darkgray;
				padding: 5px 10px;
				text-align: center;
				font-weight: bold;
			}
			
			button {
				width: 100%;
			}
		</style>
	</head> 
	<body class="cbp-spmenu-push">
		<div class="main-content">
			<!--left-fixed -navigation-->
			<div class=" sidebar" role="navigation">
	            <div class="navbar-collapse">
					<nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
						<ul class="nav" id="side-menu">
							<li>
								<a href="${pageContext.request.contextPath }/servlet/FileInputServlet?op=music">播放歌曲</a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath }/servlet/FileInputServlet?op=table">歌曲列表</a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath }/servlet/FileInputServlet?op=fileinput">上传歌曲</a>
							</li>
						</ul>
						<div class="clearfix"> </div>
					</nav>
				</div>
			</div>
			<div class="sticky-header header-section ">
				<div class="header-left">
					<button id="showLeftPush"><i class="fa fa-bars"></i></button>
					<div class="logo">
						<a href="index.jsp">
							<h1>《大佬鼠》</h1>
							<span>音乐播放器</span>
						</a>
					</div>
				</div>
			</div>
			<div id="page-wrapper">
				<div class="main-page">
					<div class="forms">
						<h3 class="title1">修改歌曲</h3>
						<div class="form-grids row widget-shadow" data-example-id="basic-forms"> 
							<div class="form-title">
								<h4>修改歌曲基本信息:</h4>
							</div>
							<div class="form-body">
								<form action="${pageContext.request.contextPath }/servlet/FileInputServlet?op=updateMusic&num=${num}"enctype="multipart/form-data" method="post">
									<div class="form-group">
										<label >序号：</label> 
										<input name="id" class="form-control" placeholder="ID" type="text" value="${music.id }" readonly> 
										<p class="help-block"></p> 
									</div> 
									
									<div class="form-group">
										<label >歌曲名：</label> 
										<input name="title" class="form-control" placeholder="music" type="text" value="${music.title }"> 
										<p class="help-block"></p> 
									</div> 
									<div class="form-group"> 
										<label>歌手：</label> 
										<input name="singer" class="form-control" placeholder="singer" type="text" value="${music.singer }"> 
										<p class="help-block"></p> 
									</div> 
									<div class="form-group"> 
										<label>歌曲：</label> 
										<input name="song" type="file"> 
										<p class="help-block"></p> 
									</div>
									<div class="form-group"> 
										<label>图片：</label> 
										<input name="picture" type="file"> 
											<p class="help-block"></p> 
									</div> 
									<div class="form-group"> 
										<label>歌词：</label> 
										<input name="lyrics" type="file"> 
											<p class="help-block"></p> 
									</div> 
									<button type="submit" class="btn btn-default">修改</button>
								</form> 
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="footer">
				<p><a target="_blank" href="">大佬鼠音乐播放器</a></p>
			</div>
		</div>
		<script src="${pageContext.request.contextPath }/js/classie.js"></script>
		<script>
			var menuLeft = document.getElementById( 'cbp-spmenu-s1' ),
			showLeftPush = document.getElementById( 'showLeftPush' ),
			body = document.body;
				
			showLeftPush.onclick = function() {
			classie.toggle( this, 'active' );
				classie.toggle( body, 'cbp-spmenu-push-toright' );
				classie.toggle( menuLeft, 'cbp-spmenu-open' );
				disableOther( 'showLeftPush' );
			};
				
			function disableOther( button ) {
				if( button !== 'showLeftPush' ) {
					classie.toggle( showLeftPush, 'disabled' );
				}
			}
			
		</script>
		<script src="${pageContext.request.contextPath }/js/jquery.nicescroll.js"></script>
		<script src="${pageContext.request.contextPath }/js/scripts.js"></script>
		<script src="${pageContext.request.contextPath }/js/bootstrap.js"> </script>
	</body>
</html>