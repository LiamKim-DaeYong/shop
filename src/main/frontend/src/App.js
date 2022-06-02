import React from "react";
import "./App.css";
import { Route, Routes } from "react-router-dom";
import BaseLayout from "./layouts/BaseLayout";
import Home from "./pages/Home";
import About from "./pages/About";

function App() {
  return (
    <Routes>
      <Route element={<BaseLayout />}>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<About />} />
      </Route>
    </Routes>
  );
}

export default App;
