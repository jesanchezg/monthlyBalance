var chartDataStr = decodeHtml(chartData);
console.log("chartDataStr=> "+chartDataStr);
var chartJsonArray = JSON.parse(chartDataStr)
console.log("chartJsonArray=> "+chartJsonArray);

var arrayLength = chartJsonArray.length;
var numericData = [];
var labelData = [];

for(var i=0; i < arrayLength; i++){
	numericData[i] = chartJsonArray[i].sumOfValues;
	labelData[i] = chartJsonArray[i].fullName;
//	console.log("chartJsonArray["+i+"]=> "+chartJsonArray[i]);
}

//For a pie chart
new Chart(document.getElementById("myPieChart"), {
	type: 'pie',
    // The data for our dataset
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#3e94js", "#9e84de", "#3cba8f"],
//            backgroundColor: 'rgb(255, 99, 132)',
            borderColor: 'rgb(255, 99, 132)',
            data: numericData
        }]
    },

    // Configuration options go here
    options: {
    	title: {
    		display: true,
    		text: 'Total % payments by User'
    	}
    }
});

// [{"fullName": "Jairo Ernesto Sanchez Galvis", "sumOfValues": 12},{"fullName": "Culiuscucu","sumOfValues": 345}]
function decodeHtml(html){
	var txtArea = document.createElement("textarea");
	txtArea.innerHTML = html;
	return txtArea.value;
}