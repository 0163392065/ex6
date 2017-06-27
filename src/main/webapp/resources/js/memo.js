/**
 * memo
 */
	function memoView(num) {
		$.get("memoView/"+num, function(data) {
			alert(data.writer);
		});
	}
	
	function memoWrite(writer, contents) {
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
				var result="<table>";
				$(data).each(function() {
					result = result + "<tr>";
					result = result + "<td>" + this.num + "</td>";
					result = result + "<td>" + this.contents + "</td>";
					result = result + "<td>" + this.writer + "</td>";
					result = result + "<td>" + this.reg_date + "</td>";
					result = result + "</tr>";
				});
				$("#result").html(result);
			}
		});
	}
	
	function getList(curPage, find, search) {
		$.ajax({
			url : "getMemoList/"+curPage+"/"+find+"/"+search,
			type : "GET",
			//주소만으로 데이터 전송
/*			data : {
				curPage : curPage,
				find : find,
				search : search
			},*/
			success : function(data) {
				//alert(data.trim()); 
/*				//prepand를 사용하는 2번째 방법(하지만, prepand사용시 perPage개수를 넘게됨) 
				//$("#result").html(data);
				//alert(data.trim());
				data = data.trim();
				data = JSON.parse(data);*/
				var result="<table>";
				$(data).each(function() {
					result = result + "<tr>";
					result = result + "<td>" + this.num + "</td>";
					result = result + "<td>" + this.contents + "</td>";
					result = result + "<td>" + this.writer + "</td>";
					result = result + "<td>" + this.reg_date + "</td>";
					result = result + "</tr>";
				});
				result = result + "</table>"
				$("#result").html(result);
			}
		});
}