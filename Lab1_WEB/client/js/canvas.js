window.onload = function () {
    const canvas = document.getElementById('canvas');
    const ctx = canvas.getContext('2d');

    const R = 200; // Радиус

    // Центр координат
    const centerX = canvas.width / 2;
    const centerY = canvas.height / 2;

    // Очистка канваса (на всякий случай)
    ctx.clearRect(0, 0, canvas.width, canvas.height);

    // Четверть круга (во второй четверти)
    ctx.beginPath();
    ctx.arc(centerX, centerY, R / 2, Math.PI, 1.5 * Math.PI, false); // Четверть круга
    ctx.lineTo(centerX, centerY);
    ctx.closePath();
    ctx.fillStyle = 'blue';
    ctx.fill();

    // Прямоугольник (в третьей четверти)
    ctx.beginPath();
    ctx.moveTo(centerX, centerY); // (0, 0)
    ctx.lineTo(centerX - R, centerY); // (-R, 0)
    ctx.lineTo(centerX - R, centerY + R / 2); // (-R, -R/2)
    ctx.lineTo(centerX, centerY + R / 2); // (0, -R/2)
    ctx.closePath();
    ctx.fillStyle = 'blue';
    ctx.fill();

    // Треугольник (в четвёртой четверти)
    ctx.beginPath();
    ctx.moveTo(centerX, centerY); // (0, 0)
    ctx.lineTo(centerX + R, centerY); // (R, 0)
    ctx.lineTo(centerX, centerY + R / 2); // (0, -R/2)
    ctx.closePath();
    ctx.fillStyle = 'blue';
    ctx.fill();

    // Оси
    ctx.beginPath();
    // Ось X
    ctx.moveTo(0, centerY);
    ctx.lineTo(canvas.width, centerY);
    // Ось Y
    ctx.moveTo(centerX, 0);
    ctx.lineTo(centerX, canvas.height);
    ctx.strokeStyle = 'black';
    ctx.lineWidth = 2;
    ctx.stroke();

    // Подписи
    ctx.fillStyle = 'black';
    ctx.font = '16px sans-serif';

    // R
    ctx.fillText('R', centerX + R, centerY - 5);
    ctx.fillText('R', centerX - 15, centerY - R);
    ctx.fillText('-R', centerX - R - 15, centerY - 5);
    ctx.fillText('-R', centerX - 15, centerY + R + 5);

    // R/2
    ctx.fillText('R/2', centerX + R / 2, centerY - 5);
    ctx.fillText('R/2', centerX - 15, centerY - R / 2);
    ctx.fillText('-R/2', centerX - R / 2 - 20, centerY - 5);
    ctx.fillText('-R/2', centerX - 15, centerY + R / 2 + 5);

    // 0 в центре
    ctx.fillText('0', centerX + 5, centerY - 5);
};
