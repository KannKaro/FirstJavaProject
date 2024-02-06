function addNumbersPOSTFunction() {
    let number1 = document.getElementById('number1').value 
    let number2 = document.getElementById('number2').value
    
    fetch('/addNumbersPOST', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            numberForPostMethod1: number1,
            numberForPostMethod2: number2
        })
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok')
        }
        return response.json()
    })
    .then(data => {
        document.getElementById("result").innerText = "Result: " + data
    })
}

function addNumbersGETFunction() {
    let number1 = document.getElementById('number1').value 
    let number2 = document.getElementById('number2').value

    fetch('/addNumbers?number1=' + number1 + '&number2=' + number2)
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json()
    })
    .then(data => {
     document.getElementById("result").innerText = "Result: " + data;
    })
}

