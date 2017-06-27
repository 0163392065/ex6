<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function(){
		var email = frm.name.value;
		var hp = frm.hp.value;
		var exptext = /^[a-z0-9_+.-]+@([a-z0-9-]+\.)+[a-z0-9\-]+/;
		var hptest = /^(file|gopher|news|nntp|telnet|https?|ftps?|sftp):\/\/([a-z0-9-]+\.)+[a-z0-9]{2,4}.*$/;
	
		
		
		if(exptext.test(email)==false){
			alert("이메일 형식이 올바르지 않습니다.");
			document.frm.email.focus();
			exit;
		}
		
		if(hptest.test(hp)==false){
			alert("홈페이지 형식이 올바르지 않습니다.");
			document.frm.hp.focus();
			exit;
		}

			
	}
</script>
</head>
<body>
	<h1>ERROR</h1>
	<h3>${e }</h3>
	<a href="../">HOME</a>
	<form action="" id="frm" name="frm">
	<fieldset>
  	<legend id="myLegend">납품자정보:</legend>
  		<p>1. 납품자명 : <input type="text" id="name" placeholder="name"></p>
		<p>2. email : <input type="text" id="email" placeholder="answs@naver.com"></p>
		<p>3. 홈페이지 : <input type="text" id="hp" placeholder="http://"></p>
	</fieldset>
	<fieldset>
  	<legend id="myLegend2">납품정보:</legend>
  		<p>· 상품명 : <select>
  			<option>dog1004</option>
  			<option>catchicken</option>
  			<option>milk</option>
  		</select> </p>
		<p>· 납품수량 : <input type="text" placeholder="최소 10이상"></p>
		<p>· 납품등급 : <input type="range"></p>
		· 기타사항 : <textarea rows="" cols=""></textarea> 
	</fieldset>
	<input type="button" value="send message">
	</form>
</body>
</html>
