import React from "react";
import Container from "@mui/material/Container";
import Sidebar from "./Sidebar";
import { Outlet } from "react-router-dom";

function AdminLayout() {
  return (
    <Container maxWidth="lg">
      <div>
        <Sidebar></Sidebar>

        <main>
          <Outlet />
        </main>
      </div>
    </Container>
  );
}

export default AdminLayout;
