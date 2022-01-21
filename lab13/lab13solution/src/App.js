import './App.css';
import { Calculator } from './components/Calculator';
import { TodoList } from './components/TodoList';
import { AddTask } from './components/AddTask';
import { TodoListCalculator } from './components/TodoListCalculator';

function App() {
  return (
    <div>
      <table>
        <tbody>
          <tr>
            <td><Calculator /></td>
            <td><AddTask /></td>
            </tr><tr>
            <td><TodoList /></td>
            <td><TodoListCalculator /></td>
          </tr>
        </tbody>
      </table>
    </div>
  );
}

export default App;
