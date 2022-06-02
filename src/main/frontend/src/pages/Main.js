import React from "react";
import Carousel from "react-material-ui-carousel";
import { Paper, Button } from "@mui/material";

function Main() {
  var items = [
    {
      name: "Random Name #1",
      description: "Probably the most random thing you have ever seen!",
    },
    {
      name: "Random Name #2",
      description: "Hello World!",
    },
  ];

  return (
    <div>
      <Carousel>
        {items.map((item, i) => (
          <Paper key={i}>
            <h2>{item.name}</h2>
            <p>{item.description}</p>

            <Button className="CheckButton">Check it out!</Button>
          </Paper>
        ))}
      </Carousel>
    </div>
  );
}

export default Main;
