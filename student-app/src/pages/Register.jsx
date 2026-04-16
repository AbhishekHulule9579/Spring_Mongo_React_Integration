import { useState } from "react";

function Register(){
    const [username,setUsername]=useState("");
    const [password,setPassword]=useState("");

    const handleRequest=async()=>{
        const response=await fetch("http://localhost:8080/auth/register",
            { method:"POST",
            headers: {
                "Content-Type":"application/json"
            },
            body: JSON.stringify({
                username:username,
                password:password
            })
        
    });

    const data=await response.text();
    alert(data);
};
return(
    <div>
        <h1>Register</h1>
        <input
        placeholder="UserName"
        onChange={(e) => setUsername(e.target.value)}
    />
    <br/>
    <input
        type="password"
        placeholder="Password"
        onChange={(e) => setPassword(e.target.value)}
    />
    <br/>

    <button onClick={handleRequest}>Register</button>
    </div>
);
}
export default Register;