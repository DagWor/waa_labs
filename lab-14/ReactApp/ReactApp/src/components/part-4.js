import { useState } from "react";
import { useNavigate } from "react-router";
export function Part4() {
    const navigate = useNavigate();
    const [input, setInput] = useState({
        firstNumber: 0,
        secondNumber: 0,
        result: 0
    });
    const handleOperation = (e) => {
        switch (e.target.name) {
            case "add":
                setInput((input)=>{
                    input = { ...input, result: parseFloat(input.firstNumber) + parseFloat(input.secondNumber)}
                    navigate("/result?result=" + input.result);
                    return input;
                });
                break;
            case "sub":
                setInput((input)=>{
                    input = { ...input, result: parseFloat(input.firstNumber) - parseFloat(input.secondNumber)}
                    navigate("/result?result=" + input.result);
                    return input;
                });
                break;
            case "mul":
                setInput((input)=>{
                    input = { ...input, result: parseFloat(input.firstNumber) * parseFloat(input.secondNumber)}
                    navigate("/result?result=" + input.result);
                    return input;
                });
                break;
            case "div":
                setInput((input)=>{
                    input = { ...input, result: parseFloat(input.firstNumber) / parseFloat(input.secondNumber)}
                    navigate("/result?result=" + input.result);
                    return input;
                });
                break;
            default:
                    console.log("Invalid operation");
        }
    }
    const handleOnChange = e => {
        setInput({ ...input, [e.target.name]: e.target.value })
    }
    return (
        <div className='container'>
            <h2> Calculator</h2>
            <div className='form-field'>
                <label> Num #1 </label>
                <input type={"number"} name="firstNumber" value={input.firstNumber} onChange={handleOnChange} />
            </div>
            <div className='form-field'>
                <label> Num #2 </label>
                <input type={"number"} name="secondNumber" value={input.secondNumber} onChange={handleOnChange} />
            </div>
            <div className='form-field'>
                <button name='add' onClick={handleOperation} children={"+"} /> &emsp;
                <button name='sub' onClick={handleOperation} children={"-"} /> &emsp;
                <button name='mul' onClick={handleOperation} children={"*"} /> &emsp;
                <button name='div' onClick={handleOperation} children={"/"} /> &emsp;
            </div>
        </div>
    );
}