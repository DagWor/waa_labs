import { useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";

export function Part3() {
    const navigate = useNavigate();
    const [creditCard, setCreditCard] = useState({
        number: "",
        type: ""
    })
    const { state } = useLocation();
    const handleSubmit = (e) => {
        e.preventDefault();
        navigate("/review", { state: { userInfo: state.userInfo, address: state.address, creditCard } })
    }

    return (
        <div className="margin-md">
            <h3> Basic Information </h3>
            <b> Full name </b> : {state.userInfo.firstName} {state.userInfo.lastName} <br />
            <b> Profession </b> : {state.userInfo.profession}
            <h3> Address </h3>
            {state.address.street} <br />
            {state.address.city}, {state.address.state}, {state.address.zipCode}
            <form onSubmit={e => handleSubmit(e)}>
                <h2>Credit Card Information</h2>
                <div className="form-field">
                    <label> CreditCard Number </label>
                    <input type="text" value={creditCard.number} onChange={e => setCreditCard({ ...creditCard, number: e.target.value })} required />
                </div>
                <div className="form-field">
                    <input type={"radio"} name="type" value={"Visa"} onChange={e => setCreditCard({ ...creditCard, type: e.target.value })} /> Visa
                    <input type={"radio"} name="type" value={"Mastercard"} onChange={e => setCreditCard({ ...creditCard, type: e.target.value })} /> Mastercard
                </div>
                <div className="form-field">
                    <button type="submit">  Review </button>
                </div>
            </form>
        </div>
    );
}