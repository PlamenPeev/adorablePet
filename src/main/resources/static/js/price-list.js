let loadPricesBtn = document.getElementById("loadPrices");

loadPricesBtn.addEventListener('click', reloadPrices)


function reloadPrices() {

    let pricesCntr = document.getElementById('prices-container')
    pricesCntr.innerHTML = ''

    fetch("http://localhost:8080/api/manipulations").
    then(response => response.json()).
    then(json => json.forEach(manipulation => {
        // create row
        let row = document.createElement('tr')

        let titleCol = document.createElement('td')
        let typeCol = document.createElement('td')
        let priceCol = document.createElement('td')



        //typeOfManipulation
        titleCol.textContent = manipulation.title
        // manipulation
        typeCol.textContent = manipulation.type.name
        priceCol.textContent = manipulation.price

        row.appendChild(titleCol)
        row.appendChild(typeCol)
        row.appendChild(priceCol)


        pricesCntr.appendChild(row)
    }))


}
