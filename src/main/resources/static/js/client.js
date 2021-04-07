client = (function (){
	return {
		getWeatherInformation: function(city, callback){
			var getStat = $.getJSON("/weather/"+city, function(){
				response = getStat.responseText;
			}).done(()=>{
				callback(JSON.parse(getStat.responseText));
			}).fail(()=>{
				alert("Something went wrong with the query");
			});
		}
	}
})();