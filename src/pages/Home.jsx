import { useEffect, useState } from "react";
import { Box } from "@mui/material";

import Card from "../components/Card";
import { getAllProducts } from "../services/productServices";

export default function Home() {
    const [counter, setCounter] = useState(0);
    const [products, setProducts] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            const products = await getAllProducts();
            setProducts(products);
        };

        fetchData();
    }, []); // onMount

    return (
        <div>
            <h1>Mi pagina principal!</h1>
            <p>{counter}</p>
            <button onClick={() => setCounter((prev) => prev + 1)}>Aumentar!</button>
            <Box sx={{ display: "flex", flexWrap: "wrap", gap: 10 }}>
                {products.map((product) => (
                    <Card key={product.id} title={product.title} content={product.description} imageUrl={product.image} />
                ))}
            </Box>
        </div>
    );
}
