import React from 'react';

export const Pagefour = (props) => {
  const [user, setUser] = useState(props.location.state.user);


  let page4 = (
    <div>
      <h3>Thank you for your order!</h3>
      <div>First name: {user.firstname}</div>
      <div>Last name: {user.lastname}</div>
      <div>Profession: {user.profession}</div>
      <div>Street: {user.street}</div>
      <div>City: {user.city}</div>
      <div>Zip: {user.zip}</div>
      <div>State: {user.state}</div>
      <div>Creditcard number: {user.creditcardnumber}</div>
      <div>Creditcard type: {user.type}</div>
    </div>
  );
  return page4;
}