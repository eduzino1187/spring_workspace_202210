<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>AdminLTE 3 | Dashboard</title>
<%@ include file="../inc/header_link.jsp"%>
</head>
<body class="hold-transition">
	<div class="wrapper p-5">
		<!-- 로그인 폼  Card Begin -->
		<div class="card card-info">
		    <div class="card-header">
		        <h3 class="card-title">관리자 로그인</h3>
		    </div>
		    <!-- /.card-header -->
		    <!-- form start -->
		    <form class="form-horizontal">
		        <div class="card-body">
		            <div class="form-group row">
		                <div class="col">
		                    <input type="text" class="form-control" placeholder="관리자 ID">
		                </div>
		            </div>
		            <div class="form-group row">
		                <div class="col">
		                    <input type="password" class="form-control" placeholder="Password">
		                </div>
		            </div>
		            <div class="form-group row">
		                <div class="col">
		                    <input type="text" class="form-control" placeholder="관리자 이름">
		                </div>
		            </div>

		        </div>
		        <!-- /.card-body -->
		        <div class="card-footer">
		            <button type="submit" class="btn btn-info">Sign in</button>
		            <button type="submit" class="btn btn-default float-right">Cancel</button>
		        </div>
		        <!-- /.card-footer -->
		    </form>
		</div>		
		<!-- 로그인 폼  Card End -->
	</div>
	<!-- ./wrapper -->
	<%@ include file="../inc/footer_link.jsp" %>
</body>
</html>









