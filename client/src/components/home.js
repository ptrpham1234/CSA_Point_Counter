import React from 'react';
import { makeStyles } from '@mui/styles';
import Typography from '@mui/material/Typography';

const useStyles = makeStyles((theme) => ({
    root: {
        paddingTop: '1rem',
    },
    title: {
        color: theme.palette.grey[100],
        textAlign: 'center',
    }
}));

function Home() {
    const classes = useStyles();
    return <div className={classes.root}>
        <Typography className={classes.title} variant="h1">CSA Points Leaderboard</Typography>
        
    </div>;
}

export default Home;
