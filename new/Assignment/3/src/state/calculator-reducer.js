
const initialState = {
    value: 0
};

export const calculatorReducer = (state = initialState,action)=>{
    switch(action.type){
        case "ADD":
            return {...state, value: parseFloat(state.value)+ parseFloat(action.amount)};
        case "SUBTRACT":
            return {...state, value: parseFloat(state.value) - parseFloat(action.amount)};
        case "MULTIPLY":
            return {...state, value: parseFloat(state.value) * parseFloat(action.amount)}
        case "DIVIDE":
            return {...state, value: parseFloat(state.value) / parseFloat(action.amount)}
        default:
            return {...state};
    }
}