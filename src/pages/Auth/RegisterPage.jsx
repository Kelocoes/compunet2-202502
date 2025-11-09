import { useRef } from "react";
import { Container, Box, Card, CardContent, Typography, TextField, Button, Link, Grid } from "@mui/material";
import PersonAddIcon from "@mui/icons-material/PersonAdd";

export default function RegisterPage() {
    const formRef = useRef();

    const handleSubmit = (e) => {
        e.preventDefault();
        const formData = new FormData(formRef.current);
        const registerData = {
            username: formData.get("username"),
            email: formData.get("email"),
            password: formData.get("password"),
            bio: formData.get("bio"),
            birthdate: formData.get("birthdate"),
            roleId: 2, // Valor por defecto
        };
        console.log("Register Data:", registerData);
    };

    return (
        <Container maxWidth="sm" sx={{ py: 6 }}>
            <Card elevation={3}>
                <CardContent sx={{ p: 4 }}>
                    <Box sx={{ display: "flex", flexDirection: "column", alignItems: "center", mb: 3 }}>
                        <Box
                            sx={{
                                bgcolor: "secondary.main",
                                color: "white",
                                borderRadius: "50%",
                                p: 2,
                                mb: 2,
                            }}
                        >
                            <PersonAddIcon sx={{ fontSize: 40 }} />
                        </Box>
                        <Typography variant="h4" component="h1" fontWeight="bold" color="secondary">
                            Crear Cuenta
                        </Typography>
                        <Typography variant="body2" color="text.secondary" sx={{ mt: 1 }}>
                            Completa el formulario para registrarte
                        </Typography>
                    </Box>

                    <Box component="form" ref={formRef} onSubmit={handleSubmit} sx={{ mt: 3 }}>
                        <Grid container spacing={2}>
                            <Grid size={{ xs: 12 }}>
                                <TextField name="username" fullWidth label="Usuario" placeholder="Elige un nombre de usuario" variant="outlined" required autoFocus />
                            </Grid>
                            <Grid size={{ xs: 12 }}>
                                <TextField name="email" fullWidth label="Correo Electrónico" type="email" placeholder="tu@email.com" variant="outlined" required />
                            </Grid>
                            <Grid size={{ xs: 12 }}>
                                <TextField name="password" fullWidth label="Contraseña" type="password" placeholder="Mínimo 8 caracteres" variant="outlined" required />
                            </Grid>
                            <Grid size={{ xs: 12 }}>
                                <TextField name="confirmPassword" fullWidth label="Confirmar Contraseña" type="password" placeholder="Repite tu contraseña" variant="outlined" required />
                            </Grid>
                            <Grid size={{ xs: 12 }}>
                                <TextField name="birthdate" fullWidth label="Fecha de Nacimiento" type="date" variant="outlined" required InputLabelProps={{ shrink: true }} />
                            </Grid>
                            <Grid size={{ xs: 12 }}>
                                <TextField name="bio" fullWidth label="Biografía (Opcional)" placeholder="Cuéntanos algo sobre ti" variant="outlined" multiline rows={3} />
                            </Grid>
                        </Grid>

                        <Button type="submit" fullWidth variant="contained" color="secondary" size="large" startIcon={<PersonAddIcon />} sx={{ mt: 3, mb: 2, py: 1.5 }}>
                            Registrarse
                        </Button>

                        <Box sx={{ textAlign: "center", mt: 2 }}>
                            <Typography variant="body2" color="text.secondary">
                                ¿Ya tienes una cuenta?{" "}
                                <Link underline="hover" fontWeight="bold">
                                    Inicia sesión aquí
                                </Link>
                            </Typography>
                        </Box>
                    </Box>
                </CardContent>
            </Card>
        </Container>
    );
}
