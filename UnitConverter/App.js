import React, { useState } from "react";

function App() {
  const [value, setValue] = useState("");
  const [result, setResult] = useState("");
  const [type, setType] = useState("kmToMiles");

  const convert = () => {
    let val = parseFloat(value);

    if (isNaN(val)) {
      setResult("Enter valid number");
      return;
    }

    let res = "";

    switch (type) {
      case "kmToMiles":
        res = val * 0.621371 + " miles";
        break;
      case "milesToKm":
        res = val * 1.60934 + " km";
        break;
      case "kgToPounds":
        res = val * 2.20462 + " pounds";
        break;
      case "poundsToKg":
        res = val * 0.453592 + " kg";
        break;
      default:
        res = "";
    }

    setResult(res);
  };

  return (
    <div style={{ textAlign: "center", marginTop: "50px" }}>
      <h2>Unit Converter</h2>

      <input
        type="text"
        placeholder="Enter value"
        value={value}
        onChange={(e) => setValue(e.target.value)}
      />

      <br /><br />

      <select onChange={(e) => setType(e.target.value)}>
        <option value="kmToMiles">KM → Miles</option>
        <option value="milesToKm">Miles → KM</option>
        <option value="kgToPounds">KG → Pounds</option>
        <option value="poundsToKg">Pounds → KG</option>
      </select>

      <br /><br />

      <button onClick={convert}>Convert</button>

      <h3>{result}</h3>
    </div>
  );
}

export default App;
