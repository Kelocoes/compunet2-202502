import { createBrowserRouter } from "react-router";

import Landing from "../pages/landing/LandingPage";
import LoginPage from "../pages/Auth/LoginPage";
import RegisterPage from "../pages/Auth/RegisterPage";
import PropsPage from "../pages/props/PropsPage";
import FeedPage from "../pages/dashboard/feed/FeedPage";
import AuthLayout from "../layout/AuthLayout";

const router = createBrowserRouter(
    [
        { path: "/login", Component: LoginPage },
        { path: "/register", Component: RegisterPage },
        { path: "/props-page", Component: PropsPage },
        {
            path: "/dashboard",
            Component: AuthLayout,
            children: [
                { path: "feed", Component: FeedPage },
            ],
        },
        { path: "*", Component: Landing },
    ],
    { basename: "/compunet-2" }
);

export default router;
