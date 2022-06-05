import React from "react";
import Toolbar from "@mui/material/Toolbar";
import Button from "@mui/material/Button";
import Typography from "@mui/material/Typography";
import IconButton from "@mui/material/IconButton";
import Link from "@mui/material/Link";

const sections = [
  { title: "Category1", url: "#" },
  { title: "Category2", url: "#" },
  { title: "Category3", url: "#" },
  { title: "Category4", url: "#" },
  { title: "Category5", url: "#" },
  { title: "Category6", url: "#" },
  { title: "Category7", url: "#" },
  { title: "Category8", url: "#" },
  { title: "Category9", url: "#" },
];

function Header(props) {
  return (
    <React.Fragment>
      <Toolbar sx={{ borderBottom: 1, borderColor: "divider" }}>
        <Button size="small">Subscribe</Button>

        <Typography
          component="h2"
          variant="h5"
          color="inherit"
          align="center"
          noWrap
          sx={{ flex: 1 }}
        >
          Shop
        </Typography>

        <IconButton></IconButton>
        <Button variant="outlined" size="small">
          Sign up
        </Button>
        <Button variant="outlined" size="small">
          <Link href="/admin">Admin</Link>
        </Button>
      </Toolbar>
      <Toolbar
        component="nav"
        variant="dense"
        sx={{ justifyContent: "space-between", overflowX: "auto" }}
      >
        {sections.map((section) => (
          <Link
            color="inherit"
            noWrap
            key={section.title}
            variant="body2"
            href={section.url}
            sx={{ p: 1, flexShrink: 0 }}
          >
            {section.title}
          </Link>
        ))}
      </Toolbar>
    </React.Fragment>
  );
}

export default Header;
