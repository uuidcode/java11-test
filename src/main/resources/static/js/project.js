var project = {
    init: function () {
        $('.add-project-button').on('click', function () {
            $.ajax({
                url: '/project',
                type: 'POST',
                contentType: 'application/json; charset=utf-8',
                dataType: 'json',
                data: core.stringify({
                }),
                success: function (json) {
                    location.reload();
                }
            });
        });
    }
};

$(function () {
    project.init();
});
