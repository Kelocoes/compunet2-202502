import js from "@eslint/js";
import react from "eslint-plugin-react";
import reactHooks from "eslint-plugin-react-hooks";
import reactRefresh from "eslint-plugin-react-refresh";
import importPlugin from "eslint-plugin-import";
import globals from "globals";

export default [
    {
        ignores: ["dist", "build", "node_modules", "vite.config.js"],
    },
    js.configs.recommended,
    {
        files: ["**/*.{js,jsx,mjs,cjs,ts,tsx}"],
        plugins: {
            react,
            "react-hooks": reactHooks,
            "react-refresh": reactRefresh,
            import: importPlugin,
        },
        languageOptions: {
            ecmaVersion: 2020,
            globals: {
                ...globals.browser,
                ...globals.node,
            },
            parserOptions: {
                ecmaVersion: "latest",
                ecmaFeatures: { jsx: true },
                sourceType: "module",
            },
        },
        settings: {
            react: { version: "detect" },
            "import/resolver": {
                node: {
                    extensions: [".js", ".jsx", ".ts", ".tsx"],
                },
            },
        },
        rules: {
            ...react.configs.recommended.rules,
            ...reactHooks.configs.recommended.rules,
            "react/react-in-jsx-scope": "off",
            "react/prop-types": "off",
            "react-refresh/only-export-components": ["warn", { allowConstantExport: true }],
            "max-len": ["error", { code: 250 }],
            quotes: ["error", "double"],
            "no-unused-vars": [
                "error",
                {
                    vars: "all",
                    args: "all",
                    argsIgnorePattern: "^_",
                },
            ],
            "import/order": [
                "error",
                {
                    groups: ["builtin", "external", "internal", "parent", "sibling", "index"],
                    "newlines-between": "always",
                },
            ],
            indent: ["error", 4],
            "no-multiple-empty-lines": ["error", { max: 1, maxEOF: 1 }],
            "block-spacing": "error",
            semi: ["error", "always"],
            camelcase: "off",
            "no-console": ["error", { allow: ["info", "warn", "error"] }],
            "no-restricted-imports": [
                "error",
                {
                    patterns: [{ regex: "^@mui/[^/]+$" }],
                },
            ],
        },
    },
];
