import { useRef } from "react";
import { Container, Box, Card, CardContent, Typography, TextField, Button, Link } from "@mui/material";
import LoginIcon from "@mui/icons-material/Login";

export default function LoginPage() {
    const formRef = useRef();

    const handleSubmit = (e) => {
        e.preventDefault();
        const formData = new FormData(formRef.current);
        const loginData = {
            username: formData.get("username"),
            password: formData.get("password"),
        };
        console.log("Login Data:", loginData);
    };

    return (
        <Container maxWidth="sm" sx={{ py: 8 }}>
            <Card elevation={3}>
                <CardContent sx={{ p: 4 }}>
                    <Box sx={{ display: "flex", flexDirection: "column", alignItems: "center", mb: 3 }}>
                        <Box
                            sx={{
                                bgcolor: "primary.main",
                                color: "white",
                                borderRadius: "50%",
                                p: 2,
                                mb: 2,
                            }}
                        >
                            <LoginIcon sx={{ fontSize: 40 }} />
                        </Box>
                        <Typography variant="h4" component="h1" fontWeight="bold" color="primary">
                            Iniciar Sesión
                        </Typography>
                        <Typography variant="body2" color="text.secondary" sx={{ mt: 1 }}>
                            Ingresa tus credenciales para continuar
                        </Typography>
                    </Box>

                    <Box component="form" ref={formRef} onSubmit={handleSubmit} sx={{ mt: 3, display: "flex", flexDirection: "column" }}>
                        <TextField name="username" fullWidth label="Usuario" placeholder="Ingresa tu usuario" variant="outlined" margin="normal" required autoFocus />
                        <TextField name="password" fullWidth label="Contraseña" type="password" placeholder="Ingresa tu contraseña" variant="outlined" margin="normal" required />

                        <Button type="submit" fullWidth variant="contained" size="large" startIcon={<LoginIcon />} sx={{ mt: 3, mb: 2, py: 1.5 }}>
                            Iniciar Sesión
                        </Button>

                        <Box sx={{ textAlign: "center", mt: 2 }}>
                            <Typography variant="body2" color="text.secondary">
                                ¿No tienes una cuenta?{" "}
                                <Link underline="hover" fontWeight="bold">
                                    Regístrate aquí
                                </Link>
                            </Typography>
                        </Box>
                    </Box>
                </CardContent>
            </Card>
        </Container>
    );
}
