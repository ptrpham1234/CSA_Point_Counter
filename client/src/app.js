import React from 'react';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import CssBaseline from '@mui/material/CssBaseline';
import Home from './components/home.js';
import { makeStyles } from '@mui/styles';

const theme = createTheme({
    palette: {
        type: 'dark',
        primary: {
            main: '#C62828',
            light: '#D32F2F',
            dark: '#B71C1C',
        },
        secondary: {
            main: '#1565C0',
            light: '#1976D2',
            dark: '#0D47A1',
        },
    },
});

const useStyles = makeStyles({
    root: {
        backgroundColor: '#333',
        minHeight: '100%',
        height: '100%',
    },
});

function App() {
    const classes = useStyles();
    return (
        <ThemeProvider theme={theme}>
            <CssBaseline />
            <div className={classes.root}>
                <Home />
            </div>
        </ThemeProvider>
    );
}

export default App;
