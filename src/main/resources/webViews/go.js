//Center the map on a location
var myLatlng = new google.maps.LatLng(38.536056, -106.000932);
map.setCenter(myLatlng);
var marker = new google.maps.Marker({
    position: myLatlng,
    map: map,
    title: 'Hello World!'
});