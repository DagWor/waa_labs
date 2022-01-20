import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import { Part1 } from './pages/part-1';
import { Part2 } from './pages/part-2';
import { Part3 } from './pages/part-3';
import { Review } from './pages/review';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Part1 />} />
        <Route path="/part-2" element={<Part2 />} />
        <Route path="/part-3" element={<Part3 />} />
        <Route path="/review" element={<Review />} />
      </Routes>
    </BrowserRouter>
  );
}
export default App; 
