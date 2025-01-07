let dots = JSON.parse(localStorage.getItem('dots')) || [];
window.onload = function() {
    const canvas = document.getElementById('canvas');
    const ctx = canvas.getContext('2d');
    const centerX = canvas.width / 2;
    const centerY = canvas.height / 2;

    let selectedR = null;

    // Функция рисования осей и меток
    function drawAxes() {
        ctx.clearRect(0, 0, canvas.width, canvas.height);

        const figureScale = selectedR ? selectedR * 50 : 50;
        const axisScale = 50; // Уменьшенный масштаб для осей

        // 1-я четверть: квадрат
        ctx.beginPath();
        ctx.rect(centerX, centerY - figureScale, figureScale, figureScale);
        ctx.fillStyle = 'blue';
        ctx.fill();

        // 2-я четверть: четверть круга
        ctx.beginPath();
        ctx.moveTo(centerX, centerY);
        ctx.arc(centerX, centerY, figureScale, Math.PI, 3 * Math.PI / 2, false);
        ctx.closePath();
        ctx.fillStyle = 'blue';
        ctx.fill();

        // 3-я четверть: треугольник
        ctx.beginPath();
        ctx.moveTo(centerX, centerY);
        ctx.lineTo(centerX - figureScale / 2, centerY);
        ctx.lineTo(centerX, centerY + figureScale / 2);
        ctx.closePath();
        ctx.fillStyle = 'blue';
        ctx.fill();

        // Оси и метки
        ctx.fillStyle = 'black';
        ctx.font = '12px sans-serif'; // Уменьшенный размер текста для меток

        const axisLength = Math.min(canvas.width, canvas.height) / 2 - 20;

        for (let i = -4; i <= 4; i++) {
            const pos = i * axisScale;
            if (i !== 0 && Math.abs(pos) <= axisLength) {
                // Метки и деления на оси X
                ctx.fillText(i.toFixed(1), centerX + pos - 10, centerY + 15);
                ctx.beginPath();
                ctx.moveTo(centerX + pos, centerY - 5);
                ctx.lineTo(centerX + pos, centerY + 5);
                ctx.stroke();

                // Метки и деления на оси Y
                ctx.fillText(i.toFixed(1), centerX - 25, centerY - pos + 5);
                ctx.beginPath();
                ctx.moveTo(centerX - 5, centerY - pos);
                ctx.lineTo(centerX + 5, centerY - pos);
                ctx.stroke();
            }
        }

        // Центр графика
        ctx.fillText('0', centerX + 5, centerY - 5);

        // Ось X
        ctx.beginPath();
        ctx.moveTo(centerX - axisLength, centerY);
        ctx.lineTo(centerX + axisLength, centerY);
        ctx.strokeStyle = 'black';
        ctx.lineWidth = 2;
        ctx.stroke();

        // Стрелка оси X
        ctx.beginPath();
        ctx.moveTo(centerX + axisLength - 10, centerY - 5);
        ctx.lineTo(centerX + axisLength, centerY);
        ctx.lineTo(centerX + axisLength - 10, centerY + 5);
        ctx.fillStyle = 'black';
        ctx.fill();

        // Ось Y
        ctx.beginPath();
        ctx.moveTo(centerX, centerY - axisLength);
        ctx.lineTo(centerX, centerY + axisLength);
        ctx.strokeStyle = 'black';
        ctx.lineWidth = 2;
        ctx.stroke();

        // Стрелка оси Y
        ctx.beginPath();
        ctx.moveTo(centerX - 5, centerY - axisLength + 10);
        ctx.lineTo(centerX, centerY - axisLength);
        ctx.lineTo(centerX + 5, centerY - axisLength + 10);
        ctx.fillStyle = 'black';
        ctx.fill();
    }



    function drawPoint(x, y) {
        ctx.beginPath();
        ctx.arc(centerX + x, centerY - y, 5, 0, 2 * Math.PI);
        ctx.fillStyle = 'green';
        ctx.fill();
    }

    function drawAllPoints() {
        dots.forEach(function(dot) {
            drawPoint(dot.x, dot.y);
        });
    }

    canvas.addEventListener('click', function(event) {
        const radiusInput = document.querySelector('input[name="radius"]');
        const R = parseFloat(radiusInput.value);

        if (isNaN(R) || R < 1 || R > 4) {
            showToast("Пожалуйста, введите значение R от 1 до 4 перед нажатием на канвас.");
            return;
        }

        const rect = canvas.getBoundingClientRect();
        const clickX = (event.clientX - rect.left - centerX);
        const clickY = (centerY - (event.clientY - rect.top));

        const x = (clickX / (R * 50)) * R;
        const y = (clickY / (R * 50)) * R;

        dots.push({ x: clickX, y: clickY });
        localStorage.setItem('dots', JSON.stringify(dots));

        drawAxes();
        drawAllPoints();

        window.location.href = `controller?x[]=${encodeURIComponent(x.toFixed(8))}&y=${encodeURIComponent(y.toFixed(8))}&radius=${encodeURIComponent(R)}`;

    });

// Обработчик изменения R
    const radiusInput = document.querySelector('input[name="radius"]');
    radiusInput.addEventListener('input', (event) => {
        const value = parseFloat(event.target.value);

        if (!isNaN(value) && value >= 1 && value <= 4) {
            selectedR = value;
            drawAxes();
            drawAllPoints();
        } else {
            showToast("Введите значение R от 1 до 4.");
        }
    });

// Изначальная отрисовка
    drawAxes();
    drawAllPoints();

};