import Button from "@mui/material/Button"
import { useState } from "react";
import CustomButton from "../components/CustomButton";

export default function SignIn() {
    console.log("Mi componente se esta renderizando!")
    const [counterState, setCounterState] = useState(0);
    const [user, setUser] = useState({});

    const handleClick = () => {
        console.log("Boton presionado!");
        setCounterState(prev => prev + 1)
        setCounterState(prev => prev + 1)
        setCounterState(prev => prev + 1)
        setCounterState(prev => prev + 1)
        setCounterState(prev => prev + 1)
        setCounterState(prev => prev + 1)
        setCounterState(prev => prev + 1)
        setUser({})
        
        console.log(counterState)
    }

    return (
        <div style={{
            backgroundColor: "white",
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
            flexDirection: "column",
            width: "100vw",
            height: "100vh"
        }}
            className=""
        >
            <form style={{ display: "flex", flexDirection: "column" }}>
                <input type="text" name="username" id="username" />
                <input type="password" name="password" id="password" />
            </form>
            <CustomButton text={"Iniciar sesion!"} color="blue" handleClick={() => console.log("Logueado!")}/>
            <CustomButton text={"Registrarse!"} color="red" handleClick={() => console.log("Registrado!")} />
            <p>{counterState}</p>
        </div>
    )
}