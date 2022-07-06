import React from "react";
import Button from "@mui/material/Button";
import { Box, Divider, Grid, Typography } from "@mui/material";
import { DataGrid } from "@mui/x-data-grid";

const columns = [
  { field: "id", headerName: "ID", width: 90 },
  {
    field: "firstName",
    headerName: "First name",
    width: 150,
    editable: true,
  },
  {
    field: "lastName",
    headerName: "Last name",
    width: 150,
    editable: true,
  },
  {
    field: "age",
    headerName: "Age",
    type: "number",
    width: 110,
    editable: true,
  },
];

const rows = [
  { id: 1, lastName: "Snow", firstName: "Jon", age: 35 },
  { id: 2, lastName: "Lannister", firstName: "Cersei", age: 42 },
  { id: 3, lastName: "Lannister", firstName: "Jaime", age: 45 },
  { id: 4, lastName: "Stark", firstName: "Arya", age: 16 },
  { id: 5, lastName: "Targaryen", firstName: "Daenerys", age: null },
  { id: 6, lastName: "Melisandre", firstName: null, age: 150 },
  { id: 7, lastName: "Clifford", firstName: "Ferrara", age: 44 },
  { id: 8, lastName: "Frances", firstName: "Rossini", age: 36 },
  { id: 9, lastName: "Roxie", firstName: "Harvey", age: 65 },
];

function Members() {
  return (
    <div>
      <Grid container>
        <Grid item xs={8}>
          <Typography variant="h5" noWrap>
            회원 리스트
          </Typography>
        </Grid>
        <Grid item xs={4}>
          <button>회원 등록</button>
        </Grid>
      </Grid>

      <Divider />

      <Typography variant="h6" noWrap>
        회원 리스트
      </Typography>

      <table>
        <tr>
          <th>검색어</th>
          <td>
            <select>
              <option>아이디</option>
              <option>이름</option>
            </select>

            <input />
          </td>
        </tr>

        <tr>
          <th>회원등급</th>
          <td></td>
          <th>회원구분</th>
          <td></td>
        </tr>
      </table>

      <Button variant="contained">검색</Button>

      <Divider />

      <Box sx={{ height: 400, width: "100%" }}>
        <DataGrid
          rows={rows}
          columns={columns}
          pageSize={5}
          rowsPerPageOptions={[5]}
          checkboxSelection
          disableSelectionOnClick
        />
      </Box>
    </div>
  );
}

export default Members;
