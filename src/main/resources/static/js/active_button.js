$(document).ready(function() {
    $('.nav-link').click(function() {
        $('.nav-link.active').removeClass('active');
        $(this).addClass('active');
    });
});