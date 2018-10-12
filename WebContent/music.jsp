<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>大佬鼠音乐播放器</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/src/css/smusic.css"/>
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
						<div class="grid-music-container f-usn">
						    <div class="m-music-play-wrap">
						        <div class="u-cover"></div>
						        <div class="m-now-info">
						            <h1 class="u-music-title"><strong>标题</strong><small>歌手</small></h1>
						            <div class="m-now-controls">
						                <div class="u-control u-process">
						                    <span class="buffer-process"></span>
						                    <span class="current-process"></span>
						                </div>
						                <div class="u-control u-time">00:00/00:00</div>
						                <div class="u-control u-volume">
						                    <div class="volume-process" data-volume="0.50">
						                        <span class="volume-current"></span>
						                        <span class="volume-bar"></span>
						                        <span class="volume-event"></span>
						                    </div>
						                    <a class="volume-control"></a>
						                </div>
						            </div>
						            <div class="m-play-controls">
						                <a class="u-play-btn prev" title="上一曲"></a>
						                <a class="u-play-btn ctrl-play play" title="暂停"></a>
						                <a class="u-play-btn next" title="下一曲"></a>
						                <a class="u-play-btn mode mode-list current" title="列表循环"></a>
						                <a class="u-play-btn mode mode-random" title="随机播放"></a>
						                <a class="u-play-btn mode mode-single" title="单曲循环"></a>
						            </div>
						        </div>
						    </div>
						    <div class="f-cb">&nbsp;</div>
						    <div class="m-music-list-wrap"></div>
						    <div class="m-music-lyric-wrap">
						        <div class="inner">
						            <ul class="js-music-lyric-content">
						                <li class="eof">暂无歌词...</li>
						            </ul>
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
	   
		<!--  <script src="${pageContext.request.contextPath }/src/js/musicList.js"></script>-->
		<script src="${pageContext.request.contextPath }/src/js/smusic.js"></script>
		
		<script>
			
			var musicList =  [
				<c:forEach items="${list}" var="l">
					{
						title:'${l.title}',
						singer:'${l.singer}',
						cover:'/file${l.picturePath}/${l.picture}',
						src:'/file${l.songPath}/${l.song}',
						lyric:'/file${l.lyricsPath}/${l.lyrics}'
					},
				</c:forEach>
			];
			
		    new SMusic({
		        musicList : musicList,
		        autoPlay  : true,
		        defaultMode : 1, 
		        callback   : function (obj) {
		            console.log(obj);
		        }
		    });
		</script>
	</body>
</html>