import { useSelector, useDispatch } from 'react-redux';
import { useState } from 'react';

export const TodoList = () => {
  const tasks = useSelector(state => state.tasks);
  
  return (
    <div>
      <h1>Todo list</h1>
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

