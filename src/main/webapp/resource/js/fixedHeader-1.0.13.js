$.fn.fixedHeaderTable=function(fixedColumns){
	  
		$(this).find("th").each(function(){
  		$(this).html("<nobr>"+$(this).text()+"</nobr>");
  	});
	var datawidth=$(this).width();


	if($(this).find('thead').length > 0 && $(this).find('th').length > 0) {
		var widthArray=new Array();
		$(this).find("thead tr:last th:not(:last)").each(function(){
			widthArray.push($(this).width());
		})
		$(this).removeClass("bordered");
		// copy table
		var $w	   = $(window),
			$t	   = $(this),
			$Headerd=$t.find('thead').clone(),
			$Headerdiv = $t.find('thead'),
			$col   = $t.find('tbody').clone(),
			$col2   = $t.find('tbody'),
			$fixedColumns=fixedColumns-1;
		
		//$Headerdiv.find('th').each(function(){$(this).html("<nobr>"+$(this).html()+"</nobr>");})
		// Ӫ��һ��2*2�ı��
		var $table='';
		    $table=$table+'<tr>';  
		    $table=$table+'<td><div class="sticky-corner" style="overflow: hidden;"><table class="bordered" style="table-layout:fixed;"></table></div></td>'; 
		    $table=$table+'<td><div class="sticky-head" style="overflow: hidden;"><table class="bordered" style="table-layout:fixed;"></table></div></td>'; 
		    $table=$table+'</tr>'; 
		    $table=$table+'<tr>'; 
		    $table=$table+'<td><div class="sticky-col" style=" overflow: hidden;"><table class="bordered"  style="table-layout:fixed;"></table></div></td>'; 
		    $table=$table+'<td><div class="maindiv" style=" overflow: auto;" ><table class="bordered"  style="table-layout:fixed;"></table></div></td>'; 
		    $table=$table+'</tr>'; 
		
		//�����µı��    
		$t.html($table);

        //�������Ͻ�
		$(this).find('.sticky-corner table')
		.append($Headerd)
		.find('thead tr').each(function (i){
			$(this).find('th').each(function (j){
				if(j>$fixedColumns){$(this).remove();}
			});
		});
		
		//�̶���ͷ��ɾ����һ��
		$(this).find('.sticky-head table')
		.append($Headerdiv)
		.find('thead tr').each(function (i){
			$(this).find('th').each(function (j){
				if(j<=$fixedColumns){$(this).remove();}
			});
		});
							
		
		//�ڹ̶����м������ݣ�ɾ�����̶����������
		$(this).find('.sticky-col table')
		.append($col)
		.find('tbody tr').each(function (i){
			$(this).find('td').each(function (j){
				if(j>$fixedColumns){$(this).remove();}
			});
		});
		
		
		//�ڱ���������ݣ�ɾ���̶���
		$(this).find('.maindiv table')
		.append($col2)
		.find('tbody tr').each(function (i){
			$(this).find('td').each(function (j){
				if(j<=$fixedColumns){$(this).remove();}
			});
		});
		

		//set data table's height					
		var setSize=function(){				
			var headHeight=$(".sticky-corner").height();
							
			var fixedWidth=0;
			for(i=1;i<=fixedColumns;i++){
				fixedWidth=fixedWidth+widthArray[i];
			}
			$('.sticky-col').css('height',$(window).height()-headHeight-45);  
			$('.maindiv').css('height',$(window).height()-headHeight-45);
			
			

			$('.sticky-head').width($(window).width()-$('.sticky-corner').width());			
			$('.maindiv').width($(window).width()-$('.sticky-col').width());
			
			$('.sticky-head table').width(datawidth);
			$('.maindiv table').width(datawidth);
		};
		
		setSize();

		//when browser resize ,resize the size
		$w.resize(function() {setSize();});
		
		for(i=0;i<widthArray.length;i++){
			if(i<fixedColumns){
				$(this).find(".sticky-corner tr:last th:eq("+i+")").width(widthArray[i]);
				$(this).find(".sticky-col tr:visible:first td:eq("+i+")").width(widthArray[i]);
				$(this).find(".sticky-col tr:first td:eq("+i+")").width(widthArray[i]);
				$(this).find(".sticky-col tr:last td:eq("+i+")").width(widthArray[i]);
			}else{
				$(".sticky-head table tr:last th:eq("+(i-fixedColumns)+")").width(widthArray[i]);
		
				$(".maindiv table tbody tr:visible:first td:eq("+(i-fixedColumns)+")").width(widthArray[i]);
				$(".maindiv table tbody tr:first td:eq("+(i-fixedColumns)+")").width(widthArray[i]);
				$(".maindiv table tbody tr:last td:eq("+(i-fixedColumns)+")").width(widthArray[i]);
			}
			
			console.log(widthArray[i]);
		}
		
		//set scroll event
		$('.maindiv').on("scroll",function(){
		    $('.sticky-head').scrollLeft($('.maindiv').scrollLeft());
		    $('.sticky-col').scrollTop($('.maindiv').scrollTop());
		});

	};



};