<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글등록</title>
<style type="text/css">
.boxStyle{
	width:70px;
	height:85px;
	border:2px solid #ccc;
	display:inline-block; /*inline:다른요소와 공존, block:크기설정*/
	margin:5px;
}
.boxStyle img{
	width:65px;
	height:55px;
}
.boxStyle div{
	text-align:right;
	margin-right:5px;
	font-weight:bold;
}
</style>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js"></script>

<script type="text/javascript">
let app1;
let key=0; //유저가 프로그램을 사용하는 동안 그 값을 계속 증가시킴. 유일성 확보 

//사용자정의  UI 컴포넌트 등록하기 
//등록한 이후엔 마치 태그처럼 사용이 가능..
const imagebox={
	template:`
		<div class="boxStyle">
			<div>X</div>
			<img :src="p_src"/>
		</div>					
	`, 
	/*이 컴포넌트를 태그로 호출하는 자가 넘긴 속성을 받으려면  props로 받는다*/
	props:['src']
	,data(){
		return {
			/*
			props 용도: 외부에서 전달된 속성값을 보관하기 위한 변수 
			p_src의 용도: 내부탬플릿에서 접근하기 위한 변수
			*/
			p_src:this.src
		};
	}
	
}; 

function init(){
	app1=new Vue({
		el:"#app1",
		components:{
			imagebox
		},
		data:{
			count:3,
			imageList:[] /*유저가 선택한 파일에 대한 정보, src, name,....*/
		}
	});
}

//사용자가 선택한 이미지가 이미  app1.imageList 에 들어있는지 여부 판단하기 
function checkDuplicate(filename){
	let count=0;
	
	for(let i=0; i<app1.imageList.length;i++){
		let json=app1.imageList[i];
		
		if(json.name==filename){//동일한 이름이 발견된다면...
			count++;
			break;
		}
	}
	return count;
}

//이미지 미리보기 구현하기 
function preview(files){
	console.log("files 는 ", files);
	
	//배열안에 들어있는 파일정보를 하나씩 읽어들여, 화면에 출력 
	for(let i=0;i<files.length;i++){	
		//배열에 들어있는 파일 하나씩 꺼내기 
		let file = files[i];
		
		//app1.imageList 배열에 존재하지 않을 경우만
		if(checkDuplicate(file.name) < 1){ //1보다 작다면 발견된게 없다는것임
			let reader = new FileReader(); //파일 입력스트림 생성 
			reader.onload=(e)=>{
				//console.log("이미지 읽기완료", e);
				console.log("file 정보는 ", file);
				console.log("src 정보는 ", e.target.result);
				
				//이미지 정보를 낱개로 관리하지 말고, 하나의 json으로 
				//몰아서 마치 DTO 처럼 관리해보자
				key++;
				
				let json=[]; //empty
				json['key']=key;//고유값 넣기 , 추후 이미지 삭제시 고유값을 사용하려고...
				json['name']=file.name;//중복이미지 체크시 사용예정 
				json['binary']=e.target.result; // img.src에 대입할 예정
				json['file']=file;//파일 자체에 대한 모든 정보 
				
				//console.log("key 값은 " , key);
				//console.log("i 값은 " , i);
				app1.imageList.push(json);
			}
			reader.readAsDataURL(file);
		}
	}
}

$(function(){
	init();
	
	//이미지를 선택하면... 
	$("input[name='photo']").change(function(){
		//files  배열을  read only 라서 조작이 불가능하다
		
		preview(this.files);		
	});
	
});

</script>

</head>
<body>
	<div class="container" id="app1">
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
						<input type="file" class="form-control" name="photo" multiple>					
					</div>
					
					<div class="form-group" id="previewArea">
						
						<template v-for="json in imageList">
							<imagebox :key="json.key" :src="json.binary"/>						
						</template>
						
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