
export function student_homework(callback) {
    const apiUrl = 'http://localhost:8080/hwproj/homework/student';
    fetch(apiUrl)
        .then((response) => response.json())
        .then((data) => callback(data));
}

export function all_submissions(homeworkId, callback) {
    const apiUrl = `http://localhost:8080/hwproj/submission/${homeworkId}`;
    fetch(apiUrl)
        .then((response) => response.json())
        .then((data) => callback(data));
}

export function homework(homeworkId, callback) {
    const apiUrl = `http://localhost:8080/hwproj/homework/${homeworkId}`;
    fetch(apiUrl)
        .then((response) => response.json())
        .then((data) => callback(data));
}

export function submission(homeworkId, id, callback) {
    const apiUrl = `http://localhost:8080/hwproj/submission/${homeworkId}/${id}`;
    fetch(apiUrl)
        .then((response) => response.json())
        .then((data) => callback(data));
}

export function teacher_homework(callback) {
    const apiUrl = 'http://localhost:8080/hwproj/homework/teacher';
    fetch(apiUrl)
        .then((response) => response.json())
        .then((data) => callback(data));
}

export function send_new_submission(time, solution, callback) {
    const apiUrl = 'http://localhost:8080/hwproj/submission/add';
    const requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ time: time, solution: solution })
    };
    fetch(apiUrl, requestOptions)
        .then((response) => response.json())
        .then((data) => callback(data));
}

export function send_new_homework(name, description, publication, deadline,  callback) {
    const apiUrl = 'http://localhost:8080/hwproj/homework/add';
    const requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            name: name,
            description: description,
            publication: publication,
            deadline: deadline
        })
    };
    fetch(apiUrl, requestOptions)
        .then((response) => response.json())
        .then((data) => callback(data));
}


