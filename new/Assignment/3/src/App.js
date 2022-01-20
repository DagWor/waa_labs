import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import { Container } from './pages/container';
import { AddTask } from './pages/add-task';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Container/>} />
        <Route path="/create" element={<AddTask/>} />
      </Routes>
    </BrowserRouter>
  );
}
export default App; 
