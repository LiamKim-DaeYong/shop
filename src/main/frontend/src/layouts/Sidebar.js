import React from "react";
import { Drawer, List, ListItem, ListItemText } from "@mui/material";

function Sidebar(props) {
  return (
    <React.Fragment>
      <Drawer
        anchor="left"
        variant="permanent"
        open
        ModalProps={{
          keepMounted: true,
        }}
      >
        <List>
          <ListItem>
            <ListItemText>Menu1</ListItemText>
          </ListItem>
          <ListItem>
            <ListItemText>Menu2</ListItemText>
          </ListItem>
          <ListItem>
            <ListItemText>Menu3</ListItemText>
          </ListItem>
        </List>
      </Drawer>
    </React.Fragment>
  );
}

export default Sidebar;
