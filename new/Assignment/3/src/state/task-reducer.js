
const initialState = {
    tasks: []
};

export const taskReducer = (state = initialState, action) => {
    switch (action.type) {
        case "ADD_TASK":
            return { ...state, tasks: state.tasks.concat(action.task) };
        case "DELETE_TASK":
            return { ...state, tasks: state.tasks.filter(t => t.number !== action.number) };
        default:
            return { ...state };
    }
}