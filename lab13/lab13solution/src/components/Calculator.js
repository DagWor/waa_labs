import { useSelector, useDispatch } from 'react-redux';
import { useState } from 'react';

export const Calculator = () => {
  const dispatch = useDispatch();
  const value = useSelector(state => state.calcValue);
  const [amount, setAmount] = useState(0);
  
  const add = () => {
    dispatch({ type : 'add', amount : amount});
  }

  const subtract = () => {
    dispatch({ type : 'subtract', amount : amount});
  }

  const multiply = () => {
    dispatch({ type : 'multiply', amount : amount});
  }

  return (
    <div>
      <h1>Calculator</h1>
      <div>{value}</div>
      <div>
          Amount
          <input
            type="text"
            placeholder="Amount"
            name="amount"
            value={amount}
            onChange={e => setAmount(e.target.value)} />
        </div>
      <div>
        <button onClick={add}>+</button>
        <button onClick={subtract}>-</button>
        <button onClick={multiply}>*</button>
      </div>
    </div>
  );
};

