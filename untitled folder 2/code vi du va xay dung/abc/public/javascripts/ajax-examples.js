$(document).ready(function() {

  function ajaxParameters(target) {
    return {
      url: target,
      success: function(data, textStatus, jqXHR) {
        window.alert(data);
      },
      error: function(jqXHR, textStatus, errorThrown) {
        window.alert(textStatus);
      }
    };
  }

  $('#ajax').click(function() {
    $.ajax(ajaxParameters('/ajax'));
  });

  $('#badAjaxCall').click(function() {
    $.ajax(ajaxParameters('/ajaxWithError'));
  });

  $('#get').click(function() {
    var getText = $('#getText');
    $.get('/get',
          {foo: getText.val()},
          function(data) {
            getText.val('');
            window.alert(data);
          });
  });

  $('#getWithError').click(function() {
    $.get('/getWithError')
      .success(function(data) {
        window.alert('Success: ' + data);
      })
      .error(function(data) {
        window.alert('Error: ' + data.responseText);
      })
      .complete(function(data) {
        window.alert('The call is now complete');
      });
    }
  );

  $('#post').click(function() {
    var postText = $('#postText');
    $.post('/post',
      {'foo':postText.val()},
      function(data) {
        postText.val('');
        $('#messages').append('<li>' + data + '</li>');
      });
  });

  $('#getJson').click(function() {
    $.getJSON('/getJson',
      function(data) {
        $.each(data, function(key, val) {
          window.alert(key + ':' + val.content);
        });
      });
  });

  $('#getScript').click(function() {
    $.getScript('/getScript');
  });

  $('#getScriptWithError').click(function() {
    $.getScript('/getScriptWithError')
      .done(function(script, textStatus) {
        window.alert('Done: ' + textStatus);
      })
      .fail(function(jqxhr, settings, exception) {
        window.alert('Fail: ' + exception);
      });
  });

  $('#load').click(function() {
    $('#loadContainer').load('/load');
  });

  $('#loadFragment').click(function() {
    $('#loadFragmentContainer').load('/load #aList');
  });
});