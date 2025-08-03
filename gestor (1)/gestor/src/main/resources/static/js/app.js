document.addEventListener('DOMContentLoaded', function () {
    const form = document.getElementById('formTarea');
    const mensaje = document.getElementById('mensaje');

    form.addEventListener('submit', async function (e) {
        e.preventDefault(); // Evita el recargo

        const nuevaTarea = {
            titulo: document.getElementById('titulo').value,
            descripcion: document.getElementById('descripcion').value,
            completado: document.getElementById('completado').value
        };

        fetch('api/tareas', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(nuevaTarea)
        })
            .then(response => {
                if (response.ok) {
                    return response.json().then(data => {
                        alert('Tarea agregada correctamente');
                        form.reset();
                    }).catch(() => {
                        alert('Tarea agregada correctamente (sin cuerpo)');
                        form.reset();
                    });

                } else {
                    return response.text().then(text => {
                        console.error('Respuesta error', text);
                        alert('Error al agregar la tarea');
                    });
                }
            })
            .catch(error => {
                console.error('Error:', error);
                alert('Error de conexión con el servidor');
            });
    });
});
