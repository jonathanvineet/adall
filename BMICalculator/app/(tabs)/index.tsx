import * as React from "react";
import { useState } from "react";
import {
  View, Text, TextInput, TouchableOpacity,
  StyleSheet, SafeAreaView, StatusBar, Alert
} from "react-native";

export default function HomeScreen() {
  const [height, setHeight] = useState("");
  const [weight, setWeight] = useState("");
  const [bmi, setBmi] = useState<string | null>(null);
  const [category, setCat] = useState("");

  function calculate() {
    const h = parseFloat(height) / 100;   // cm to m
    const w = parseFloat(weight);
    if (!h || !w || h <= 0 || w <= 0) {
      Alert.alert("Invalid Input", "Enter valid height and weight");
      return;
    }
    const b = (w / (h * h)).toFixed(1);
    setBmi(b);
    if (parseFloat(b) < 18.5)      setCat("Underweight");
    else if (parseFloat(b) < 25)   setCat("Normal Weight ✅");
    else if (parseFloat(b) < 30)   setCat("Overweight");
    else                           setCat("Obese");
  }

  function reset() {
    setHeight("");
    setWeight("");
    setBmi(null);
    setCat("");
  }

  return (
    <SafeAreaView style={s.container}>
      <StatusBar barStyle="light-content" backgroundColor="#1A73E8" />
      <Text style={s.title}>⚖️ BMI Calculator</Text>

      <Text style={s.label}>Height (cm)</Text>
      <TextInput
        style={s.input}
        value={height}
        onChangeText={setHeight}
        keyboardType="numeric"
        placeholder="e.g. 170"
        placeholderTextColor="#999"
      />

      <Text style={s.label}>Weight (kg)</Text>
      <TextInput
        style={s.input}
        value={weight}
        onChangeText={setWeight}
        keyboardType="numeric"
        placeholder="e.g. 70"
        placeholderTextColor="#999"
      />

      <View style={s.btnRow}>
        <TouchableOpacity
          style={[s.btn, { backgroundColor: "#1A73E8" }]}
          onPress={calculate}
        >
          <Text style={s.btnTxt}>Calculate</Text>
        </TouchableOpacity>
        <TouchableOpacity
          style={[s.btn, { backgroundColor: "#757575" }]}
          onPress={reset}
        >
          <Text style={s.btnTxt}>Reset</Text>
        </TouchableOpacity>
      </View>

      {bmi && (
        <View style={s.result}>
          <Text style={s.bmiVal}>BMI: {bmi}</Text>
          <Text style={s.cat}>{category}</Text>
          <Text style={s.hint}>
            {"<18.5 Underweight | 18.5-24.9 Normal | 25-29.9 Overweight | ≥30 Obese"}
          </Text>
        </View>
      )}
    </SafeAreaView>
  );
}

const s = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#f0f4ff",
    padding: 24,
    justifyContent: "center",
  },
  title: {
    fontSize: 26,
    fontWeight: "bold",
    color: "#1A73E8",
    textAlign: "center",
    marginBottom: 24,
  },
  label: {
    fontSize: 15,
    fontWeight: "600",
    color: "#333",
    marginTop: 12,
    marginBottom: 4,
  },
  input: {
    backgroundColor: "#fff",
    borderRadius: 8,
    padding: 12,
    fontSize: 16,
    borderWidth: 1,
    borderColor: "#ccc",
    color: "#333",
  },
  btnRow: {
    flexDirection: "row",
    gap: 12,
    marginTop: 24,
  },
  btn: {
    flex: 1,
    padding: 14,
    borderRadius: 8,
    alignItems: "center",
  },
  btnTxt: {
    color: "#fff",
    fontWeight: "bold",
    fontSize: 16,
  },
  result: {
    marginTop: 32,
    backgroundColor: "#fff",
    borderRadius: 12,
    padding: 20,
    alignItems: "center",
    elevation: 4,
  },
  bmiVal: {
    fontSize: 42,
    fontWeight: "bold",
    color: "#1A73E8",
  },
  cat: {
    fontSize: 20,
    fontWeight: "600",
    color: "#2E7D32",
    marginTop: 4,
  },
  hint: {
    fontSize: 11,
    color: "#888",
    marginTop: 12,
    textAlign: "center",
  },
});
