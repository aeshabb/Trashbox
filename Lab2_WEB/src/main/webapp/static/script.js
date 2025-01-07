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
    const form = document.getElementById("form-1");
    form.addEventListener("submit", function(event) {
        event.preventDefault(); // Отменяет стандартное поведение формы

        // Получаем все отмеченные значения X
        const selectedX = Array.from(document.querySelectorAll('input[name="x[]"]:checked')).map(input => input.value);
        if (selectedX.length === 0) {
            showToast("Выберите хотя бы одно значение X.");
            return;
        }

        // Получаем значение Y
        const yInput = document.getElementById("y-input").value.replace(",", ".");
        if (!isValidY(yInput)) {
            showToast("Неверное значение Y. Оно должно быть числом от -5 до 3, а число знаков после запятой не должно превышать 10.");
            return;
        }

        // Получаем значениe R
        const radius = document.getElementById("radius-input").value.replace(",", ".");
        if (!isValidR(radius)) {
            showToast("Неверное значение R. Оно должно быть числом от 1 до 4, а число знаков после запятой не должно превышать 10.");
            return;
        }
        form.submit()
    })


    function isValidY(value) {
        const y = parseFloat(value);
        return !isNaN(y) && y >= -5 && y <= 3;
    }
    function isValidR(value) {
        const r = parseFloat(value);
        return !isNaN(r) && r >= 1 && r <= 4;
    }
    document.getElementById("clear").addEventListener("click", function(event) {
        localStorage.clear();
        window.location.reload();
    })

});