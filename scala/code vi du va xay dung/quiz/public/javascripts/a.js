/**
 * Created by tuanna on 5/8/14.
 */


pact = 0;
var ans = [];
var j=0;
var blResult = false;
var arr = [{"quest": "2"},
        {"quest": "1"},
        {"quest": "2"},
        {"quest": "2"},
        {"quest": "1"}];
$('.answers li').click(function () {
    if (!blResult) {
    $(this).parent().parent().find('.answers li').css('background-color', '#ffffff');
    $(this).addClass("selected");
    $(this).css('display','block');
    $(this).css('color','#444');
    $(this).css('background-color','#FFF4B8');
    };
    ans[parseInt(pact) - 1] = $(this).val();
    alert(ans[parseInt(pact) - 1]);
    });




    <!-- tinh toan dap an-->
$('.sb').click(function () {


    $("#answers12 li").removeClass("answers").addClass('correct');
    $("#answers21 li").removeClass("answers").addClass('correct');
    $("#answers32 li").removeClass("answers").addClass('correct');
    $("#answers42 li").removeClass("answers").addClass('correct');
    $("#answers51 li").removeClass("answers").addClass('correct');

    for (var i = 0, len = ans.length; i < len; i++) {
        alert(ans[i] + " " + arr[i]['quest'].toString())
    if (ans[i] == arr[i]['quest'].toString()) {
    j++;

    } ;

    };
    alert("Ban tra loi dung: "+j+"/5 cau hoi");

    $(".answers li").each(function (index, element) {

    if ($(this).hasClass('selected')) {
    $(element).css("backgroundColor", "#DF904F");
    $(element).find("span").css("display", "block");
    }

    if ($(this).hasClass("correct")) {
    $(element).css('background-color', "#B5C763")
    $(element).css('color', '#ffffff');
    $(element).find("span").removeClass("false").addClass("true");
    }
    });

    $(".sb").css('display','none');



    });


