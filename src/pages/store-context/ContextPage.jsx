import { Container, Card, CardContent, Typography, Button, Box } from "@mui/material";
import AddIcon from "@mui/icons-material/Add";
import RemoveIcon from "@mui/icons-material/Remove";
import { useStore } from "@tanstack/react-store";

import { decrementByAmount, incrementByAmount, setMessage, store } from "../../store/store";

import ComponentA from "./components/ComponentA";

export default function StoreContextPage() {
    console.info("Rendering Context Page");
    const myState = useStore(store, (store) => store.myState);

    return (
        <Container maxWidth="lg" sx={{ py: 4 }}>
            <Box sx={{ display: "flex", justifyContent: "center", alignItems: "center", minHeight: "100vh" }}>
                <Card elevation={3} sx={{ maxWidth: 600, width: "100%", border: 1, borderColor: "grey.300" }}>
                    <CardContent sx={{ p: 3 }}>
                        <Typography variant="h4" component="h2" gutterBottom color="primary" fontWeight="bold">
                            Store Context Page
                        </Typography>
                        <Typography variant="body1" sx={{ mb: 2 }}>
                            Estado actual en Context Page: <strong>{myState}</strong>
                        </Typography>

                        <Button variant="outlined" color="secondary" onClick={() => setMessage("Nuevo mensaje desde Context Page")} sx={{ mb: 2 }}>
                            Actualizar Mensaje Global
                        </Button>

                        <Box sx={{ display: "flex", flexDirection: "column", gap: 2, mt: 3, maxWidth: 300 }}>
                            <Button variant="contained" color="primary" fullWidth startIcon={<AddIcon />} onClick={() => incrementByAmount(1)}>
                                Incrementar Estado
                            </Button>
                            <Button variant="contained" color="secondary" fullWidth startIcon={<RemoveIcon />} onClick={() => decrementByAmount(1)}>
                                Decrementar Estado
                            </Button>
                        </Box>

                        <Box sx={{ mt: 4 }}>
                            <ComponentA />
                        </Box>
                    </CardContent>
                </Card>
            </Box>
        </Container>
    );
}
