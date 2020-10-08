/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function(){
    $("[data-trigger]").on("click", function(){
        var targeet_id =$(this).attr('data-trigger');
        $(targeet_id).toggleClass("show");
        $('body').toggleClass("offcanvas-active");
    });
    
    //close button menu
    $(".btn-close").click(function(e){
        $(".navbar-collapse").removeClass("show");
        $("body").removeClass("offcanvas-active");        
    });
})
