import { Container, Typography, Box, Button as MuiButton } from "@mui/material";
import ScienceIcon from "@mui/icons-material/Science";
import AdvancedCalculator from "./components/AdvancedCalculator";
import Button from "./components/Button";
import Counter from "./components/Counter";
import SimpleCalculator from "./components/SimpleCalculator";

function LandingPage() {
    return (
        <Container maxWidth="lg" sx={{ py: 4 }}>
            <Box sx={{ height: "100vh" }}>
                <Box
                    sx={{
                        display: "flex",
                        flexDirection: "column",
                        alignItems: "center",
                        justifyContent: "center",
                        height: "100%",
                        textAlign: "center",
                        gap: 3,
                    }}
                >
                    <Typography variant="h2" component="h1" fontWeight="bold" color="primary">
                        Bienvenido a la Plataforma
                    </Typography>
                    <Typography variant="h5" color="text.secondary" sx={{ maxWidth: 600 }}>
                        Ingresa!
                    </Typography>
                    <Box sx={{ display: "flex", gap: 2, mt: 2 }}>
                        <MuiButton variant="contained" color="primary" size="large">
                            Iniciar Sesión
                        </MuiButton>
                        <MuiButton variant="outlined" color="primary" size="large">
                            Registrarse
                        </MuiButton>
                    </Box>
                </Box>
            </Box>
            <Box sx={{ textAlign: "center", mb: 5 }}>
                <Box sx={{ display: "flex", alignItems: "center", justifyContent: "center", gap: 2, mb: 2 }}>
                    <ScienceIcon sx={{ fontSize: 40 }} color="primary" />
                    <Typography variant="h3" component="h1" color="primary" fontWeight="bold">
                        Mi Página Principal
                    </Typography>
                </Box>
                <Typography variant="h6" color="text.secondary">
                    Esta página será utilizada para hacer experimentos de React
                </Typography>
            </Box>

            <Box sx={{ display: "flex", flexDirection: "column", gap: 3 }}>
                <Button />
                <Counter />
                <SimpleCalculator />
                <AdvancedCalculator />
            </Box>
        </Container>
    );
}

export default LandingPage;
