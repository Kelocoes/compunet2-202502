import { useState } from "react";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import Typography from "@mui/material/Typography";
import MuiButton from "@mui/material/Button";
import Box from "@mui/material/Box";
import Chip from "@mui/material/Chip";
import ToggleOnIcon from "@mui/icons-material/ToggleOn";
import ToggleOffIcon from "@mui/icons-material/ToggleOff";

function Button() {
    const [isUserActive, setIsUserActive] = useState(false);

    function changeState() {
        console.info("Estoy dandole click");
        setIsUserActive((prev) => !prev);
        console.info(isUserActive);
    }

    return (
        <Card sx={{ maxWidth: 600, mx: "auto", mb: 3 }}>
            <CardContent>
                <Typography variant="h5" component="h2" gutterBottom color="primary">
                    Estado del Usuario
                </Typography>
                <Typography variant="body2" color="text.secondary" paragraph>
                    Componente de estado con toggle interactivo
                </Typography>

                <Box sx={{ display: "flex", flexDirection: "column", alignItems: "center", gap: 2, mt: 3 }}>
                    <Chip icon={isUserActive ? <ToggleOnIcon /> : <ToggleOffIcon />} label={isUserActive ? "Usuario Activado" : "Usuario Desactivado"} color={isUserActive ? "success" : "error"} sx={{ fontSize: "1rem", py: 2.5, px: 1 }} />

                    <MuiButton variant="contained" color={isUserActive ? "error" : "success"} onClick={changeState} startIcon={isUserActive ? <ToggleOffIcon /> : <ToggleOnIcon />} sx={{ minWidth: 200 }}>
                        {isUserActive ? "Desactivar" : "Activar"}
                    </MuiButton>
                </Box>
            </CardContent>
        </Card>
    );
}

export default Button;
