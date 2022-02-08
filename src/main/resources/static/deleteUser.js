function deleteUser(id) {
    fetch('http://localhost:8080/admin/users/' + id, {
        method: 'DELETE',
        headers: {"Content-type": "application/json; charset=UTF-8"}
    })
        .then(response => {
            $('#' + id).remove();
        });
}



//headers – объект с запрашиваемыми заголовками (не все заголовки разрешены)
/* вызов .then прикреплён к fetch, чтобы, когда ответ получен,
сразу начинать считывание данных с помощью .json(), не дожидаясь завершения других запросов.*/