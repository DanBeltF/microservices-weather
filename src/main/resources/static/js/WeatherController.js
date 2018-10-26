/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function getClimaCiudad(ciudad){
    axios.get('/weather/' + ciudad)
        .then(function (response) {
            console.log(response.data);
            var txt = response.data;
            var obj = JSON.parse(txt);
            document.getElementById("tableDiv").innerHTML = "coord: " + obj.coord + ", weather: " + obj.weather + "main" + obj.main ;
    })
        .catch(function (error) {
            // handle error
            console.log(error.data);
    });
    
}