import { useState } from "react";
import { Card, CardContent, Typography, Button, Box, Chip } from "@mui/material";
import AddIcon from "@mui/icons-material/Add";
import RemoveIcon from "@mui/icons-material/Remove";
import RestartAltIcon from "@mui/icons-material/RestartAlt";

function Counter() {
    const [count, setCount] = useState(0);

    return (
        <Card sx={{ maxWidth: 600, mx: "auto", mb: 3 }}>
            <CardContent>
                <Typography variant="h5" component="h2" gutterBottom color="primary">
                    Contador
                </Typography>
                <Typography variant="body2" color="text.secondary" paragraph>
                    Contador simple con incremento y decremento
                </Typography>

                <Box sx={{ display: "flex", flexDirection: "column", alignItems: "center", gap: 2, mt: 3 }}>
                    <Chip label={`Valor actual: ${count}`} color="primary" sx={{ fontSize: "1.5rem", py: 3, px: 2, minWidth: 150 }} />

                    <Box sx={{ display: "flex", gap: 2, flexWrap: "wrap", justifyContent: "center" }}>
                        <Button variant="contained" color="success" startIcon={<AddIcon />} onClick={() => setCount((prev) => prev + 1)}>
                            Incrementar
                        </Button>
                        <Button variant="contained" color="error" startIcon={<RemoveIcon />} onClick={() => setCount((prev) => prev - 1)}>
                            Decrementar
                        </Button>
                        <Button variant="outlined" startIcon={<RestartAltIcon />} onClick={() => setCount(0)}>
                            Resetear
                        </Button>
                    </Box>
                </Box>
            </CardContent>
        </Card>
    );
}

export default Counter;
