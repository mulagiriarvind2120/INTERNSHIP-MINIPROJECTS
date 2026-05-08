import React, { useState, useEffect } from "react";

function App() {
  const [tasks, setTasks] = useState([]);
  const [newTask, setNewTask] = useState("");

  // Fetch tasks from backend
  useEffect(() => {
    fetch("http://localhost:8080/api/tasks")
      .then(res => res.json())
      .then(data => setTasks(data));
  }, []);

  // Add task
  const addTask = () => {
    fetch("http://localhost:8080/api/tasks", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ title: newTask }),
    })
      .then(res => res.json())
      .then(task => setTasks([...tasks, task]));
    setNewTask("");
  };

  // Delete task
  const deleteTask = (id) => {
    fetch(`http://localhost:8080/api/tasks/${id}`, { method: "DELETE" })
      .then(() => setTasks(tasks.filter(task => task.id !== id)));
  };

  return (
    <div style={{ textAlign: "center", marginTop: "50px" }}>
      <h1>Full Stack To-Do App</h1>
      <input
        type="text"
        placeholder="Enter task..."
        value={newTask}
        onChange={(e) => setNewTask(e.target.value)}
      />
      <button onClick={addTask}>Add Task</button>

      {tasks.length === 0 ? (
        <p>No tasks</p>
      ) : (
        <ul style={{ listStyle: "none", padding: 0 }}>
          {tasks.map(task => (
            <li key={task.id}>
              {task.title}{" "}
              <button onClick={() => deleteTask(task.id)}>Delete</button>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}

export default App;
