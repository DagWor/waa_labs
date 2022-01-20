import { useState } from "react"
import { useNavigate } from "react-router-dom";


export function Part1(props) {
    const navigate = useNavigate();
    const [userInfo, setUserInfo] = useState({
        firstName: "",
        lastName: "",
        profession: ""
    });
    const handleSubmit = (e) => {
        e.preventDefault();
        navigate("/part-2", { state: userInfo });
    }
    return (
        <div className="margin-md">
            <form onSubmit={e => handleSubmit(e)}>
                <div className="form-field">
                    <label> First name </label>
                    <input type="text" value={userInfo.firstName} onChange={e => setUserInfo({ ...userInfo, firstName: e.target.value })} required />
                </div>
                <div className="form-field">
                    <label> Last name </label>
                    <input type="text" value={userInfo.lastName} onChange={e => setUserInfo({ ...userInfo, lastName: e.target.value })} required />
                </div>
                <div className="form-field">
                    <label> Profession </label>
                    <select value={userInfo.profession} onChange={e => setUserInfo({ ...userInfo, profession: e.target.value })} required>
                        <option value={""}> Select Profession </option>
                        <option value="Programmer"> Programmer </option>
                        <option value="Manager"> Manager </option>
                        <option value="Tester"> Tester </option>
                        <option value="Architect"> Architect </option>
                    </select>
                </div>
                <div className="form-field">
                    <button type="submit"> Next </button>
                </div>
            </form>
        </div>
    )
}