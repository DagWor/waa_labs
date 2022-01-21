import { useSelector, useDispatch } from 'react-redux';
import { useState } from 'react';

export const AddTask = () => {
  const [task, setTask] = useState('');
  const dispatch = useDispatch();
  
  const addTask = () => {
    dispatch({ type : 'addTask', task : task });
  }

  return (
    <div>
      <h1>Add a task</h1>
      <div>
      <div>
          Task
          <input
            type="text"
            placeholder="Task"
            name="task"
            value={task}
            onChange={e => setTask(e.target.value)} />
        </div>
        <button onClick={addTask}>Add Task</button>
      </div>
    </div>
  );
};

