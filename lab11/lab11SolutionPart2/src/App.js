import './App.css';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import { BookList, AddBook } from './pages';
import React, { useState } from 'react';

function App() {
  const [bookList, setBookList] = useState([]);

  return (
    <div>
      <Router>
        <Route
          exact path='/'
          render={(props) => (
            <BookList {...props} bookList={bookList} setBookList={setBookList} />
          )}
        />
        <Route
          path='/addbook'
          render={(props) => (
            <AddBook {...props} bookList={bookList} setBookList={setBookList} />
          )}
        />
      </Router>
    </div>
  );
}

export default App;
