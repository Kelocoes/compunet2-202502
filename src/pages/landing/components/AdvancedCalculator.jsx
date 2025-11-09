import { useState } from "react";
import { Card, CardContent, Typography, Button, Box, TextField, Paper, Grid } from "@mui/material";
import FunctionsIcon from "@mui/icons-material/Functions";
import AddIcon from "@mui/icons-material/Add";
import RemoveIcon from "@mui/icons-material/Remove";
import CloseIcon from "@mui/icons-material/Close";

function AdvancedCalculator() {
    const [input1, setInput1] = useState(0);
    const [input2, setInput2] = useState(0);
    const [result, setResult] = useState(0);

    return (
        <Card sx={{ maxWidth: 700, mx: "auto", mb: 3 }}>
            <CardContent>
                <Box sx={{ display: "flex", alignItems: "center", gap: 1, mb: 2 }}>
                    <FunctionsIcon color="primary" />
                    <Typography variant="h5" component="h2" color="primary">
                        Calculadora Avanzada
                    </Typography>
                </Box>
                <Typography variant="body2" color="text.secondary" paragraph>
                    Realiza operaciones entre dos números
                </Typography>

                <Grid container spacing={2} sx={{ mt: 2 }}>
                    <Grid item xs={12} sm={6}>
                        <TextField fullWidth type="number" label="Número 1" variant="outlined" value={input1} onChange={(e) => setInput1(Number(e.target.value))} />
                    </Grid>
                    <Grid item xs={12} sm={6}>
                        <TextField fullWidth type="number" label="Número 2" variant="outlined" value={input2} onChange={(e) => setInput2(Number(e.target.value))} />
                    </Grid>
                </Grid>

                <Paper
                    elevation={2}
                    sx={{
                        p: 3,
                        my: 3,
                        textAlign: "center",
                        bgcolor: "primary.light",
                        color: "white",
                    }}
                >
                    <Typography variant="h4" fontWeight="bold">
                        Resultado: {result}
                    </Typography>
                </Paper>

                <Grid container spacing={1}>
                    <Grid item xs={6} sm={3}>
                        <Button fullWidth variant="contained" color="success" startIcon={<AddIcon />} onClick={() => setResult(input1 + input2)}>
                            Sumar
                        </Button>
                    </Grid>
                    <Grid item xs={6} sm={3}>
                        <Button fullWidth variant="contained" color="error" startIcon={<RemoveIcon />} onClick={() => setResult(input1 - input2)}>
                            Restar
                        </Button>
                    </Grid>
                    <Grid item xs={6} sm={3}>
                        <Button fullWidth variant="contained" color="info" startIcon={<CloseIcon />} onClick={() => setResult(input1 * input2)}>
                            Multiplicar
                        </Button>
                    </Grid>
                    <Grid item xs={6} sm={3}>
                        <Button fullWidth variant="contained" color="warning" onClick={() => setResult(input1 / input2)}>
                            Dividir
                        </Button>
                    </Grid>
                </Grid>
            </CardContent>
        </Card>
    );
}

export default AdvancedCalculator;
