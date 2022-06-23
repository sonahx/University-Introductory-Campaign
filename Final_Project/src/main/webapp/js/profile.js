$(function() {
  $('.view_details').click(function() {
    if ($(this).is(':checked')) {
      $(this)
        .next('label')
        .html('&times;')
        .attr('title', 'tap here to close full profile');
      $(this)
        .parent()
        .next('main')
        .slideDown('normal');
    } else {
      $(this)
        .next('label')
        .html('☰')
        .attr('title', 'tap here to view full profile');
      $(this)
        .parent()
        .next('main')
        .slideUp('fast');
    }
  });
});