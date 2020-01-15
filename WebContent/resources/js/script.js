
    $(document).ready(function() {
        'use strict'; 
        // Links Add Active Class
        $('.links li a').click(function () {
            $(this).parent('li').addClass('active').siblings().removeClass('active');
        });

     
    });    