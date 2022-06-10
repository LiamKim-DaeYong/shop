import React from "react";
import "./App.css";
import { Route, Routes } from "react-router-dom";
import BaseLayout from "./layouts/BaseLayout";
import { createTheme, ThemeProvider } from "@mui/material/styles";
import CssBaseline from "@mui/material/CssBaseline";

import Main from "./pages/Main";
import Home from "./pages/Home";
import About from "./pages/About";
import AdminLayout from "./layouts/admin/AdminLayout";
import Dashboard from "./pages/admin/Dashboard";
import Category from "./pages/admin/item/Category";
import UserList from "./pages/admin/user/UserList";

const theme = createTheme();

function App() {
  return (
    <ThemeProvider theme={theme}>
      <CssBaseline />
      <Routes>
        <Route element={<BaseLayout />}>
          <Route path="/" element={<Main />} />
          <Route path="/home" element={<Home />} />
          <Route path="/about" element={<About />} />
        </Route>
        <Route element={<AdminLayout />}>
          <Route path="/admin" element={<Dashboard />} />
          <Route path="/admin/item" element={<Category />} />
          <Route path="/admin/item/add" element={<Category />} />
          <Route path="/admin/item/category" element={<Category />} />
          <Route path="/admin/users" element={<UserList />} />
        </Route>
      </Routes>
    </ThemeProvider>
  );
}

export default App;
