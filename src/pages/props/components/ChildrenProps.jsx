import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import Typography from "@mui/material/Typography";
import Box from "@mui/material/Box";
import Paper from "@mui/material/Paper";
import ChildCareIcon from "@mui/icons-material/ChildCare";

export default function ChildrenProps({ children }) {
    return (
        <Card sx={{ maxWidth: 600, mx: "auto", mb: 3 }}>
            <CardContent>
                <Box sx={{ display: "flex", alignItems: "center", gap: 1, mb: 2 }}>
                    <ChildCareIcon color="primary" />
                    <Typography variant="h5" component="h2" color="primary">
                        Props Children
                    </Typography>
                </Box>
                <Typography variant="body2" color="text.secondary">
                    Este componente utiliza la prop especial children para renderizar contenido pasado desde su componente padre.
                </Typography>
                <Paper
                    elevation={2}
                    sx={{
                        p: 2,
                        mt: 2,
                        border: "2px dashed",
                        borderColor: "primary.light",
                        bgcolor: "background.default",
                    }}
                >
                    {children}
                </Paper>
            </CardContent>
        </Card>
    );
}
