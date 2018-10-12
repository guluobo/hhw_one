<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<title>大佬鼠音乐播放器</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
		
		tr th,td {
			text-align: center;
		}
		
		
		.update {
			background-color: blueviolet;
			color: white;
			padding: 10px;
			font-weight: bold;
			border-radius: 5px;
		}
		
		.update:hover {
			background-color: white;
			color: blueviolet;
		}
		
		.delete {
			background-color: indianred;
			color: white;
			font-weight: bold;
			padding: 10px;
			border-radius: 5px;
		}
		
		.delete:hover {
			background-color: white;
			color: indianred;
		}
		
		tr ul {
		    list-style-type: none;
		    margin: 0;
		    padding: 0;
		    background-color: #f1f1f1;
		}
		 
		 tr li a {
		    color: #000;
		    padding: 5px;
		    text-decoration: none;
		}
		
		tr li {
			display: inline;
		}
		 
		tr li a:hover {
		    background-color: #555;
		    color: white;
		}
		
		tr li a:visited {
			color: white;
			text-decoration: none;
		}
		
		.main-page nav {
			margin: 0px;
			padding: 0px;
		}
	
		@media only screen and (max-width: 640px) {
			.main-page {
				margin-top: -70px;
			}
			tr li a {
				display: block;
				width: 100%;
			}
		}
		
		@media only screen and (max-width: 320px) {
			
		}
	</style>
	</head> 
	<body class="cbp-spmenu-push">
		<div class="main-content">
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
						<a href="${pageContext.request.contextPath }/index.jsp">
							<h1>《大佬鼠》</h1>
							<span>音乐播放器</span>
						</a>
					</div>
				</div>
			</div>
			<div id="page-wrapper">
				<div class="main-page">
					<div class="tables">
						<h3 class="title1">歌曲</h3>	
						<div class="bs-example widget-shadow" data-example-id="contextual-table"> 
							<h4>歌曲列表：</h4>
							<table class="table"> 
								<thead> 
									<tr> 
										<th>ID</th> 
										<th>歌曲名称</th> 
										<th>歌手</th> 
										<th>图片</th>
										<th>编辑</th> 
									</tr> 
								</thead> 
								<tbody> 
									
									<c:forEach items="${page.records }" var="music">
										<tr>
											<th scope="row">${music.id}</th>
											<td>${music.title }</td> 
											<td>${music.singer }</td> 
											<td><img src="/file${music.picturePath}/${music.picture}" width="20px" height="20px"></td>
											<td>
												<ul>
													<li><a class="update" href="${pageContext.request.contextPath }/servlet/FileInputServlet?op=update&id=${music.id}&num=${page.currentPageNum}">修改</a></li>
													<li><a class="delete" href="${pageContext.request.contextPath }/servlet/FileInputServlet?op=delete&id=${music.id}&num=${page.currentPageNum}">删除</a></li>
												</ul>
											</td> 
										</tr>
										
									</c:forEach>
								</tbody> 
							</table> 
						</div>
	
					</div>
				</div>
				<div class="grid_3 grid_5 widget-shadow">
					<div class="col-md-6">
						<ul class="pagination pagination-lg">
							
							
							<li><a href="${pageContext.request.contextPath }${page.url}&num=${page.prePageNum}">«</a></li>
							<c:forEach begin="${page.prePageNum-1 == 0 ? 1 : page.prePageNum-1}" end="${page.nextPageNum+1 > page.totalPage ? page.totalPage : page.nextPageNum+1}" var="i" >
								<li class=${i == page.currentPageNum ? "active" : "" }><a href="${pageContext.request.contextPath }${page.url}&num=${i}">${i}</a></li>
							</c:forEach>
							<li><a href="${pageContext.request.contextPath }${page.url}&num=${page.nextPageNum}">»</a></li>
						</ul>
							
					</div>
					<div class="clearfix"> </div>
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