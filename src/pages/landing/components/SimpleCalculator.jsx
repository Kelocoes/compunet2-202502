import { useState } from "react";
import { Card, CardContent, Typography, Button, Box, Chip, ButtonGroup } from "@mui/material";
import CalculateIcon from "@mui/icons-material/Calculate";
import AddIcon from "@mui/icons-material/Add";
import RemoveIcon from "@mui/icons-material/Remove";
import CloseIcon from "@mui/icons-material/Close";
import RestartAltIcon from "@mui/icons-material/RestartAlt";

function SimpleCalculator() {
    const [value, setValue] = useState(0);

    return (
        <Card sx={{ maxWidth: 600, mx: "auto", mb: 3 }}>
            <CardContent>
                <Box sx={{ display: "flex", alignItems: "center", gap: 1, mb: 2 }}>
                    <CalculateIcon color="primary" />
                    <Typography variant="h5" component="h2" color="primary">
                        Calculadora Simple
                    </Typography>
                </Box>
                <Typography variant="body2" color="text.secondary" paragraph>
                    Realiza operaciones básicas con un solo valor
                </Typography>

                <Box sx={{ display: "flex", flexDirection: "column", alignItems: "center", gap: 3, mt: 3 }}>
                    <Chip label={`Valor: ${value.toFixed(2)}`} color="primary" sx={{ fontSize: "1.8rem", py: 4, px: 3, minWidth: 200 }} />

                    <Box sx={{ display: "flex", gap: 1, flexWrap: "wrap", justifyContent: "center" }}>
                        <ButtonGroup variant="contained" orientation="vertical">
                            <Button color="success" startIcon={<AddIcon />} onClick={() => setValue((prev) => prev + 1)}>
                                +1
                            </Button>
                            <Button color="error" startIcon={<RemoveIcon />} onClick={() => setValue((prev) => prev - 1)}>
                                -1
                            </Button>
                        </ButtonGroup>

                        <ButtonGroup variant="contained" orientation="vertical">
                            <Button color="info" startIcon={<CloseIcon />} onClick={() => setValue((prev) => prev * 2)}>
                                ×2
                            </Button>
                            <Button color="warning" onClick={() => setValue((prev) => prev / 3)}>
                                ÷3
                            </Button>
                        </ButtonGroup>
                    </Box>

                    <Button variant="outlined" color="secondary" startIcon={<RestartAltIcon />} onClick={() => setValue(0)} sx={{ minWidth: 150 }}>
                        Resetear
                    </Button>
                </Box>
            </CardContent>
        </Card>
    );
}

export default SimpleCalculator;
