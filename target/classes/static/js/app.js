var app = (function(){
	var apiClient=client;

	function initialize(){
		initMap();
	}

	function wipeTable(tableName){
        $("#"+tableName).empty();
    }

    var initMap = function(){
        map = new google.maps.Map(document.getElementById("map"), {
            zoom:7,
            center: {lat: 12.0, lng: 30.0},
        });
    }

    function plotMarkers(m) {        
        markers = [];
        bounds = new google.maps.LatLngBounds();
        
        var position = new google.maps.LatLng(m.lat, m.lon);
        
        markers.push(
            new google.maps.Marker({
                position: position,
                map: map,
                animation: google.maps.Animation.DROP
            })
        );
        bounds.extend(position);
        map.fitBounds(bounds);
        map.setZoom(4);
    }

    var retrieveWeatherInformation=(weatherInfo)=>{
    	$("#cityTittle").text(weatherInfo.name);
    	$("#weatherInformation > tbody").append(
			`
			<tr>
				<td>${weatherInfo.name}</td>
				<td>${weatherInfo.weather.main}</td>
				<td>${weatherInfo.weather.description}</td>
				<td>${weatherInfo.temperature.temp}</td>
				<td>${weatherInfo.temperature.tempMax}</td>
				<td>${weatherInfo.temperature.tempMin}</td>
				<td>${weatherInfo.wind.speed}</td>
			</tr>
			`
		);
    	
		plotMarkers(weatherInfo.location);	
    }

    var searchWeather = (weather)=>{
    	wipeTable("weatherInformationBody");
		apiClient.getWeatherInformation(weather, retrieveWeatherInformation);

	}
	return {
		searchWeather:(weather)=>{
			searchWeather(weather)
		},

		initialize:()=>{
			initialize();
		}
	}
})();