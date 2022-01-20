import React, { useState } from "react";
import axios from "axios";


export const Bank = (props) => {
  const cleanaccount = {
    accountNum: "",
    accountHolder: "",
    balance: 0,
    entryList: [],
  };
  const resultaccount = {
    accountNum: "",
    accountHolder: "",
    balance: 0,
    entryList: [],
  };
  const [operation, setOperation] = useState("create");
  const [account, setAccount] = useState(cleanaccount);
  const [result, setResult] = useState(resultaccount);

  const handleFieldChange = (e) => {
    setAccount({ ...account, [e.target.name]: e.target.value });
  };

  const fetchBackend = (e) => {
    if (e.target.value === "get") {
      axios
        .get("http://localhost:8080/accounts/" + account.accountNum)
        .then((response) => {
          resultaccount.accountHolder = response.data.accountHolder;
          resultaccount.balance = response.data.balance;
          resultaccount.accountNum = response.data.accountnumber;
          resultaccount.entryList = response.data.entryList;
          setResult(resultaccount);
        });
    } else if (e.target.value === "remove") {
      axios
        .delete("http://localhost:8080/accounts/" + account.accountNum)
        .then((response) => {
          resultaccount.accountHolder = "";
          resultaccount.balance = "";
          resultaccount.accountNum = "";
          resultaccount.entryList = [];
          setResult(resultaccount);
        });   
    } else if (e.target.value === "create") {
      const res = axios
        .post(
          "http://localhost:8080/accounts?accountNumber=" +
            account.accountNum +
            "&accountHolder='" +
            account.accountHolder +
            "'"
        )
        .then((response) => {
          resultaccount.accountHolder = response.data.accountHolder;
          resultaccount.balance = response.data.balance;
          resultaccount.accountNum = response.data.accountnumber;
          resultaccount.entryList = response.data.entryList;
          setResult(resultaccount);
        });
    } else if (e.target.value === "deposit" || e.target.value === "withdraw") {
      axios
        .post(
          "http://localhost:8080/accounts?accountNumber=" +
            account.accountNum +
            "&operation='" +
            operation +
            "'" +
            "&amount=" +
            account.balance
        )
        .then((response) => {
          resultaccount.accountHolder = response.data.accountHolder;
          resultaccount.balance = response.data.balance;
          resultaccount.accountNum = response.data.accountnumber;
          resultaccount.entryList = response.data.entryList;
          setResult(resultaccount);
        });
    }
    setAccount(cleanaccount);
    e.preventDefault();
  };

  return (
    <div>
      <form>
        <h3>MIU Bank</h3>
        <table>
          <tbody>
            <tr>
              <td>Account Number</td>
              <td>
                <input
                  type="text"
                  name="accountNum"
                  value={account.accountNum}
                  onChange={handleFieldChange}
                />
              </td>
            </tr>
            <tr>
              <td>Account Holder</td>
              <td>
                <input
                  type="text"
                  name="accountHolder"
                  value={account.accountHolder}
                  onChange={handleFieldChange}
                />
              </td>
            </tr>
            <tr>
              <td>Balance</td>
              <td>
                <input
                  type="text"
                  name="balance"
                  value={account.balance}
                  onChange={handleFieldChange}
                />
              </td>
            </tr>
            <tr>
              <td>Operation</td>
              <td>
                <select
                  type="text"
                  name="operation"
                  value={operation}
                  onChange={(e) => setOperation(e.target.value)}
                >
                  <option>create</option>
                  <option>deposit</option>
                  <option>withdraw</option>
                  <option>get</option>
                  <option>remove</option>
                </select>
              </td>
            </tr>
            <tr>
              <td></td>
              <td>
                <button value={operation} onClick={fetchBackend}>
                  Submit
                </button>
              </td>
            </tr>
            <tr>
              <td><strong>Account Number</strong></td>
              <td><strong>Account Holder</strong></td>
              <td><strong>Balance</strong></td>
            </tr>
            <tr>
              <td>{result.accountNum}</td>
              <td>{result.accountHolder}</td>
              <td>{result.balance}</td>
            </tr>
            <hr/>
            <tr>
              <td><strong>Date</strong></td>
              <td><strong>Amount</strong></td>
              <td><strong>Description</strong></td>
            </tr>
            {result.entryList.map((e) => (
              <tr>
                <td>{e.date}</td>
                <td>{e.amount}</td>
                <td>{e.description}</td>
              </tr>
            ))}
            <tr></tr>
          </tbody>
        </table>
      </form>
    </div>
  );
};
