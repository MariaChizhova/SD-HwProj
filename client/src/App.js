import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import HomeworksStudent from "./student_homeworks/HomeworksStudent";
import React from "react";
import Submissions from "./submission/Submissions";
import ViewingSubmission from "./viewing_submission/ViewingSubmission";
import HomeworksTeacher from "./teacher_homeworks/HomeworksTeacher";
import NewSubmission from "./new_submission/NewSubmission";
import NewHomework from "./new_homework/NewHomework";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/student" element={<HomeworksStudent/>}/>
                <Route path="/student/submissions" element={<Submissions back="student"/>}/>
                <Route path="/student/submissions/submission" element={<ViewingSubmission/>}/>
                <Route path="/student/new-submission" element={<NewSubmission/>}/>
                <Route path="/teacher" element={<HomeworksTeacher/>}/>
                <Route path="/teacher/new-homework" element={<NewHomework/>}/>
                <Route path="/teacher/submissions" element={<Submissions back="teacher"/>}/>
                <Route path="/teacher/submissions/submission" element={<ViewingSubmission/>}/>
            </Routes>
        </BrowserRouter>
    );
}

export default App;
