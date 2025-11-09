import { Card, CardContent, Typography, Chip, Box } from "@mui/material";

export default function UserCard({ user }) {
    return (
        <Card sx={{ maxWidth: 400, margin: 2, minWidth: 300 }}>
            <CardContent>
                <Box display="flex" justifyContent="space-between" alignItems="center" mb={2}>
                    <Typography variant="h5" component="h2">
                        {user.username}
                    </Typography>
                    <Chip label={user.role.name} color="primary" size="small" />
                </Box>

                <Typography color="text.secondary" gutterBottom>
                    {user.email}
                </Typography>

                <Typography variant="body2" sx={{ mt: 2 }}>
                    {user.bio}
                </Typography>

                <Typography variant="caption" color="text.secondary" sx={{ mt: 2, display: "block" }}>
                    Fecha de nacimiento: {new Date(user.birthdate).toLocaleDateString()}
                </Typography>

                <Typography variant="caption" color="text.secondary">
                    Miembro desde: {new Date(user.createdAt).toLocaleDateString()}
                </Typography>
            </CardContent>
        </Card>
    );
}
