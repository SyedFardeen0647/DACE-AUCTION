
$(document).ready(function(){


  hideAll();






$('#dash').on('click',function(){

    hideAll();
    $('#row0').show();


})

$('#users').on('click',function(){
    hideAll();
    $('#row0').hide();
    $('#row1').show();
})

$('#category').on('click',function(){
    hideAll();
    $('#row0').hide();
    $('#row2').show();
})

$('#auction').on('click',function(){
    hideAll();
    $('#row0').hide();
    $('#row3').show();
})

$('#complete').on('click',function(){
    hideAll();
    $('#row0').hide();
    $('#row4').show();
})

$('#highlight').on('click',function(){
    hideAll();
    $('#row0').hide();
    $('#row5').show();
})

format();

});



function hideAll(){

    $('#row1').hide();
    $('#row2').hide();
    $('#row3').hide();
    $('#row4').hide();
    $('#row5').hide();

}


function format(){
    var numberString = $('.rupees').text();
    var formatted = numberString.replace(/\d+/g, n => Number(n).toLocaleString('ta-IN'))
    $('.rupees').html(formatted);
    }


