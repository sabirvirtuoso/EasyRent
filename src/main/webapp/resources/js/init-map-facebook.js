
function initialize() {
    var mapCanvasOne = document.getElementById('map-canvas');

    var lat = $("input#latitude").val();
    var lng = $("input#longitude").val();
    var mapOptions = {
        center: new google.maps.LatLng(lat, lng),
        zoom: 15,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    }

    var mapShow = new google.maps.Map(mapCanvasOne, mapOptions);

    var markerShow = new google.maps.Marker({
        position: new google.maps.LatLng(lat, lng),
        map: mapShow,
        title:"Rental Location"
    });

}

google.maps.event.addDomListener(window, 'load', initialize);


(function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.3&appId=193893004094724";
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));
