import { useState } from "react";
import { useDispatch } from "react-redux";
import {useNavigate} from "react-router-dom";

export function AddTask() {
    const [task, setTask] = useState({
        number: Math.round(Math.random(30000)*10000),
        title: "",
        description: ""
    });
    const navigate = useNavigate();
    const dispatch = useDispatch();
    const handleChange = (e) => {
        setTask({ ...task, [e.target.name]: e.target.value });
    }
    const handleSubmit = e => {
        e.preventDefault();
        dispatch({ type: "ADD_TASK", task: task });
        navigate('/')
    }
    return (
        <div className="margin-md">
            <h3> Create task</h3>
            <form onSubmit={handleSubmit}>
                <div className="margin-sm">
                    <label> Title </label> &emsp;&emsp;&emsp;
                    <input type="text" name="title" value={task.title} onChange={handleChange} />
                </div>
                <div className="margin-sm">
                    <label> Description </label>
                    <textarea type="text" name="description" value={task.description} rows={3}  onChange={handleChange}></textarea>
                </div>
                <div className="margin-sm">
                    <button type="submit"> Create</button>
                </div>
            </form>
        </div>
    )
}