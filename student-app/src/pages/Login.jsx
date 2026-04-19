import { useState } from "react";

function Login(){
    const[username,setUsername]=useState("");
    const[password,setPassword]=useState("");

    const handleLogin=async()=>{
        const response=await fetch("http://localhost:8080/auth/login",{
            method:"POST",
            headers:{
                "Content-Type":"application/json"
            },
            body:JSON.stringify({
                username:username,
                password:password
            })
        });
        const data =await response.text();
        alert(data);
    };
    return (
        <div>
            <h2>Login Page</h2>
            <input
                placeholder="Username"
                value={username}
                onChange={(e)=>setUsername(e.target.value)}
            />
            <br/>

            <input
                type="password"
                placeholder="Password"
                value={password}
                onChange={(e)=>setPassword(e.target.value)}
            />

            <br/>
            <button onClick={handleLogin}>Login</button>
        </div>
    );
}
export default Login;