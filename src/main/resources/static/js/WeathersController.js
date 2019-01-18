var WeathersController = (function () {

    function clearTables() {
        var content = document.getElementById("tablahere");
        var tables = document.getElementsByClassName("table");
        while (tables.length > 0) {
            content.removeChild(tables[0]);
        }
        var titles = document.getElementsByClassName("table-title");
        while (titles.length > 0) {
            content.removeChild(titles[0]);
        }
    }


    function addWeathers(Weather) {
        console.log(Weather)
        
        var tableOrder = document.createElement("table");

        var header = document.createElement("tr");

        var cell = document.createElement("th");
        cell.innerHTML = "Description";
        header.appendChild(cell);

        var cell = document.createElement("th");
        cell.innerHTML = "Wind";
        header.appendChild(cell);

        var cell = document.createElement("th");
        cell.innerHTML = "Cloudiness";
        header.appendChild(cell);

        var cell = document.createElement("th");
        cell.innerHTML = "Pressure";
        header.appendChild(cell);

        var cell = document.createElement("th");
        cell.innerHTML = "Humidity";
        header.appendChild(cell);

        var cell = document.createElement("th");
        cell.innerHTML = "Temperature";
        header.appendChild(cell);

        var cell = document.createElement("th");
        cell.innerHTML = "Geo coords";
        header.appendChild(cell);

        header.setAttribute("class", "bg-info");
        
        tableOrder.appendChild(header);
        
        tableOrder.setAttribute("class", "table");
        
        var row = document.createElement("tr");

        var cell = document.createElement("td");
        cell.innerHTML = Weather.weather[0].description;
        row.appendChild(cell);
        
        var cell = document.createElement("td");
        cell.innerHTML = "Deg : "+Weather.wind.deg+" Speed: "+Weather.wind.speed;
        row.appendChild(cell);

        var cell = document.createElement("td");
        cell.innerHTML = Weather.clouds.all;
        row.appendChild(cell);

        var cell = document.createElement("td");
        cell.innerHTML = Weather.main.pressure;
        row.appendChild(cell);

        var cell = document.createElement("td");
        cell.innerHTML = Weather.main.humidity;
        row.appendChild(cell);

        var cell = document.createElement("td");
        cell.innerHTML = Weather.main.temp;
        row.appendChild(cell);

        var cell = document.createElement("td");
        cell.innerHTML = "Lat: "+Weather.coord.lat +" Lon: "+Weather.coord.lon;
        row.appendChild(cell);

        tableOrder.appendChild(row);
            
        var firstTable = document.getElementById("HTMLtable");

        document.getElementById("tablahere").appendChild(tableOrder);
    }

    function getSelected(id) {
        var selectedTable = document.getElementById(id);
        var tableLabel = selectedTable.options[selectedTable.selectedIndex].value;
        return tableLabel;
    }


    function loadWeathers() {
        clearTables();
        loadData(addWeathers);
    }

    function loadData(callback) {
        axios.all([filterSelected()])
                .then(axios.spread(function (weather) {
                    callback(weather);
                }));
    }

    function filterSelected() {
        var city = document.getElementById("city").value;
        return WeathersRestController.getWeathers(city);
    }


    return {
        loadWeathers: loadWeathers
    };
})();