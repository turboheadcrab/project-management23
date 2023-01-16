const ctx = document.getElementById('myPieChart');

new Chart(ctx, {
    type: 'pie',
    data: {
        labels: ['January', 'February', 'March'],
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ['rgba(62, 149, 205, 1)', 'rgba(142, 94, 162, 1)', 'rgba(60, 186, 159, 1)'],
            data: [5, 10, 5],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
})
