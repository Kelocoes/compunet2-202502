import { Card, CardMedia } from "@mui/material";

export default function CustomCard({ title, content, imageUrl }) {
    return (
        <Card sx={{ maxWidth: 345 }}>
            <CardMedia component="img" height="194" image={imageUrl} alt={title} />
            <h2>{title}</h2>
            <p>{content}</p>
        </Card>
    );
}
