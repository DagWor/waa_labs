import { useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";

export function Part2() {
    const navigate = useNavigate();
    const [address, setAddress] = useState({
        street: "",
        city: "",
        state: "",
        zipCode: ""
    })
    const { state } = useLocation();
    const handleSubmit = (e) => {
        e.preventDefault();
        navigate("/part-3", { state: { userInfo: state, address } });
    }
    return (
        <div className="margin-md">
            <h3> Basic Information </h3>
            <b> Full name </b> : {state.firstName} {state.lastName} <br />
            <b> Profession </b> : {state.profession}
            <form onSubmit={e => handleSubmit(e)}>
                <div className="form-field">
                    <label> Street </label>
                    <input type="text" value={address.street} onChange={e => setAddress({ ...address, street: e.target.value })} required />
                </div>
                <div className="form-field">
                    <label> City </label>
                    <input type="text" value={address.city} onChange={e => setAddress({ ...address, city: e.target.value })} required />
                </div>
                <div className="form-field">
                    <label> State </label>
                    <input type="text" value={address.state} onChange={e => setAddress({ ...address, state: e.target.value })} required />
                </div>
                <div className="form-field">
                    <label> Zipcode </label>
                    <input type="text" value={address.zipCode} onChange={e => setAddress({ ...address, zipCode: e.target.value })} required />
                </div>
                <div className="form-field">
                    <button type="submit"> Next </button>
                </div>
            </form>
        </div>
    )
}