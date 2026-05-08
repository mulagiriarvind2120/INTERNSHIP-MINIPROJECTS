import React, { useState } from "react";

function StudentForm({ addStudent }) {
  const [input, setInput] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    addStudent(input);
    setInput("");
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        type="text"
        placeholder="Enter student name..."
        value={input}
        onChange={(e) => setInput(e.target.value)}
      />
      <button type="submit">Add Student</button>
    </form>
  );
}

export default StudentForm;
