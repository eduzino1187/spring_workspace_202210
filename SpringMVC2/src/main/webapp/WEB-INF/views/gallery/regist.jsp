<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>겔러리 글등록</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">

function regist(){
		$("#form1").attr({
			action:"/gallery/regist",
			method:"post", 
			enctype:"multipart/form-data"
		});
		
		$("#form1").submit();		
	
}
$(function(){
	$("#bt_regist").click(function(){
		regist();		
	});
	
});
</script>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col mt-3">
				<form id="form1">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Enter password" name="title">
					</div>				
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Enter password" name="writer">
					</div>				
					<div class="form-group">
						<textarea class="form-control" name="content"></textarea>
					</div>
									
					<div class="form-group">
						<input type="file" class="form-control" name="file">					
					</div>				
					
					<div class="form-group">
						<button type="button" class="btn btn-primary" id="bt_regist">등록</button>
						<button type="button" class="btn btn-primary" id="bt_list">목록</button>
					</div>				
				</form>				

			</div>
		</div>
	</div>
</body>
</html>