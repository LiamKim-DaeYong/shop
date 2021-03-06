import * as React from "react";
import Box from "@mui/material/Box";
import AppBar from "@mui/material/AppBar";
import CssBaseline from "@mui/material/CssBaseline";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import { Outlet } from "react-router-dom";
import Sidebar from "./components/Sidebar";
import AdminHeader from "./admin/AdminHeader";

const drawerWidth = 240;

export default function AdminLayout() {
  return (
    <Box sx={{ display: "flex" }}>
      <CssBaseline />

      <AdminHeader />
      <Sidebar />

      <Box component="main" sx={{ flexGrow: 1, p: 3 }}>
        <Toolbar />
        <Outlet />
      </Box>
    </Box>
  );
}
