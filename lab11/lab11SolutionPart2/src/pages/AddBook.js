import React, { useState } from 'react';

export const AddBook = (props) => {
    const cleanBook = { isbn: "", title: "", author: "", price: 0 };
    const [book, setBook] = useState(cleanBook);

    const handleFieldChange = (e) => {
        setBook({ ...book, [e.target.name]: e.target.value })
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        props.setBookList(props.bookList.concat(book));
        props.history.push("/");
    }

    let formpage = (
        <form onSubmit={handleSubmit}>
            <h3>Add a book</h3>

            <table>
                <tbody>
                    <tr>
                        <td>
                            ISBN
                        </td>
                        <td>
                            <input
                                name="isbn"
                                type="text"
                                placeholder="Enter ISBN"
                                value={book.isbn}
                                onChange={handleFieldChange} />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Title
                        </td>
                        <td>
                            <input
                                name="title"
                                type="text"
                                placeholder="Enter Title"
                                value={book.title}
                                onChange={handleFieldChange} />
                        </td>
                    </tr>

                    <tr>
                        <td>
                            Author
                        </td>
                        <td>
                            <input
                                name="author"
                                type="text"
                                placeholder="Enter Author"
                                value={book.author}
                                onChange={handleFieldChange} />
                        </td>
                    </tr>

                    <tr>
                        <td>
                            Price
                        </td>
                        <td>
                            <input
                                name="price"
                                type="text"
                                placeholder="Enter Price"
                                step="0.01"
                                value={book.price}
                                onChange={handleFieldChange} />
                        </td>
                    </tr>

                </tbody>

            </table>

            <button type="submit">Add Book</button>
        </form>
    );
    return formpage;
}

export default AddBook;