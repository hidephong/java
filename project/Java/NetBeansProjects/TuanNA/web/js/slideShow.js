var iSlide =-1;var maxSlides=5;
function slideSwitch() {
    var $active = $('#slideshow IMG.active');
    if ( $active.length == 0 ) {$active = $('#slideshow IMG:last');};
    if (iSlide >=(maxSlides-1)) iSlide=0; else iSlide++;
  
/*
    var $next =  $active.next().length ? $active.next(): $('#slideshow IMG:first');
    $active.addClass('last-active');
*/
    $next=$('#slideshow IMG:eq('+iSlide+')')
    $next.css({opacity: 0.0})
        .addClass('active')
        .animate({opacity: 1.0}, 1000, function() {
            $active.removeClass('active last-active');
        });
}
function slideGoto(i) {
    var $active = $('#slideshow IMG.active');
    $active.removeClass('active last-active');
    var $next=$('#slideshow IMG:eq('+i+')').addClass('active')	
}



$(function() {setInterval( "slideSwitch()", 15000 );});
