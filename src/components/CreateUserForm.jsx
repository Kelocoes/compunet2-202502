import { useRef } from "react";
import { Dialog, DialogTitle, DialogContent, DialogActions, TextField, Button, Grid, Box, IconButton } from "@mui/material";
import CloseIcon from "@mui/icons-material/Close";
import PersonAddIcon from "@mui/icons-material/PersonAdd";

export default function CreateUserForm({ open, onClose, onSubmit }) {
    const formRef = useRef();

    const handleSubmit = (e) => {
        e.preventDefault();
        const formData = new FormData(formRef.current);
        const userData = {
            username: formData.get("username"),
            email: formData.get("email"),
            password: formData.get("password"),
            bio: formData.get("bio"),
            birthdate: formData.get("birthdate"),
            roleId: 2, // Valor por defecto
        };

        if (onSubmit) {
            onSubmit(userData);
        }

        // Limpiar formulario
        formRef.current.reset();
    };

    return (
        <Dialog open={open} onClose={onClose} maxWidth="sm" fullWidth>
            <DialogTitle>
                <Box sx={{ display: "flex", justifyContent: "space-between", alignItems: "center" }}>
                    Crear Nuevo Usuario
                    <IconButton onClick={onClose} size="small">
                        <CloseIcon />
                    </IconButton>
                </Box>
            </DialogTitle>

            <DialogContent>
                <Box component="form" ref={formRef} id="create-user-form" onSubmit={handleSubmit}>
                    <Grid container spacing={2} sx={{ mt: 1 }}>
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
                </Box>
            </DialogContent>

            <DialogActions sx={{ px: 3, pb: 2 }}>
                <Button onClick={onClose} variant="outlined">
                    Cancelar
                </Button>
                <Button type="submit" form="create-user-form" variant="contained" color="primary" startIcon={<PersonAddIcon />}>
                    Crear Usuario
                </Button>
            </DialogActions>
        </Dialog>
    );
}
