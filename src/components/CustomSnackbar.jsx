import { Snackbar } from "@mui/material";
import { useStore } from "@tanstack/react-store";

import { setMessage, store } from "../store/store";

export default function CustomSnackbar() {
    const message = useStore(store, (state) => state.message);
    const open = message !== "";

    return <Snackbar open={open} autoHideDuration={6000} message={message} onClose={() => setMessage("")} />;
}
