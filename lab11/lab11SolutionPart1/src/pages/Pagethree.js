import React , { useState } from 'react';

export const Pagethree = (props) => {
  const [user, setUser] = useState(props.location.state.user);

  const handleOnSubmit = () => {
    props.history.push("/pagefour", {   user : user });
  }

  const handleFieldChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value})
 }
  let page3 = (
    <div>
      <div>First name: {user.firstname}</div>
      <div>Last name: {user.lastname}</div>
      <div>Profession: {user.profession}</div>
      <div>Street: {user.street}</div>
      <div>City: {user.city}</div>
      <div>Zip: {user.zip}</div>
      <div>State: {user.state}</div>

      <form>
        <h3>Please enter payment information</h3>
        <div>
          Creditcard number
           <input
            type="text"
            name="creditcard" 
            placeholder="Credit Card" 
            value={user.creditcard} 
            onChange={handleFieldChange} />
        </div>
        <div>
        Credit card type
                  <input
                     type="radio"
                     name="cardtype"
                     value="Visa"
                     checked={user.type === "Visa"}
                     onChange={handleFieldChange}
                  />Visa
                  <input
                     type="radio"
                     name="cardtype"
                     value="Mastercard"
                     checked={user.type === "Mastercard"}
                     onChange={handleFieldChange}
                  />Mastercard
        </div>
        <button onClick={handleOnSubmit}>Next</button>
      </form>
    </div>
  );
  return page3;
}