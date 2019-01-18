var WeathersRestController = (function () {
    var url = '';

    function getWeathers(city) {
        return axios.get(url+"/weather/"+city).then(function (response) {
            return response.data;
        })
    }

    return {
        getWeathers: getWeathers
    };
})();