import { useLocation } from "react-router-dom"
export function Review() {
    const { state } = useLocation();

    return (
        <div className="margin-md">
            <h3> Basic Information </h3>
            <b> Full name </b> : {state.userInfo.firstName} {state.userInfo.lastName} <br />
            <b> Profession </b> : {state.userInfo.profession}
            <h3> Address </h3>
            {state.address.street} <br />
            {state.address.city}, {state.address.state}, {state.address.zipCode}
            <h3> Credit Card Information </h3>
            <b> CC Number </b>{state.creditCard.number} <br />
            <b> Type </b>{state.creditCard.type}

        </div>
    )
}