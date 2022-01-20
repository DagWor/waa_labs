import React from 'react';

export const BookList = (props) => {
    const handleAddBook = () => {
        props.history.push("/addbook");
    }

    const removeBook = (e) => {
        const newBookList = props.bookList.filter((book) => book.isbn !== e.target.value);
        props.setBookList(newBookList);
    }

    return (<div>
        <h1>Books</h1>
        <table>
            <thead><tr><th>ISBN</th><th>Title</th><th>Author</th><th>Price</th>
            </tr></thead>
            <tbody>
                {props.bookList.map(book => (
                    <tr key={book.isbn}>
                        <td>{book.isbn}</td>
                        <td>{book.title}</td>
                        <td>{book.author}</td>
                        <td>{book.price}</td>
                        <td><button onClick={removeBook} value={book.isbn} >Remove</button></td
                        >
                    </tr>
                ))}
            </tbody>
        </table>
        <button onClick={handleAddBook}>Add Book</button>
    </div>);
}

export default BookList;