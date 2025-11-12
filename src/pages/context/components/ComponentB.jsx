import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import Typography from "@mui/material/Typography";
import Box from "@mui/material/Box";

import ComponentC from "./ComponentC";

export default function ComponentB({ myState, setMyState }) {
    console.info("Rendering Component B");

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
                    Component B
                </Typography>
                <Typography variant="body1" sx={{ mb: 1 }}>
                    Estado actual: <strong>{myState}</strong>
                </Typography>
                <Typography variant="body2" color="text.secondary" paragraph>
                    Descripción breve de Component B.
                </Typography>

                <Box sx={{ mt: 2 }}>
                    <ComponentC myState={myState} setMyState={setMyState} />
                </Box>
            </CardContent>
        </Card>
    );
}
