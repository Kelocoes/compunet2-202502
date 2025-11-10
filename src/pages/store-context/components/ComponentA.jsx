import { Card, CardContent, Typography, Box } from "@mui/material";

import ComponentB from "./ComponentB";

export default function ComponentA({ myState, setMyState }) {
    console.info("Rendering Component A");

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
                    Component A
                </Typography>
                <Typography variant="body1" sx={{ mb: 1 }}>
                    Estado actual: <strong>{myState}</strong>
                </Typography>
                <Typography variant="body2" color="text.secondary" paragraph>
                    Descripción breve de Component A.
                </Typography>

                <Box sx={{ mt: 2 }}>
                    <ComponentB myState={myState} setMyState={setMyState} />
                </Box>
            </CardContent>
        </Card>
    );
}
