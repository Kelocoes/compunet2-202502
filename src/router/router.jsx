import { createBrowserRouter } from "react-router";

import SignIn from "../pages/SignIn";
import Home from "../pages/Home";

const router = createBrowserRouter(
    [
        {
            path: "/",
            element: <Home />,
        },
        {
            path: "/sign-up",
            element: <SignIn isSignIn={false} />,
        },
        {
            path: "/sign-in",
            element: <SignIn isSignIn={true} />,
        },
    ],
    { basename: "/compu-2" }
);

export default router;
