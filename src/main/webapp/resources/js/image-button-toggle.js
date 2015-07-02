$(document).ready(function() {
    var max_fields      = 2; //maximum input boxes allowed
    var wrapper         = $(".input_fields_wrap"); //Fields wrapper
    var add_button      = $("#add_field_button"); //Add button ID

    var x = 0; //initlal text box count
    $(add_button).click(function(e){ //on add input button click
        e.preventDefault();
        $(this).css("display", "none");
        if(x < max_fields){ //max input box allowed
            x++; //text box increment
            $(wrapper).children().eq(x).css("display","block");
        }
    });

    $("#one").change(function(){
        if(x < max_fields){
            $(add_button).css("display","block");
        }
    });

    $("#two").change(function(){
        if(x < max_fields){
            $(add_button).css("display","block");
        }
    });
});