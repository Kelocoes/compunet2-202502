export default function CustomButton({ text, color, handleClick }) {
    const paddingSet = 4
    return (
        <button style={{ backgroundColor: color, padding: paddingSet, borderRadius: "20%" }}
            onClick={handleClick}
        >
            {text}
        </button>
    )
}