import { createStore } from 'redux';

const initalstate = { calcValue: 0, tasks: [] };

const counterReducer = (state = initalstate, action) => {
  if (action.type === 'add') {
    return {
      calcValue: state.calcValue + parseInt(action.amount),
      tasks: state.tasks
    };
  }
  if (action.type === 'subtract') {
    return {
      calcValue: state.calcValue - parseInt(action.amount),
      tasks: state.tasks
    };
  }
  if (action.type === 'multiply') {
    return {
      calcValue: state.calcValue * parseInt(action.amount),
      tasks: state.tasks
    };
  }
  if (action.type === 'addTask') {
    return {
      calcValue: state.calcValue,
      tasks: state.tasks.concat(action.task)
    };
  }
  return state;
}

const store = createStore(counterReducer);

export default store;