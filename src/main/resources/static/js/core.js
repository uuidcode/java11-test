var core = {
    init: function () {
        $('.load-button').on('click', function () {
            core.render({
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
    },

    stringify: function (object) {
        return JSON.stringify(object, null, 4);
    }
};

$(function () {
   core.init();
});
