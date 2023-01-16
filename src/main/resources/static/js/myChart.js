let chartDataString = decodeHtml(chartData);
let chartJsonArray = JSON.parse(chartDataString);

let arrayLength = chartJsonArray.length;

let numericData = [];
let labelData = [];

for (let i = 0; i < arrayLength; i++) {
    numericData[i] = chartJsonArray[i].amount;
    labelData[i] = chartJsonArray[i].label;
}

const ctx = document.getElementById('myPieChart');

new Chart(ctx, {
    type: 'pie',
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ['rgba(62, 149, 205, 1)', 'rgba(142, 94, 162, 1)', 'rgba(60, 186, 159, 1)'],
            data: numericData,
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        },
        plugins: {
            title: {
                display: true,
                text: 'Project Statuses'
            }
        }
    }
})

// "[{"value": 1, "label": "COMPLETED"}, {"value": 1, "label": "INPROGRESS"}, {"value": 1, "label": "NOTSTARTED"}]"
function decodeHtml(html){
    let txt = document.createElement('textarea');
    txt.innerHTML = html;
    return txt.value;
}
