import React, { useState } from "react";
import axios from "axios";

export const BookList = () => {
  const cleanbook = { isbn: "", title: "", author: "", price: "" };
  const [book, setBook] = useState(cleanbook);
  const [bookList, setBookList] = useState([]);
  const [isbnError, setIsbnError] = useState({});
  const [titleError, setTitleError] = useState({});
  const [authorError, setAuthorError] = useState({});
  const [priceError, setPriceError] = useState({});

  const handleSubmit = (e) => {
    //prevent POST request
    e.preventDefault();
    const isValid = formValidation();
    console.log("handleSubmit");
    if (isValid) {
      console.log("call the server");
      addBook(book);
    }
    //clear user
    setBook(cleanbook);
    console.log("load books");
    loadBooks();
    console.log("load books done");
  };

  const loadBooks = () => {
    const books = axios.get("http://localhost:8080/books").then((response) => {
      console.log(response.data.books);
      setBookList(response.data.books);
    });
  };

  const addBook = (book) => {
    axios.post("http://localhost:8080/books", book).then((response) => {
      console.log("added book " + response.data.titleErr);
      loadBooks();
    }); //add user to the list
  };

  const removeBook = (e) => {
    let url = "http://localhost:8080/books/" + e.target.value;
    console.log("removing contact with url=" + url);
    axios.delete(url).then((response) => {
      console.log("removed contact " + response.headers);
      loadBooks();
    }); //remove user from the list
  };

  const formValidation = () => {
    const isbnErr = {};
    const titleErr = {};
    const authorErr = {};
    const priceErr = {};
    let isValid = true;
    if (book.isbn.trim().length < 2) {
      isbnErr.shortLen = "Isbn should be more than 2 character";
      isValid = false;
    }
    if (book.isbn.trim().length > 5) {
      isbnErr.longErr = "Isbn can't be greater than 5 character";
      isValid = false;
    }
    if (book.title.trim().length < 2) {
      titleErr.shortLen = "Title should be more than 2 character";
      isValid = false;
    }
    if (book.author.trim().length < 2) {
      authorErr.shortLen = "Author name should be more than 2 character";
      isValid = false;
    }
    if (book.price == 0) {
      priceErr.shortLen = "price can't be zero";
      isValid = false;
    }
    setIsbnError(isbnErr);
    setTitleError(titleErr);
    setAuthorError(authorErr);
    setPriceError(priceErr);
    return isValid;
  };
  const handleFieldChange = (e) => {
    setBook({ ...book, [e.target.name]: e.target.value });
  };
  return (
    <div>
      <h1>Book List</h1>
      <table>
        <thead>
          <tr>
            <th>Isnb</th>
            <th>Title</th>
            <th>Author</th>
            <th>Price</th>
          </tr>
        </thead>
        <tbody>
          {bookList.map((book) => (
            <tr key={book.isbn}>
              <td>{book.isbn}</td>
              <td>{book.title}</td>
              <td>{book.author}</td>
              <td>{book.price}</td>
              <td>
                <button onClick={removeBook} value={book.isbn}>
                  Remove
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <button onClick={loadBooks}>Load books</button>
      <h1> Book Register</h1>
      <form onSubmit={handleSubmit}>
        <div>
          Isbn
          <input
            type="text"
            name="isbn"
            value={book.isbn}
            onChange={handleFieldChange}
          />
          {Object.keys(isbnError).map((key) => {
            return <div style={{ color: "red" }}>{isbnError[key]}</div>;
          })}
        </div>
        <div>
          Title
          <input
            type="text"
            name="title"
            value={book.title}
            onChange={handleFieldChange}
          />
          {Object.keys(titleError).map((key) => {
            return <div style={{ color: "red" }}>{titleError[key]}</div>;
          })}
        </div>
        <div>
          Author
          <input
            type="text"
            name="author"
            value={book.author}
            onChange={handleFieldChange}
          />
          {Object.keys(authorError).map((key) => {
            return <div style={{ color: "red" }}>{authorError[key]}</div>;
          })}
        </div>
        <div>
          Price
          <input
            type="text"
            name="price"
            value={book.price}
            onChange={handleFieldChange}
          />
          {Object.keys(priceError).map((key) => {
            return <div style={{ color: "red" }}>{priceError[key]}</div>;
          })}
        </div>
        <button type="submit">Next</button>
      </form>
    </div>
  );
};
