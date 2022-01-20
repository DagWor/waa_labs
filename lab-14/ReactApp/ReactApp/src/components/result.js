import { useSearchParams} from "react-router-dom"

export function Result() {
    const [searchParams] = useSearchParams();
    return (
        <div className="container">
            <h2> Result  = <span name="result"> {searchParams.get("result")} </span> </h2>
        </div>
    )
}