function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        console.log($(input).attr('id'));
        reader.onload = function (e) {
            $('#blah' + $(input).attr('id'))
                .attr('src', e.target.result)
                .width(300)
                .height(250);
        };

        reader.readAsDataURL(input.files[0]);
    }
}