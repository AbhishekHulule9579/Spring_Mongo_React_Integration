import { useEffect } from "react";
import { useNavigate } from "react-router-dom";

function Dashboard(){
    const navigate=useNavigate();
    useEffect(()=>{
        const token=sessionStorage.getItem("token");
        if(!token){
            alert("Please login first ");
            navigate("/login")
        }
    },[navigate]);
    const handleLogout=()=>{
        sessionStorage.removeItem("token");
        navigate("/login");
    };
    return(
        <div>
            <h2>Dashboard (Protected through JWT) </h2>
            <button onClick={handleLogout}>LogOut</button>
        </div>
    );
}
export default Dashboard;