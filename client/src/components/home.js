import React from 'react';
import { makeStyles } from '@mui/styles';
import Typography from '@mui/material/Typography';

const useStyles = makeStyles((theme) => ({
    root: {
        padding: '1rem 0',
    },
    title: {
        color: theme.palette.grey[800],
        textAlign: 'center',
    }
}));

function Home() {
    const classes = useStyles();
    return <div className={classes.root}>
        <Typography className={classes.title} variant="h3" component="h1">CSA Points Leaderboard</Typography>
        
    </div>;
}

export default Home;
