import { Tasks } from "./tasks";
import {  Calculator } from "./calculator";


export function Container(){
    return(
        <div>
            <Calculator/>
            <hr/>
            <Tasks/>
        </div>
    )
}