import { useState } from "react";
import { useDispatch, useSelector } from "react-redux"

export function Calculator(){
    const {value} = useSelector(s=>s.calculator);
    const [amount,setAmount]= useState(value);
    const dispatch = useDispatch();
    const handleOperation = (operation)=>{
        dispatch({type: operation, amount: amount})
    }
    return(
        <div className="width-400">
            <h1> Calculator </h1>
            <h2> {value}</h2>
             <input  type={"number"} value={amount}  className="no-border" onChange={e=>setAmount(e.target.value)}/> <br/>
             <button className="margin-sm" children="Add" onClick={()=>handleOperation("ADD")}/> 
             <button className="margin-sm" children="Subtract" onClick={()=>handleOperation("SUBTRACT")}/>
             <button className="margin-sm" children="Multiply" onClick={()=>handleOperation("MULTIPLY")}/>
             <button className="margin-sm" children="Divide" onClick={()=>handleOperation("DIVIDE")}/>
        </div>
    )
}