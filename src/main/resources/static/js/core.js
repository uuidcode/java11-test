var java11 = {
    init: function () {
        $('.load-button').on('click', function () {
            java11.render({
                templateId: 'server-hbs',
                api: '/api',
                contentId: 'content'
            });
        });
    },

    render: function (option) {
        var templateId = option.templateId;
        var api = option.api;
        var contentId = option.contentId;

        var source = jQuery('#' + templateId).html();
        var template = Handlebars.compile(source);

        $.ajax({
            url: api,
            dataType: 'json',
            success: function (json) {
                var html = template(json);
                $('#' + contentId).html(html);
            }
        });
    }
};

$(function () {
   java11.init();
});
