import { Card, CardContent, Typography, Box, Chip } from "@mui/material";
import PersonIcon from "@mui/icons-material/Person";
import CakeIcon from "@mui/icons-material/Cake";

export default function SimpleComponent({ name, age }) {
    return (
        <Card sx={{ maxWidth: 600, mx: "auto", mb: 3 }}>
            <CardContent>
                <Typography variant="h5" component="h2" gutterBottom color="primary">
                    Componente Simple
                </Typography>
                <Typography variant="body2" color="text.secondary" paragraph>
                    Este es un componente React simple.
                </Typography>
                <Box sx={{ display: "flex", gap: 2, mt: 2, flexWrap: "wrap" }}>
                    <Chip icon={<PersonIcon />} label={`Nombre: ${name}`} color="primary" variant="outlined" />
                    <Chip icon={<CakeIcon />} label={`Edad: ${age}`} color="secondary" variant="outlined" />
                </Box>
            </CardContent>
        </Card>
    );
}
