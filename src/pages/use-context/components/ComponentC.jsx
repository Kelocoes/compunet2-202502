import { useContext, useState } from "react";
import { Card, CardContent, Typography, Button, Box } from "@mui/material";
import EditIcon from "@mui/icons-material/Edit";
import AddCircleIcon from "@mui/icons-material/AddCircle";
import RemoveCircleIcon from "@mui/icons-material/RemoveCircle";

import MyContext from "../../../context/myContext";

export default function ComponentC() {
    console.info("Rendering Component C");
    const [state, setState] = useState("Estado interno!");
    const { myState, setMyState } = useContext(MyContext);

    return (
        <Card
            elevation={2}
            sx={{
                maxWidth: "fit-content",
                border: 1,
                borderColor: "grey.300",
                bgcolor: "background.paper",
            }}
        >
            <CardContent>
                <Typography variant="h5" component="h2" gutterBottom color="primary" fontWeight="bold">
                    Component C
                </Typography>
                <Typography variant="body1" sx={{ mb: 1 }}>
                    Estado actual: <strong>{myState}</strong>
                </Typography>
                <Typography variant="body2" color="text.secondary" paragraph>
                    Descripción breve de Component C.
                </Typography>
                <Typography variant="body1" sx={{ mb: 2 }}>
                    Estado interno: <strong>{state}</strong>
                </Typography>

                <Box sx={{ display: "flex", flexDirection: "column", gap: 2, maxWidth: 300 }}>
                    <Button variant="contained" color="info" fullWidth startIcon={<EditIcon />} onClick={() => setState(state + "!")}>
                        Modificar Estado Interno
                    </Button>
                    <Button variant="contained" color="success" fullWidth startIcon={<AddCircleIcon />} onClick={() => setMyState(myState + 10)}>
                        Incrementar en 10
                    </Button>
                    <Button variant="contained" color="warning" fullWidth startIcon={<RemoveCircleIcon />} onClick={() => setMyState(myState - 10)}>
                        Decrementar en 10
                    </Button>
                </Box>
            </CardContent>
        </Card>
    );
}
