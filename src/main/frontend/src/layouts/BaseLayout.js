import React from "react";
import Header from "./Header";
import { Outlet } from "react-router-dom";

function BaseLayout() {
  return (
    <div>
      <Header></Header>
      <main>
        <Outlet />
      </main>
    </div>
  );
}

export default BaseLayout;
