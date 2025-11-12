import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import Typography from "@mui/material/Typography";
import Box from "@mui/material/Box";
import Paper from "@mui/material/Paper";
import Divider from "@mui/material/Divider";
import CodeIcon from "@mui/icons-material/Code";

export default function PropsCard(props) {
    return (
        <Card sx={{ maxWidth: 700, mx: "auto", mb: 3 }}>
            <CardContent>
                <Box sx={{ display: "flex", alignItems: "center", gap: 1, mb: 2 }}>
                    <CodeIcon color="primary" />
                    <Typography variant="h5" component="h2" color="primary">
                        Componente de Props
                    </Typography>
                </Box>
                <Typography variant="body2" color="text.secondary" paragraph>
                    Este es un componente que recibe props y las muestra en pantalla
                </Typography>

                <Paper
                    elevation={0}
                    sx={{
                        p: 2,
                        bgcolor: "grey.100",
                        borderRadius: 1,
                        mb: 2,
                    }}
                >
                    <Typography variant="caption" color="text.secondary" sx={{ fontFamily: "monospace" }}>
                        {JSON.stringify(props, null, 2)}
                    </Typography>
                </Paper>

                <Divider sx={{ my: 2 }} />

                <Box sx={{ display: "flex", flexDirection: "column", gap: 1 }}>
                    {Object.keys(props).map((propKey) => (
                        <Paper key={propKey} elevation={1} sx={{ p: 1.5, display: "flex", gap: 1 }}>
                            <Typography variant="body2" fontWeight="bold" color="primary">
                                {propKey}:
                            </Typography>
                            <Typography variant="body2" color="text.secondary">
                                {String(props[propKey])}
                            </Typography>
                        </Paper>
                    ))}
                </Box>
            </CardContent>
        </Card>
    );
}
