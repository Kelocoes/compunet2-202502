import { Store } from "@tanstack/react-store";

export const store = new Store({
    myState: 0,
    message: ""
});

export const incrementByAmount = (amount) => {
    store.setState((state) => {
        return {
            ...state,
            myState: state.myState + amount,
        };
    });
};

export const decrementByAmount = (amount) => {
    store.setState((state) => {
        return {
            ...state,
            myState: state.myState - amount,
        };
    });
};

export const setMessage = (newMessage) => {
    store.setState((state) => {
        return {
            ...state,
            message: newMessage,
        };
    });
};
