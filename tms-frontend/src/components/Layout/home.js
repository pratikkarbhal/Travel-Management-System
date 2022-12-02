import React from 'react';
import img from './bg.gif';
import Common from './Common';

const home = () => {
    return (
        <>
            <Common 
                name='Plan your next trip with' 
                imgsrc={img} 
                isCompName={true}
                compName="TMS"
                visit='/explore' 
                btnname="Get Started" 
            />
        </>
    )
}

export default home;