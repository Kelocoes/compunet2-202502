import { Container, Typography, Box, Button, Alert, Snackbar } from "@mui/material";
import { useState } from "react";
import ScienceIcon from "@mui/icons-material/Science";
import ChildrenProps from "./components/ChildrenProps";
import PropsCard from "./components/PropsCard";
import SimpleComponent from "./components/SimpleComponent";
import PropsCommunication from "./components/PropsCommunication";

export default function PropsPage() {
    const [snackbarOpen, setSnackbarOpen] = useState(false);
    const [snackbarMessage, setSnackbarMessage] = useState("");

    const callbackFunction = (message) => {
        setSnackbarMessage(`Mensaje desde el componente hijo: ${message}`);
        setSnackbarOpen(true);
    };

    const handleCloseSnackbar = () => {
        setSnackbarOpen(false);
    };

    return (
        <Container maxWidth="lg" sx={{ py: 4 }}>
            <Box sx={{ textAlign: "center", mb: 5 }}>
                <Box sx={{ display: "flex", alignItems: "center", justifyContent: "center", gap: 2, mb: 2 }}>
                    <ScienceIcon sx={{ fontSize: 40 }} color="primary" />
                    <Typography variant="h3" component="h1" color="primary" fontWeight="bold">
                        Página de Props
                    </Typography>
                </Box>
                <Typography variant="h6" color="text.secondary">
                    Esta página será utilizada para hacer experimentos con props en React
                </Typography>
            </Box>

            <Box sx={{ display: "flex", flexDirection: "column", gap: 3 }}>
                <SimpleComponent name="Juan" age={30} />
                <PropsCard title="Primera Tarjeta" name="Tarjeta 1" description="Esta es la primera tarjeta" count={1} />
                <PropsCard title="Segunda Tarjeta" name="Tarjeta 2" description="Esta es la segunda tarjeta" count={2} extraInfo={{ info: "Información extra" }} />
                <PropsCommunication fn={callbackFunction} />
                <ChildrenProps>
                    <Alert severity="info" sx={{ mb: 2 }}>
                        Este es un contenido pasado como children al componente.
                    </Alert>
                    <Button variant="contained" color="success" fullWidth onClick={() => alert("Botón dentro de Children Props")}>
                        Haz clic aquí
                    </Button>
                </ChildrenProps>
            </Box>

            <Snackbar open={snackbarOpen} autoHideDuration={4000} onClose={handleCloseSnackbar} anchorOrigin={{ vertical: "bottom", horizontal: "center" }}>
                <Alert onClose={handleCloseSnackbar} severity="success" sx={{ width: "100%" }}>
                    {snackbarMessage}
                </Alert>
            </Snackbar>
        </Container>
    );
}
