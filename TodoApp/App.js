import React, { useState } from "react";

function App() {
  const [task, setTask] = useState("");
  const [list, setList] = useState([]);

  const addTask = () => {
    if (task.trim() === "") return;
    setList([...list, task]);
    setTask("");
  };

  const deleteTask = (index) => {
    const newList = list.filter((_, i) => i !== index);
    setList(newList);
  };

  return (
    <div style={{ textAlign: "center", marginTop: "50px" }}>
      <h2>To-Do App</h2>

      <input
        value={task}
        onChange={(e) => setTask(e.target.value)}
        placeholder="Enter task"
      />
      <button onClick={addTask}>Add</button>

      <ul>
        {list.map((t, i) => (
          <li key={i}>
            {t}
            <button onClick={() => deleteTask(i)}> ❌ </button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
