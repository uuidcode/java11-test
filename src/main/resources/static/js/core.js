var core = {
    init: function () {
        $('.embedded-load-button').on('click', function () {
            core.renderWithEmbedded({
                templateId: 'server-hbs',
                api: '/api',
                contentId: 'content'
            });
        });

        $('.precompile-load-button').on('click', function () {
            core.renderWithPrecompile({
                templateId: 'server',
                api: '/api',
                contentId: 'content'
            });
        });
    },

    renderWithEmbedded: function (option) {
        var templateId = option.templateId;
        var source = jQuery('#' + templateId).html();
        option.template = Handlebars.compile(source);
        core.render(option);
    },

    renderWithPrecompile: function (option) {
        var templateId = option.templateId;
        option.template = Handlebars.templates[templateId];
        core.render(option);
    },

    render: function (option) {
        var template = option.template;
        var api = option.api;
        var contentId = option.contentId;

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
