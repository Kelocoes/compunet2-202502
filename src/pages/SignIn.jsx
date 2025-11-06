export default function SignIn({ isSignIn }) {
    return <div>{isSignIn ? <h1>Sign in</h1> : <h1>Sign Up</h1>}</div>;
}
