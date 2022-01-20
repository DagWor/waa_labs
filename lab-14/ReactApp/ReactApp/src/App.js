import { BrowserRouter,Routes ,Route} from 'react-router-dom';
import './App.css';
import { Part3 } from './components/part-3';
import { Part4 } from './components/part-4';
import { Result } from './components/result';


export default function App(){
  return(
      <BrowserRouter>
      <Routes>
        <Route path="/" element={<Part3/>} />
        <Route path="/part-4" element={<Part4/>} />
        <Route path="/result" element={<Result/>} />
      </Routes>
    </BrowserRouter>
  )
}