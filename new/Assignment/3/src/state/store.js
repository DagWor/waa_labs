import { combineReducers, createStore } from "redux";
import { calculatorReducer } from "./calculator-reducer";
import { taskReducer } from "./task-reducer";

const rootReducer = combineReducers({ task: taskReducer, calculator: calculatorReducer });
export const store = createStore(rootReducer)