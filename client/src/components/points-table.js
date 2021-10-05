import React, { useEffect } from 'react';
import { makeStyles } from '@mui/styles';
import Table from '@mui/material/Table';

const useStyles = makeStyles({
    root: {},
});

/**
 * Displays a table of points
 * @param {object} props React props object
 * @param {string} props.className Extra classes to apply to the table
 * @param {"global" | "single"} props.type Type of table
 */
function PointsTable(props) {
    const classes = useStyles();
    const rows = useEffect(null);

    useEffect(() => {
        if (props.type === 'global') {
            // Load global data
        }
        else {
            // Load single fam data
        }
    }, [props]);

    return <Table className={classes.root}>
        {rows}
    </Table>;
}

export default PointsTable;
