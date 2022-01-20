import React, { useState } from 'react';

export const Pageone = (props) => {
  const [ user, setUser] = useState({
    firstname: '',
    lastname: '',
    profession: '',
    street: '',
    city: '',
    zip: '',
    state: '',
    creditcard: '',
    cardtype: ''
});

  const handleOnSubmit = () => {
    props.history.push("/pagetwo", { user : user });
  }

  const handleFieldChange = (e) => {
     setUser({ ...user, [e.target.name]: e.target.value})
  }

  let page1 = (
    <form>
      <h3>Please enter your personal information</h3>
      <div>
        Firstname
          <input
          type="text"
          placeholder="First name"
          name="firstname" 
          value={user.firstname} 
          onChange={handleFieldChange} />
      </div>
      <div>
        Lastname
          <input
          type="text"
          placeholder="Last name"
          name="lastname" 
          value={user.lastname} 
          onChange={handleFieldChange} />
      </div>
      <div>
        Profession
          <select
          name="profession" 
          value={user.profession} 
          onChange={handleFieldChange} >
          <option></option>
          <option>Programmer</option>
          <option>Manager</option>
          <option>Tester</option>
        </select>
      </div>
      <button onClick={handleOnSubmit}>Next</button>
    </form>
  );
  return page1;
}