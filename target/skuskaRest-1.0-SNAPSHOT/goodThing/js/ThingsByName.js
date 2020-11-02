


$(function (){

    var $orders= $('#orders');
    $.ajax({
        type:'GET',
        url:'/skuskaRest-1.0-SNAPSHOT/rest/things/allThings',
        success: function (things){
            $.each(things,function (id,thing) {
                $orders.append('<li>'+thing.name+'</li>');
            });
        }

    });
});



