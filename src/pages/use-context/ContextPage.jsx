import { useState } from "react";
import Container from "@mui/material/Container";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";
import Box from "@mui/material/Box";
import AddIcon from "@mui/icons-material/Add";
import RemoveIcon from "@mui/icons-material/Remove";

import ComponentA from "./components/ComponentA";

export default function UseContextPage() {
    console.info("Rendering Context Page");
    const [myState, setMyState] = useState(0);

    return (
        <Container maxWidth="lg" sx={{ py: 4 }}>
            <Box sx={{ display: "flex", justifyContent: "center", alignItems: "center", minHeight: "100vh" }}>
                <Card elevation={3} sx={{ maxWidth: 600, width: "100%", border: 1, borderColor: "grey.300" }}>
                    <CardContent sx={{ p: 3 }}>
                        <Typography variant="h4" component="h2" gutterBottom color="primary" fontWeight="bold">
                            Use Context Page
                        </Typography>
                        <Typography variant="body1" sx={{ mb: 2 }}>
                            Estado actual en Context Page: <strong>{myState}</strong>
                        </Typography>

                        <Box sx={{ display: "flex", flexDirection: "column", gap: 2, mt: 3, maxWidth: 300 }}>
                            <Button variant="contained" color="primary" fullWidth startIcon={<AddIcon />} onClick={() => setMyState(myState + 1)}>
                                Incrementar Estado
                            </Button>
                            <Button variant="contained" color="secondary" fullWidth startIcon={<RemoveIcon />} onClick={() => setMyState(myState - 1)}>
                                Decrementar Estado
                            </Button>
                        </Box>

                        <Box sx={{ mt: 4 }}>
                            <ComponentA myState={myState} setMyState={setMyState} />
                        </Box>
                    </CardContent>
                </Card>
            </Box>
        </Container>
    );
}
