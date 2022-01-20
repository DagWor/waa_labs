import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";

export function Tasks() {
    const navigate = useNavigate();
    const {tasks} = useSelector(t => t.task);
    const dispatch = useDispatch();
    const handleRemoveTask = (taskNumber) => {
        dispatch({ type: "DELETE_TASK", number: taskNumber });
    }
    return (
        <div className="margin-md">
            <h2> Tasks </h2>
            <div>
                <button onClick={() => navigate("/create")}>Add task </button>
            </div>
            {tasks.length === 0 ? <h4> No tasks</h4> :
                <table border="1">
                    <thead>
                        <tr>
                            <th>  No. </th>
                            <th>  Title </th>
                            <th>  Description </th>
                            <th>  Action </th>
                        </tr>
                    </thead>
                    <tbody>
                        {tasks && tasks.map((task) =>
                            <tr key={task.number}>
                                <td> {task.number}</td>
                                <td> {task.title}</td>
                                <td> {task.description.substring(0, 100)}</td>
                                <td>
                                    <button onClick={() => handleRemoveTask(task.number)} children="Remove task" />
                                </td>
                            </tr>
                        )}
                    </tbody>
                </table>
            }
        </div>
    )
}