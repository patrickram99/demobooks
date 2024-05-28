import React, { useEffect, useState } from "react";
import { SERVER_URL } from "../constants.js";
import { DataGrid } from "@mui/x-data-grid";
import Snackbar from "@mui/material/Snackbar";

import AddBook from "./AddBook.js";
import EditBook from "./EditBook.js";

function CarList() {
    const [open, setOpen] = useState(false);

    const columns = [
        { field: "isbn", headerName: "ISBN", width: 200 },
        { field: "autor", headerName: "Autor", width: 200 },
        { field: "titulo", headerName: "Titulo", width: 200 },
        { field: "editorial", headerName: "Editorial", width: 150 },
        {
            field: "añoPublicacion",
            headerName: "Año de Publicacion",
            width: 150,
        },
        { field: "rating", headerName: "Rating", width: 150 },
        { field: "opinion", headerName: "Opinion", width: 400 },

        {
            field: "_links.book.href",
            headerName: "",
            sortable: false,
            filterable: false,
            renderCell: (row) => (
                <EditBook data={row} updateBook={updateBook} />
            ),
        },

        {
            field: "_links.self.href",
            headerName: "",
            sortable: false,
            filterable: false,
            renderCell: (row) => (
                <button onClick={() => onDelClick(row.id)}>Eliminar</button>
            ),
        },
    ];

    const [books, setBooks] = useState([]);

    useEffect(() => {
        fetchBooks();
    }, []);

    const onDelClick = (url) => {
        if (window.confirm("¿Esta seguro que desea borrar?")) {
            fetch(url, { method: "DELETE" })
                .then((response) => {
                    if (response.ok) {
                        fetchBooks();
                        setOpen(true);
                    } else {
                        alert("Something went wrsong!");
                    }
                })
                .catch((err) => console.error(err));
        }
    };

    const fetchBooks = () => {
        fetch(SERVER_URL + "api/books")
            .then((response) => response.json())
            .then((data) => setBooks(data._embedded.books))
            .catch((error) => console.log(error));
    };

    const addBook = (book) => {
        fetch(SERVER_URL + "api/books", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(book),
        })
            .then((response) => {
                if (response.ok) {
                    fetchBooks();
                } else {
                    alert("Hubo un error");
                }
            })
            .catch((err) => console.error(err));
    };

    const updateBook = (book, link) => {
        fetch(link, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(book),
        })
            .then((response) => {
                if (response.ok) {
                    fetchBooks();
                } else {
                    alert("Hubo un error :(");
                }
            })
            .catch((err) => console.error(err));
    };

    return (
        <React.Fragment>
            <AddBook addBook={addBook} />
            <div style={{ height: "100%", width: "100%" }}>
                <DataGrid
                    rows={books}
                    columns={columns}
                    disableSelectionOnClick={true}
                    getRowId={(row) => row._links.self.href}
                />

                <Snackbar
                    open={open}
                    autoHideDuration={2000}
                    onClose={() => setOpen(false)}
                    message="Libro eliminado"
                />
            </div>
        </React.Fragment>
    );
}

export default CarList;
