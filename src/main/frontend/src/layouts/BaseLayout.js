import React from "react";
import Header from "./components/Header";
import { Outlet } from "react-router-dom";
import Container from "@mui/material/Container";

function BaseLayout() {
  return (
    <Container maxWidth="lg">
      <div>
        <Header></Header>

        <main>
          <Outlet />
        </main>
      </div>
    </Container>
  );
}

export default BaseLayout;
