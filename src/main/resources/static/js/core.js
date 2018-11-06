var java11 = {
    init: function () {
        $('.load-button').on('click', function () {
            var source = jQuery('#server-hbs').html();
            var template = Handlebars.compile(source);

            $.ajax({
                url: '/api',
                dataType: 'json',
                success: function (json) {
                    var html = template(json);
                    $('#content').html(html);
                }
            });
        });
    }
};

$(function () {
   java11.init();
});
