var q;
var a;
var arr;
$.getJSON( "getQuest", function( data ) {
q = data;
});
$.getJSON( "getJson", function(data) {
arr = data;
});
$.getJSON( "getAns", function(data) {
a = data;
});

b = "<br/><input name='previous' class='previous action-button' value='Quay lại' type='button'>";
b1 = "<input name='next' class='next action-button' value='Tiếp' type='button'></fieldset>";

s = "<fieldset><p>New quiz</p><br/><br/><input type='button' name='next' class='next action-button' value='Start quiz'/></fieldset>";
for (var i = 0; i < 5; i++) {
s += "<fieldset id='q" + i + "'><p>" + q[i].toString() + "</p><br/>";
if (a[i]["a1"] != null) {
s += "<div class='answers' id='answers" + i + "1'><li value='1'>" + a[i]["a1" ].toString() + "<span class='false'></span></li></div><br/>";};
if (a[i]["a2"] != null) {
s += "<div class='answers' id='answers" + i + "2'><li value='2'>" + a[i]["a2"].toString()  + "<span class='false'></span></li></div><br/>";};
if (a[i]["a3"] != null) {
s += "<div class='answers' id='answers" + i + "3'><li value='3'>" + a[i]["a3"].toString()  + "<span class='false'></span></li></div><br/>";};
if (a[i]["a4"] != null) {
s += "<div class='answers' id='answers" + i + "4'><li value='4'>" + a[i]["a4"].toString()  + "<span class='false'></span></li></div><br/>";};
if (a[i]["a5"] != null) {
s += "<div class='answers' id='answers" + i + "5'><li value='5'>" + a[i]["a5"].toString()  + "<span class='false'></span></li></div><br/>";};
s += b + b1;
};
s += "<fieldset><span id='cauhoi'>Bạn  muốn chấm điểm?</span><br /><input name='previous' class='previous action-button' value='Quay lại' type='button'><input class='sb' value='Xác nhận'></fieldset>";

$("p").append(s);

pact = 0;
var ans = [];
var marked = false;
var ansname = [];
var j = 0;

$('.answers li').click(function () {
  if (!marked) {
  $(this).parent().parent().find('.answers li').removeClass("selected");
  $(this).parent().parent().find('.answers li').css('background-color', "#ffffff");
  $(this).addClass("selected");
  $(this).css('display', 'block');
  $(this).css('color', '#444');
  $(this).css('background-color', '#FFF4B8');
  ans[pact] = $(this).val();
  ansname[pact] = $(this).parent().attr('id');
}
});


function a1(a) {
$(a).removeClass("selected").addClass("correct");
$(a).css('background-color', '#B5C763');
$(a).css('color', '#ffffff');
$(a).find("span").removeClass("false").addClass("true");
return;
}
;
function b1(a) {
$(a).removeClass("selected").addClass("wrong");
$(a).css("backgroundColor", "#DF904F");
$(a).find("span").css("display", "block");
return;
}
;
<!-- tinh toan dap an-->
$('.sb').click(function () {
  if (!marked) {
  marked = true;
  for (var id = 0, len = ans.length-1; id < len; id++) {
  var a = "#answers" + (id) + arr[id]['quest'].toString() + " li";
  if (ans[id+1] == arr[id]['quest'].toString()) {
  j++;
} else {
b1("#" + ansname[id+1] + " li");
};
$('#kq').text(" Bạn đã trả lời đúng "+j+"/5 câu hỏi.");
a1(a);
};


$('.sb').val("Thoát");


$('#cauhoi').text("Bạn có muốn thoát?");

$('#myModal').modal({
  show: true,
  remote: '/kq',
  static:true
});

}
else
window.location.href = "http://hocngay.com";

return true;


return false;
});



			var current_fs, next_fs, previous_fs;
			var left, opacity, scale;
			var animating;

			$(".next").click(function () {
			pact = pact + 1;
			if(pact>1) {
			if (ansname[pact - 1] == null) {
			pact-=1;
			return false;
			};
			}
			if (animating) return false;
			animating = true;

			current_fs = $(this).parent();
			next_fs = $(this).parent().next();

			//activate next step on progressbar using the index of next_fs
			$("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");

			//show the next fieldset
			next_fs.show();
			//hide the current fieldset with style
			current_fs.animate({opacity: 0}, {
			step: function (now, mx) {
			//as the opacity of current_fs reduces to 0 - stored in "now"
			//1. scale current_fs down to 80%
			scale = 1 - (1 - now) * 0.2;
			//2. bring next_fs from the right(50%)
			left = (now * 50) + "%";
			//3. increase opacity of next_fs to 1 as it moves in
			opacity = 1 - now;
			current_fs.css({'transform': 'scale(' + scale + ')'});
			next_fs.css({'left': left, 'opacity': opacity});
			},
			duration: 800,
			complete: function () {
			current_fs.hide();
			animating = false;
			},
			//this comes from the custom easing plugin
			easing: 'easeInOutBack'
			});
			});

			$(".previous").click(function () {
			pact = pact - 1;
			if(pact<1){pact+=1;return false;}
			if (animating) return false;
			animating = true;

			current_fs = $(this).parent();
			previous_fs = $(this).parent().prev();

			//de-activate current step on progressbar
			$("#progressbar li").eq($("fieldset").index(current_fs)).removeClass("active");

			//show the previous fieldset
			previous_fs.show();
			//hide the current fieldset with style
			current_fs.animate({opacity: 0}, {
			step: function (now, mx) {
			//as the opacity of current_fs reduces to 0 - stored in "now"
			//1. scale previous_fs from 80% to 100%
			scale = 0.8 + (1 - now) * 0.2;
			//2. take current_fs to the right(50%) - from 0%
			left = ((1 - now) * 50) + "%";
			//3. increase opacity of previous_fs to 1 as it moves in
			opacity = 1 - now;
			current_fs.css({'left': left});
			previous_fs.css({'transform': 'scale(' + scale + ')', 'opacity': opacity});
			},
			duration: 800,
			complete: function () {
			current_fs.hide();
			animating = false;
			},
			//this comes from the custom easing plugin
			easing: 'easeInOutBack'
			});
			});

