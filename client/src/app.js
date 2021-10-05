import React from 'react';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { makeStyles } from '@mui/styles';
import CssBaseline from '@mui/material/CssBaseline';
import Container from '@mui/material/Container';
import Card from '@mui/material/Card';
import Home from './components/home.js';

const theme = createTheme({
    palette: {
        mode: 'light',
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
        background: {
            default: '#FFEBEE',
        }
    },
});

const useStyles = makeStyles({
    root: {
        paddingTop: '2rem',
    },
});

function App() {
    const classes = useStyles();
    return (
        <ThemeProvider theme={theme}>
            <CssBaseline />
            <div className={classes.root}>
                <Container>
                    <Card elevation={5}>
                        <Home />
                    </Card>
                </Container>
            </div>
        </ThemeProvider>
    );
}

export default App;
