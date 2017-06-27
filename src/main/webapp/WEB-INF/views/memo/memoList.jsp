<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="../resources/js/memo.js"></script>
<script type="text/javascript">
	$(function() {
		getList(1, '%', '%');
		
		$("#btn").click(function() {
			var writer = $("#writer").val();
			var contents = $("#contents").val();
			memoWrite(writer, contents);
		});
		
		$("#btnView").click(function() {
			memoView(100);
		});
		
	});
	
/* 	function memoWrite(writer, contents) {
		$.ajax({
			url:"memoWrite",
			type:"POST",
			data:{
				writer:writer,
				contents:contents
			},
			success : function(data) {
				//alert(data);
				//refresh하는 1번째 방법
				//getList(1, '', '');
				//3번 방법(개인적으로 1번이 제일 쉬움)
				$("#result").html(data.trim());
			}
		});
	}
	
	function getList(curPage, find, search) {
		$.ajax({
			url : "getMemoList",
			type : "GET",
			data : {
				curPage : curPage,
				find : find,
				search : search
			},
			success : function(data) {
				//alert(data.trim()); 
				//prepand를 사용하는 2번째 방법(하지만, prepand사용시 perPage개수를 넘게됨) 
				$("#result").html(data);
			}
		}); 
	}*/

		/* 		$.get("URL?name=value", function(data) {
		
		 });
		
		 $.post("URL",{name:value} ,function(data) {
		
		 });
		
		 $.ajax({
		 url: ,
		 type: get or post,
		 data:{
		
		 },
		 success:function(data) {
		
		 }
		 }); */
</script>
</head>
<body>
	<div>
		<form action="">
			<p><input type="text" id="writer"></p>
			<textarea rows="" cols="" id="contents"></textarea>
						
			<p><input type="button" value="WRITE" id="btn"></p>
		</form>
	</div>
	<div id="result"></div>
	<button id="btnView">View</button>

</body>
</html>