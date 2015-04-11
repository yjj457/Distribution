function foldDo(){
	//初始化表格显示状态
	$("tr.thead").css({display:'block'});
	$("tr.tbody").css({display:'none'});
	
	//收合默认状态配置 0为全收合 1为显示一层 2为显示两层
	//排除异常值
	if(typeof($("tr.tbody").attr("group3"))!="undefined"){
		if(0 != $("#tbody").attr("grouptype")&&
		   1 != $("#tbody").attr("grouptype")&&
		   2 != $("#tbody").attr("grouptype")){$("#tbody").attr("grouptype",1);}
	}else if(typeof($("tr.tbody").attr("group2"))!="undefined"){
		if(0 != $("#tbody").attr("grouptype")&&
		   1 != $("#tbody").attr("grouptype")){$("#tbody").attr("grouptype",1);}
	}else{
		$("#tbody").attr("grouptype",0);
	}
	//判断状态码
	if(0 == $("#tbody").attr("grouptype")){
		$("tr[group1='ZZ']").show();
		$("td[group1='ZZ']").prepend("+");
		$("tr[group1!='ZZ'][group2='ZZ'] td[group2='ZZ']").prepend("+");
	}
	if(1 == $("#tbody").attr("grouptype")){
		$("tr[group2='ZZ']").show();
		$("tr[group1='ZZ'] td[group1='ZZ']").prepend("-");
		$("tr[group1!='ZZ'][group2='ZZ'] td[group2='ZZ']").prepend("+");
	}
	if(2 == $("#tbody").attr("grouptype")){
		$("tr[group3='ZZ']").show();
		$("td[group1='ZZ']").prepend("-");
		$("tr[group1!='ZZ'][group2='ZZ'] td[group2='ZZ']").prepend("-");
	}
	
	//显示默认显示行
	$("td[group1='ZZ']").css("color","red");
	$("td[group1='ZZ']").css("font-weight","bolder");
	$("tr[group1!='ZZ'][group2='ZZ'] td[group2='ZZ']").css("color","red");
	$("tr[group1!='ZZ'][group2='ZZ'] td[group2='ZZ']").css("font-weight","bolder");
	$("tr[group1!='ZZ'][group2!='ZZ'][group3='ZZ'] td[group3='ZZ']").css("color","red");
	$("tr[group1!='ZZ'][group2!='ZZ'][group3='ZZ'] td[group3='ZZ']").css("font-weight","bolder");
	
	//外层展开收合
	$("td[group1='ZZ']").on("click",function(){
		if("+"==$("td[group1='ZZ']").html().substr(0,1)){
			//展开
			if(typeof($("tr.tbody").attr("group2"))!="undefined"){
				$("tr[group1!='ZZ'][group2='ZZ']").show();			
			}else{
				$("tr[group1!='ZZ'].tbody").show();
			}
			$(this).html($(this).html().replace("+","-"));
		}else{
			//收合
			
			//处理第二项+-号
			if(typeof($("tr.tbody").attr("group2"))!="undefined"){
				$("tr[group1!='ZZ'][group2='ZZ'] td").each(function(){
					$(this).html($(this).html().replace('-','+'));
				});
			}
			$("tr[group1!='ZZ'].tbody").hide();
			$(this).html($(this).html().replace("-","+"));
		}
	});
	//中层展开收合
	$("tr[group1!='ZZ'][group2='ZZ'] td[group2='ZZ']").on("click",function(){
		group1id=$(this).parent().attr("group1");
		group2nm = $(this).html();
		if("+" == group2nm.substr(0,1)){
			$(this).html("-" + group2nm.substr(1,group2nm.length -1));
			if(typeof($("tr.tbody").attr("group3"))!="undefined"){
				$("tr[group1='"+group1id+"'][group2!='ZZ'][group3='ZZ']").show();
			}else if(typeof($("tr.tbody").attr("group2"))!="undefined"){
				$("tr[group1='"+group1id+"'][group2!='ZZ']").show();
			}
		}else{
			$(this).html("+" + group2nm.substr(1,group2nm.length -1));
			
			$("tr[group1='"+group1id+"'][group2!='ZZ']").hide();
		}
	});

	//内层展开收合
	$("tr[group2!='ZZ'] td[group3='ZZ']").on("click",function(){
		orgid=$(this).parent().attr("group2");
		$("tr[group2='"+orgid+"'][group3!='ZZ']").toggle();

	});
}

function fold(level){
	$("#tbody").attr("grouptype",level);
	foldDo();
}