import React, { Component } from "react";
import {
  Box,
  Divider,
  Drawer,
  List,
  ListItem,
  ListItemButton,
  ListItemIcon,
  ListItemText,
  Toolbar,
} from "@mui/material";
import InboxIcon from "@mui/icons-material/MoveToInbox";
import MailIcon from "@mui/icons-material/Mail";
import { Link } from "react-router-dom";

const drawerWidth = 240;

const menus = [
  { name: "메인", link: "/admin" },
  { name: "상품", link: "/admin" },
  { name: "상품 목록", link: "/admin/item" },
  { name: "상품 등록", link: "/admin/item/add" },
  { name: "카테고리", link: "/admin/item/category" },
  { name: "주문/배송", link: "/admin" },
  { name: "회원", link: "/admin/users" },
  { name: "회원 목록", link: "/admin/users" },
  { name: "회원 등록", link: "/admin/users/add" },
];

function AdminDrawer() {
  return (
    <React.Fragment>
      <Drawer
        variant="permanent"
        sx={{
          width: drawerWidth,
          flexShrink: 0,
          [`& .MuiDrawer-paper`]: {
            width: drawerWidth,
            boxSizing: "border-box",
          },
        }}
      >
        <Toolbar />
        <Box sx={{ overflow: "auto" }}>
          <List>
            {menus.map((menu, index) => (
              <ListItem key={menu.name} disablePadding>
                <ListItemButton component={Link} to={menu.link}>
                  <ListItemIcon>
                    {index % 2 === 0 ? <InboxIcon /> : <MailIcon />}
                  </ListItemIcon>
                  <ListItemText primary={menu.name} />
                </ListItemButton>
              </ListItem>
            ))}
          </List>
          <Divider />
          <List>
            {["All mail", "Trash", "Spam"].map((text, index) => (
              <ListItem key={text} disablePadding>
                <ListItemButton>
                  <ListItemIcon>
                    {index % 2 === 0 ? <InboxIcon /> : <MailIcon />}
                  </ListItemIcon>
                  <ListItemText primary={text} />
                </ListItemButton>
              </ListItem>
            ))}
          </List>
        </Box>
      </Drawer>
    </React.Fragment>
  );
}

export default AdminDrawer;
