import React, { useState } from 'react';

export const Pagetwo = (props) => {
  const [user, setUser] = useState(props.location.state.user);

  const handleOnSubmit = () => {
    props.history.push("/pagethree", {  user : user });
  }

  const handleFieldChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value})
 }

  let page2 = (
    <div>
      <div>First name: {user.firstname}</div>
      <div>Last name: {user.lastname}</div>
      <div>Profession: {user.profession}</div>
      <form>
        <h3>Please enter your address</h3>
        <div>
        Street
          <input
          type="text"
          name="street" 
          placeholder="Street" 
          value={user.street} 
          onChange={handleFieldChange}  />
      </div>
        <div>
        City
          <input
          type="text"
          name="city" 
          placeholder="City" 
          value={user.city} 
          onChange={handleFieldChange} />
      </div>
      <div>
        Zip
          <input
          type="text"
          name="zip" 
          placeholder="Zip" 
          value={user.zip} 
          onChange={handleFieldChange} />
      </div>
      <div>
        State
          <select
          name="state" 
          placeholder="State" 
          value={user.state} 
          onChange={handleFieldChange} >
          <option></option>
          <option>Iowa</option>
          <option>California</option>
          </select>
      </div>
        <button onClick={handleOnSubmit}>Next</button>
      </form>
    </div>
  );
  return page2;
}