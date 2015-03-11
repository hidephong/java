/**
 * Created by phuong on 3/21/14.
 */
(function($) {
    if(localStorage.getItem("back") != null && localStorage.getItem("back") != "false"){
        localStorage.setItem("back", "false");
        window.location.reload();
    }
    $.fn.shorten = function(settings) {
        "use strict";

        var config = {
            showChars: 100,
            ellipsesText: "...",
            moreText: "more",
            lessText: "less",
            errMsg: null,
            force: false
        };

        if (settings) {
            $.extend(config, settings);
        }

        if ($(this).data('jquery.shorten') && !config.force) {
            return false;
        }
        $(this).data('jquery.shorten', true);

        $(document).off("click", '.morelink');

        $(document).on({
            click: function() {

                var $this = $(this);
                if ($this.hasClass('less')) {
                    $this.removeClass('less');
                    $this.html(config.moreText);
                    $this.parent().prev().prev().show(); // shortcontent
                    $this.parent().prev().hide(); // allcontent

                } else {
                    $this.addClass('less');
                    $this.html(config.lessText);
                    $this.parent().prev().prev().hide(); // shortcontent
                    $this.parent().prev().show(); // allcontent
                }
                return false;
            }
        }, '.morelink');

        return this.each(function() {
            var $this = $(this);

            var content = $this.html();
            var contentlen = $this.text().length;
            if (contentlen > config.showChars) {
                var c = content.substr(0, config.showChars);
                if (c.indexOf('<') >= 0) // If there's HTML don't want to cut it
                {
                    var inTag = false; // I'm in a tag?
                    var bag = ''; // Put the characters to be shown here
                    var countChars = 0; // Current bag size
                    var openTags = []; // Stack for opened tags, so I can close them later
                    var tagName = null;

                    for (var i = 0, r = 0; r <= config.showChars; i++) {
                        if (content[i] == '<' && !inTag) {
                            inTag = true;

                            // This could be "tag" or "/tag"
                            tagName = content.substring(i + 1, content.indexOf('>', i));

                            // If its a closing tag
                            if (tagName[0] == '/') {


                                if (tagName != '/' + openTags[0]) {
                                    config.errMsg = 'ERROR en HTML: the top of the stack should be the tag that closes';
                                } else {
                                    openTags.shift(); // Pops the last tag from the open tag stack (the tag is closed in the retult HTML!)
                                }

                            } else {
                                // There are some nasty tags that don't have a close tag like <br/>
                                if (tagName.toLowerCase() != 'br') {
                                    openTags.unshift(tagName); // Add to start the name of the tag that opens
                                }
                            }
                        }
                        if (inTag && content[i] == '>') {
                            inTag = false;
                        }

                        if (inTag) { bag += content.charAt(i); } // Add tag name chars to the result
                        else {
                            r++;
                            if (countChars <= config.showChars) {
                                bag += content.charAt(i); // Fix to ie 7 not allowing you to reference string characters using the []
                                countChars++;
                            } else // Now I have the characters needed
                            {
                                if (openTags.length > 0) // I have unclosed tags
                                {
                                    //console.log('They were open tags');
                                    //console.log(openTags);
                                    for (var j = 0; j < openTags.length; j++) {
                                        //console.log('Cierro tag ' + openTags[j]);
                                        bag += '</' + openTags[j] + '>'; // Close all tags that were opened

                                        // You could shift the tag from the stack to check if you end with an empty stack, that means you have closed all open tags
                                    }
                                    break;
                                }
                            }
                        }
                    }
                    c = $('<div/>').html(bag + '<span class="ellip">' + config.ellipsesText + '</span>').html();
                }

                var html = '<div class="shortcontent">' + c +
                    '</div><div class="allcontent">' + content +
                    '</div><span><a href="javascript://nop/" class="morelink">' + config.moreText + '</a></span>';

                $this.html(html);
                $this.find(".allcontent").hide(); // Hide all text
                $('.shortcontent p:last', $this).css('margin-bottom', 0); //Remove bottom margin on last paragraph as it's likely shortened
            }
        });

    };

})(jQuery);
$(document).ready(function () {
    var checkout = $('.datepicker').datepicker().on('changeDate', function(ev) {checkout.hide();}).data('datepicker');
    setNavigation();
    $.validator.addMethod(
        "vnDate",
        function(value) {
            if (value == "") return true;
            return value.match(/^(((0[1-9]|[12]\d|3[01])\/(0[13578]|1[02])\/((19|[2-9]\d)\d{2}))|((0[1-9]|[12]\d|30)\/(0[13456789]|1[012])\/((19|[2-9]\d)\d{2}))|((0[1-9]|1\d|2[0-8])\/02\/((19|[2-9]\d)\d{2}))|(29\/02\/((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$/);
        },
        "Please enter a date in the format dd/mm/yyyy."
    );
    $('#regform').validate({
        rules: {
            "fname" : {
                required: true
            },
            "lname": {
                required: true
            },
            "email":{
                required:true,
                email:true
            },
            "pwd.pwd1": {
                required: true,
                minlength: 6
            },
            "pwd.pwd2": {
                required: true,
                minlength: 6,
                equalTo: "#password"
            },
            "phone":{
                number: true
            },
            "birthday" :{
                vnDate : true
            },
            "BotBootInput":{
                captcha:true
            }
        },
        messages: {
            "fname": "Please enter your firstname",
            "lname": "Please enter your lastname",
            "pwd.pwd1": {
                required: "Please provide a password",
                minlength: "Your password must be at least 6 characters long"
            },
            "pwd.pwd2": {
                required: "Please provide a password",
                minlength: "Your password must be at least 6 characters long",
                equalTo: "Please enter the same password as above"
            },
            "email": "Please enter a valid email address"
        },
        highlight: function(element) {
            $(element).closest('.form-group').addClass('has-error');
        },
        unhighlight: function(element) {
            $(element).closest('.form-group').removeClass('has-error');
        },
        errorElement: 'span',
        errorClass: 'help-block',
        errorPlacement: function(error, element) {
            if(element.parent('.input-group').length) {
                error.insertAfter(element.parent());
            } else {
                error.insertAfter(element);
            }
        }
    });
});
function sendFile(file,editor,welEditable) {
    data = new FormData();
    data.append("file", file);
    $.ajax({
        data: data,
        type: "POST",
        url: "/ajax/uploadimage",
        cache: false,
        contentType: false,
        processData: false,
        success: function(url) {
            editor.insertImage(welEditable, url);
        }
    });
}
function setNavigation() {
    var path = window.location.pathname;
    path = path.replace(/\/$/, "");
    path = decodeURIComponent(path);
    $(".nav > li > a").each(function () {
        var href = $(this).attr('href');
        if (path.substr(path.length - href.length) === href && href.length > 1) {
            $(this).parent('li').addClass('active');
        }
    });
    $(".nav-second-level > li > a").each(function () {
        var href = $(this).attr('href');
        if (path.substr(path.length - href.length) === href && href.length > 1) {
            $(this).parent('li').addClass('active');
            $(this).parent('li').parent('ul').parent('li').addClass('active');
        }
    });
    $(".list-group a").each(function () {
        var href = $(this).attr('href');
        if (path.substr(path.length - href.length) === href && href.length > 1) {
            $(this).closest('a').addClass('active');
        }
    });
}

/*
* Usage:
*   // wrap every occurrance of text 'lorem' in content
*   // with <span class='highlight'> (default options)
*   $('#content').highlight('lorem');
*   // search for and highlight more terms at once
*   // so you can save some time on traversing DOM
*   $('#content').highlight(['lorem', 'ipsum']);
*   $('#content').highlight('lorem ipsum');
*
*   // search only for entire word 'lorem'
*   $('#content').highlight('lorem', { wordsOnly: true });
*
*   // don't ignore case during search of term 'lorem'
*   $('#content').highlight('lorem', { caseSensitive: true });
*
*   // wrap every occurrance of term 'ipsum' in content
*   // with <em class='important'>
*   $('#content').highlight('ipsum', { element: 'em', className: 'important' });
*
*   // remove default highlight
*   $('#content').unhighlight();
*
*   // remove custom highlight
*   $('#content').unhighlight({ element: 'em', className: 'important' });
*/
jQuery.extend({
    highlight: function (node, re, nodeName, className) {
        if (node.nodeType === 3) {
            var match = node.data.match(re);
            if (match) {
                var highlight = document.createElement(nodeName || 'span');
                highlight.className = className || 'highlight';
                var wordNode = node.splitText(match.index);
                wordNode.splitText(match[0].length);
                var wordClone = wordNode.cloneNode(true);
                highlight.appendChild(wordClone);
                wordNode.parentNode.replaceChild(highlight, wordNode);
                return 1; //skip added node in parent
            }
        } else if ((node.nodeType === 1 && node.childNodes) && // only element nodes that have children
            !/(script|style)/i.test(node.tagName) && // ignore script and style nodes
            !(node.tagName === nodeName.toUpperCase() && node.className === className)) { // skip if already highlighted
            for (var i = 0; i < node.childNodes.length; i++) {
                i += jQuery.highlight(node.childNodes[i], re, nodeName, className);
            }
        }
        return 0;
    }
});

jQuery.fn.unhighlight = function (options) {
    var settings = { className: 'highlight', element: 'span' };
    jQuery.extend(settings, options);

    return this.find(settings.element + "." + settings.className).each(function () {
        var parent = this.parentNode;
        parent.replaceChild(this.firstChild, this);
        parent.normalize();
    }).end();
};

jQuery.fn.highlight = function (words, options) {
    var settings = { className: 'highlight', element: 'span', caseSensitive: false, wordsOnly: false };
    jQuery.extend(settings, options);

    if (words.constructor === String) {
        words = [words];
    }
    words = jQuery.grep(words, function(word, i){
        return word != '';
    });
    words = jQuery.map(words, function(word, i) {
        return word.replace(/[-[\]{}()*+?.,\\^$|#\s]/g, "\\$&");
    });
    if (words.length == 0) { return this; };

    var flag = settings.caseSensitive ? "" : "i";
    var pattern = "(" + words.join("|") + ")";
    if (settings.wordsOnly) {
        pattern = "\\b" + pattern + "\\b";
    }
    var re = new RegExp(pattern, flag);

    return this.each(function () {
        jQuery.highlight(this, re, settings.element, settings.className);
    });
};