function showToast(message) {
    const toast = document.getElementById("toast");
    toast.textContent = message;
    toast.classList.add("show");

    setTimeout(function() {
        toast.classList.remove("show");
        toast.textContent = "";
    }, 3000);
}

document.addEventListener("DOMContentLoaded", () => {
    loadResults();

    document.getElementById("submit").addEventListener("click", function(event) {
        event.preventDefault();

        // Get X values
        const xSelect = Array.from(document.querySelectorAll('input[name="x-value"]:checked'));
        if (xSelect.length === 0) {
            showToast("Выберите хотя бы одно значение X.");
            return;
        }
        const xValues = xSelect.map(input => parseFloat(input.value));

        // Get Y
        const yInput = document.getElementById("y-input").value.replace(",", ".");
        if (!isValidY(yInput)) {
            showToast("Неверное значение Y. Оно должно быть числом от -3 до 5, а число знаков после запятой не должно превышать 10.");
            return;
        }

        // Get R
        const rInput = document.getElementById("r-input").value.replace(",", ".");
        if (!isValidR(rInput)) {
            showToast("Неверное значение R. Оно должно быть числом от 1 до 4 включительно.");
            return;
        }
        const r = parseFloat(rInput);

        const y = parseFloat(yInput);

        xValues.forEach(x => {
            const params = new URLSearchParams({ x, y, r }).toString();
            const url = `http://localhost:8080/fcgi-bin/app.jar?${params}`;

            fetch(url, {
                method: "GET",
                headers: {
                    'Accept': 'application/json'
                }
            })
                .then(resp => {
                    if (!resp.ok) {
                        console.log('Ошибка ответа от сервера...');
                        return resp.text().then(text => { throw new Error(text) });
                    }
                    return resp.json();
                })
                .then(result => {
                    const parsedResponse = JSON.parse(result.response);
                    saveResults(x, y, r, parsedResponse.hit, result.currentTime, result.elapsedTime);
                    addResultToTable(x, y, r, parsedResponse.hit, result.currentTime, result.elapsedTime);
                })
                .catch(error => {
                    console.error("Произошла ошибка:", error);
                });
        });
    });


    document.getElementById("clearResults").addEventListener("click", function() {
        clearResults();
        document.getElementById("result-body").innerHTML = ""; // Очистить таблицу
        showToast("Результаты очищены.");
    });

    function isValidY(value) {
        const y = parseFloat(value);
        return !isNaN(y) && y >= -3 && y <= 5 && /^-?\d*(\.\d{1,10})?$/.test(value);
    }


    function isValidR(value) {
        const r = parseFloat(value);
        return !isNaN(r) && r >= 1 && r <= 4 && /^\d*(\.\d{1,10})?$/.test(value);
    }

    function addResultToTable(x, y, r, hit, currentTime, elapsedTime) {
        const resultBody = document.getElementById("result-body");
        const newRow = document.createElement("tr");

        const xCell = document.createElement("td");
        xCell.textContent = x;

        const yCell = document.createElement("td");
        yCell.textContent = y;

        const rCell = document.createElement("td");
        rCell.textContent = r;

        const resultCell = document.createElement("td");
        resultCell.textContent = hit ? "Hit" : "Miss";

        const currentTimeCell = document.createElement("td");
        currentTimeCell.textContent = currentTime;

        const elapsedTimeCell = document.createElement("td");
        elapsedTimeCell.textContent = elapsedTime + " ms";

        newRow.appendChild(xCell);
        newRow.appendChild(yCell);
        newRow.appendChild(rCell);
        newRow.appendChild(resultCell);
        newRow.appendChild(currentTimeCell);
        newRow.appendChild(elapsedTimeCell);

        resultBody.appendChild(newRow);
    }

    function saveResults(x, y, r, hit, currentTime, elapsedTime) {
        const storedResults = JSON.parse(localStorage.getItem('results')) || [];
        storedResults.push({ x, y, r, hit, currentTime, elapsedTime });
        localStorage.setItem('results', JSON.stringify(storedResults));
    }

    function loadResults() {
        const storedResults = JSON.parse(localStorage.getItem('results'));
        if (storedResults) {
            storedResults.forEach(result => {
                addResultToTable(result.x, result.y, result.r, result.hit, result.currentTime, result.elapsedTime);
            });
        }
    }

    function clearResults() {
        localStorage.removeItem('results'); // Удаляем результаты из localStorage
        document.getElementById("result-body").innerHTML = ""; // Очищаем таблицу
    }
});
