import React, { useState, useEffect } from "react";

function App() {
  const [students, setStudents] = useState([]);
  const [name, setName] = useState("");
  const [age, setAge] = useState("");

  // Fetch students
  useEffect(() => {
    fetch("http://localhost:8080/api/students")
      .then(res => res.json())
      .then(data => setStudents(data));
  }, []);

  // Add student
  const addStudent = () => {
    fetch("http://localhost:8080/api/students", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ name, age }),
    })
      .then(res => res.json())
      .then(student => setStudents([...students, student]));
    setName("");
    setAge("");
  };

  // Delete student
  const deleteStudent = (id) => {
    fetch(`http://localhost:8080/api/students/${id}`, { method: "DELETE" })
      .then(() => setStudents(students.filter(s => s.id !== id)));
  };

  return (
    <div style={{ textAlign: "center", marginTop: "50px" }}>
      <h1>Student Record System</h1>
      <input
        type="text"
        placeholder="Enter name"
        value={name}
        onChange={(e) => setName(e.target.value)}
      />
      <input
        type="number"
        placeholder="Enter age"
        value={age}
        onChange={(e) => setAge(e.target.value)}
      />
      <button onClick={addStudent}>Add Student</button>

      {students.length === 0 ? (
        <p>No records</p>
      ) : (
        <ul style={{ listStyle: "none", padding: 0 }}>
          {students.map(student => (
            <li key={student.id}>
              {student.name} ({student.age} years){" "}
              <button onClick={() => deleteStudent(student.id)}>Delete</button>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}

export default App;
