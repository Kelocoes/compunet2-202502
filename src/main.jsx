import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./index.css";
import { RouterProvider } from "react-router";
import { StyledEngineProvider } from "@mui/material";

import router from "./router/Router";

createRoot(document.getElementById("root")).render(
    <StrictMode>
        <StyledEngineProvider injectFirst>
            <RouterProvider router={router} />
        </StyledEngineProvider>
    </StrictMode>
);
