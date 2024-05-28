import React, { useState } from "react";
import Dialog from "@mui/material/Dialog";
import DialogActions from "@mui/material/DialogActions";
import DialogContent from "@mui/material/DialogContent";
import DialogTitle from "@mui/material/DialogTitle";
function EditBook(props) {
    const [open, setOpen] = useState(false);
    const [book, setBook] = useState({
        isbn: "",
        autor: "",
        titulo: "",
        editorial: "",
        opinion: "",
        añoPublicacion: "",
        rating: "",
    });

    const handleClickOpen = () => {
        setBook({
            isbn: props.data.row.isbn,
            autor: props.data.row.autor,
            titulo: props.data.row.titulo,
            editorial: props.data.row.editorial,
            opinion: props.data.row.opinion,
            añoPublicacion: props.data.row.añoPublicacion,
            rating: props.data.row.rating,
        })
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const handleChange = (event) => {
        setBook({ ...book, [event.target.name]: event.target.value });
    };

    const handleSave = () => {
        props.updateBook(book, props.data.id);
        handleClose();
    };
    return (
        <div>
            <button onClick={handleClickOpen}>Editar</button>
            <Dialog open={open} onClose={handleClose}>
                <DialogTitle>Edit car</DialogTitle>
                <DialogContent>
                    <input
                        placeholder="ISBN"
                        name="isbn"
                        value={book.isbn}
                        onChange={handleChange}
                    />
                    <br />
                    <input
                        placeholder="Autor"
                        name="autor"
                        value={book.autor}
                        onChange={handleChange}
                    />
                    <br />
                    <input
                        placeholder="Titulo"
                        name="titulo"
                        value={book.titulo}
                        onChange={handleChange}
                    />
                    <br />
                    <input
                        placeholder="Editorial"
                        name="editorial"
                        value={book.editorial}
                        onChange={handleChange}
                    />
                    <br />
                    <input
                        placeholder="Año Publicacion"
                        name="añoPublicacion"
                        value={book.añoPublicacion}
                        onChange={handleChange}
                    />
                    <br />
                    <input
                        placeholder="Rating"
                        name="rating"
                        value={book.rating}
                        onChange={handleChange}
                    />
                    <br />
                    <input
                        placeholder="Opinion"
                        name="opinion"
                        value={book.opinion}
                        onChange={handleChange}
                    />
                    <br />
                </DialogContent>
                <DialogActions>
                    <button onClick={handleClose}> Cancel</button>
                    <button onClick={handleSave}>Save</button>
                </DialogActions>
            </Dialog>
        </div>
    );
}
export default EditBook;
