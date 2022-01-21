import { useSelector, useDispatch } from 'react-redux';
import { useState } from 'react';

export const TodoListCalculator = () => {
  const tasks = useSelector(state => state.tasks);
  const value = useSelector(state => state.calcValue);

  return (
    <div>
      <h2>Calculator value: {value}</h2>
      <h2>Todo list</h2>
      <table>
        <tbody>
          {tasks.map(task=> (
            <tr key={task}>
              <td>{task}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

