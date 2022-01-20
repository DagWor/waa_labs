import { useState } from "react";
export function Part3() {
    const [input,setInput] = useState({
      firstNumber: 0,
      secondNumber: 0,
      result: 0
    });
  
    const handleOnChange = e=>{
      setInput({...input, [e.target.name]: e.target.value})
    }
    return (
      <div className='container'>
        <h2> Calculator</h2>
        <div className='form-field'>
          <label> Num #1 </label>
          <input type={"number"} name="firstNumber" value={input.firstNumber}  onChange={handleOnChange}/>
        </div>
        <div className='form-field'>
          <label> Num #2 </label>
          <input type={"number"} name="secondNumber" value={input.secondNumber}  onChange={handleOnChange}/>
        </div>
        <div className='form-field'>
          <button name='add' onClick={()=>setInput({...input,result: parseFloat(input.firstNumber) + parseFloat(input.secondNumber)})} children={"+"}/> &emsp;
          <button name='sub' onClick={()=>setInput({...input,result: parseFloat(input.firstNumber) - parseFloat(input.secondNumber)})} children={"-"}/> &emsp;
          <button name='mul' onClick={()=>setInput({...input,result: parseFloat(input.firstNumber) * parseFloat(input.secondNumber)})} children={"*"}/> &emsp;
          <button name='div' onClick={()=>setInput({...input,result: parseFloat(input.firstNumber) / parseFloat(input.secondNumber)})} children={"/"}/> &emsp;
        </div>
        {input.result !== 0 && 
        <div>
          <h4> Result =  <span id="result">{input.result}</span> </h4> 
        </div>
        }
      </div>
    );
  }