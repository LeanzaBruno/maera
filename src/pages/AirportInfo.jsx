import { useContext, useEffect, useState } from "react";
import { AirportsContext } from "../App";
import { Card, Container } from "react-bootstrap";


export default function AirportInfo(){
    const {selectedAirport} = useContext(AirportsContext);
    const [metar, setMetar] = useState('');
    const [taf, setTaf] = useState('');


    useEffect(
        () => {

        }
    ,[]);

    return (
        <Container>
            <Card className="col my-3">
                <Card.Header><h4>Info</h4></Card.Header>
                <Card.Body>
                    <h4>{selectedAirport.name}</h4>
                    <h4>{selectedAirport.icao}</h4>
                </Card.Body>
            </Card>

            <Card className="col my-3">
                <Card.Header>METAR</Card.Header>
                <Card.Body>
                    <p>
                        {metar}
                    </p>
                </Card.Body>
            </Card>

            <Card className="col my-3">
                <Card.Header>TAF</Card.Header>
                <Card.Body>
                    <p>
                        {taf}
                    </p>
                </Card.Body>
            </Card>
        </Container>
    );
}