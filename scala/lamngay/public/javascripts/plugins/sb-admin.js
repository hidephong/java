
$("#sidebar-toggle").click(function(e) {
    e.preventDefault();
    $(".navbar-static-side").toggleClass("collapsed");
    $("#page-wrapper").toggleClass("collapsed");
});
$(function () {
    $('[data-toggle="confirmation"]').confirmation();
    $(window).bind("load resize", function() {
        if ($(this).width() < 768) {
            $('div.sidebar-collapse').addClass('collapse')
        } else {
            $('div.sidebar-collapse').removeClass('collapse')
        }
    })
    $('#side-menu').metisMenu();
    $('.tree li:has(ul)').addClass('parent_li').find(' > span').attr('title', 'Expand this branch');
    var course = $('.tree > ul > li.parent_li');
    course.find(' > ul > li').show('fast');
    course.find(' > span').attr('title', 'Collapse this branch').find(' > i').addClass('fa-minus-circle').removeClass('fa-plus-circle');

    var path = $(location).attr('href');
    path = path.replace(/\/$/, "");
    $(".tree li > a").each(function () {
        var href = $(this).attr('href');
        if (path.substr(path.length - href.length) === href && href.length > 1) {
            $(this).parent('li').find(' > span').addClass('active');
        }
    });
    var c = false;
    $(".tree > ul > li > ul > li > a").each(function () {
        c = false;
        $(this).parent('li.parent_li').find(' > ul > li > a').each(function () {
            var hrefChild = $(this).attr('href');
            if (path.substr(path.length - hrefChild.length) === hrefChild && hrefChild.length > 1) {
                c = true;
            }
        });
        if (c == false){
            $(this).parent('li.parent_li').find(' > ul > li').hide('fast');
            $(this).parent('li.parent_li').find(' > span').attr('title', 'Expand this branch').find(' > i').addClass('fa-plus-circle').removeClass('fa-minus-circle');
        }
    });

    $('.tree li.parent_li > span').on('click', function (e) {
        var children = $(this).parent('li.parent_li').find(' > ul > li');
        if (children.is(":visible")) {
            children.hide('fast');
            $(this).attr('title', 'Expand this branch').find(' > i').addClass('fa-plus-circle').removeClass('fa-minus-circle');
        } else {
            children.show('fast');
            $(this).attr('title', 'Collapse this branch').find(' > i').addClass('fa-minus-circle').removeClass('fa-plus-circle');
        }
        e.stopPropagation();
    });
});