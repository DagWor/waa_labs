import React, { useState } from 'react';

export const TodoList = (props) => {

    const cleanTask = { name: "" };
    const [task, setTask] = useState(cleanTask);

    const [doneList, setDoneList] = useState([]);
    const [todoList, setTodoList] = useState([]);


    const doneTask = (e) => {
        const newTodoList = todoList.filter((t) => t.id !== e.target.value);
        const rem = todoList.find((t) => t.id === e.target.value);

        setTodoList(newTodoList);

        setDoneList([...doneList, rem]);
    }

    const undoneTask = (e) => {
        const newDoneList = doneList.filter((t) => t.id !== e.target.value);
        const rem = doneList.find((t) => t.id === e.target.value);
        setDoneList(newDoneList);

        setTodoList([...todoList, rem]);
    }

    const handleSubmit = (e) => {
        e.preventDefault();

        if (task.name) {
            const t = { id: '' + (todoList.length + doneList.length + 1), name: task.name };
            setTodoList([...todoList, t]);
        }

        setTask(cleanTask);
    }

    const handleFieldChange = (e) => {
        setTask({ ...task, [e.target.name]: e.target.value });
    }

    return (<div>
        <h2>Add a New Task</h2>
        <form onSubmit={handleSubmit}>
            <div>
                Task
                <input
                    type="text"
                    placeholder="Enter Task"
                    name="name"
                    value={task.name}
                    onChange={handleFieldChange} />
            </div>
            <div>
                <button type="submit" >Add to todo list</button>
            </div>
        </form>
        <br/><br/>
        <p2>Done list</p2>
        <table >
            <thead><tr ><th>Task</th></tr></thead>
            <tbody>
                {todoList.map(t => (
                    <tr key={t.id}>
                        <td>{t.name}</td>
                        <td><button 
                        onClick={doneTask} 
                        value={t.id} >Move to done</button></td>
                    </tr>
                ))}
            </tbody>
        </table>
        <br/><br/>
        <p2>Done list</p2>
        <table>
            <thead><tr><th>Task</th></tr></thead>
            <tbody>
                {doneList.map(t => (
                    <tr key={t.id}>
                        <td>{t.name}</td>
                        <td><button
                          onClick={undoneTask} 
                          value={t.id} >Move to todo</button></td>
                    </tr>
                ))}
            </tbody>
        </table>
    </div>);
}

export default TodoList;