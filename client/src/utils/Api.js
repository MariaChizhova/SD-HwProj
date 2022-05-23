/**
 * Returns the homework of the works sorted by the proximity of the deadline,
 * and the publication date of which has already arrived
 * @param callback
 */
export function student_homework(callback) {
    const apiUrl = 'http://localhost:8080/hwproj/homework/student';
    fetch(apiUrl)
        .then((response) => response.json())
        .then((data) => callback(data));
}

/**
 * Returns all attempts to solve homework
 * @param homeworkId
 * @param callback
 */
export function all_submissions(homeworkId, callback) {
    const apiUrl = `http://localhost:8080/hwproj/submission/${homeworkId}`;
    fetch(apiUrl)
        .then((response) => response.json())
        .then((data) => callback(data));
}

/**
 * Returns the full description of the homework
 * @param homeworkId
 * @param callback
 */
export function homework(homeworkId, callback) {
    const apiUrl = `http://localhost:8080/hwproj/homework/${homeworkId}`;
    fetch(apiUrl)
        .then((response) => response.json())
        .then((data) => callback(data));
}

/**
 * Returns attempt to solve homework
 * @param homeworkId
 * @param id
 * @param callback
 */
export function submission(homeworkId, id, callback) {
    const apiUrl = `http://localhost:8080/hwproj/submission/${homeworkId}/${id}`;
    fetch(apiUrl)
        .then((response) => response.json())
        .then((data) => callback(data));
}

/**
 * Returns all homeworks
 * @param callback
 */
export function teacher_homework(callback) {
    const apiUrl = 'http://localhost:8080/hwproj/homework/teacher';
    fetch(apiUrl)
        .then((response) => response.json())
        .then((data) => callback(data));
}

/**
 * Sends a new submission
 * @param homeworkId
 * @param time
 * @param solution
 * @param callback
 */
export function send_new_submission(homeworkId, time, solution, callback) {
    const apiUrl = 'http://localhost:8080/hwproj/submission/add';
    const requestOptions = {
        method: 'POST',
        headers: {
            "Content-Type": "application/json",
            "Access-Control-Allow-Origin": "*"
        },
        body: JSON.stringify({homeworkId: homeworkId, time: time, solution: solution})
    };
    fetch(apiUrl, requestOptions)
        .then((response) => response.json())
        .then((data) => callback(data));
}

/**
 * Sends a new homework
 * @param name
 * @param description
 * @param publication
 * @param deadline
 * @param callback
 */
export function send_new_homework(name, description, publication, deadline, callback) {
    const apiUrl = 'http://localhost:8080/hwproj/homework/add';
    const requestOptions = {
        method: 'POST',
        headers: {
            "Content-Type": "application/json",
            "Access-Control-Allow-Origin": "*"
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


