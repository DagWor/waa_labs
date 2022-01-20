import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import { AddTask } from './pages/add-task';
import { Tasks } from './pages/tasks';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Tasks/>} />
        <Route path="/create" element={<AddTask/>} />
      </Routes>
    </BrowserRouter>
  );
}
export default App; 
