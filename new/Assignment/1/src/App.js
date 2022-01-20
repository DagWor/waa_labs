import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import { Calculator } from './pages/calculator';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Calculator/>} />
      </Routes>
    </BrowserRouter>
  );
}
export default App; 
