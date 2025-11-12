import { useState } from "react";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import Typography from "@mui/material/Typography";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import Box from "@mui/material/Box";
import SendIcon from "@mui/icons-material/Send";
import SwapVertIcon from "@mui/icons-material/SwapVert";

export default function PropsCommunication({ fn }) {
    const [input, setInput] = useState("");

    const handleSend = () => {
        if (input.trim()) {
            fn(input);
            setInput("");
        }
    };

    return (
        <Card sx={{ maxWidth: 600, mx: "auto", mb: 3 }}>
            <CardContent>
                <Box sx={{ display: "flex", alignItems: "center", gap: 1, mb: 2 }}>
                    <SwapVertIcon color="primary" />
                    <Typography variant="h5" component="h2" color="primary">
                        Comunicación entre componentes con Props
                    </Typography>
                </Box>
                <Typography variant="body2" color="text.secondary" paragraph>
                    Este componente busca usar funciones pasadas por el componente padre
                </Typography>
                <Box sx={{ display: "flex", gap: 2, alignItems: "flex-start" }}>
                    <TextField fullWidth variant="outlined" label="Escribe un mensaje" placeholder="Escribe tu nombre" value={input} onChange={(e) => setInput(e.target.value)} onKeyPress={(e) => e.key === "Enter" && handleSend()} />
                    <Button variant="contained" color="primary" endIcon={<SendIcon />} onClick={handleSend} disabled={!input.trim()} sx={{ whiteSpace: "nowrap" }}>
                        Enviar
                    </Button>
                </Box>
            </CardContent>
        </Card>
    );
}
