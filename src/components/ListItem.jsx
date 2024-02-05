import { Badge, CardHeader, Form, ListGroupItem } from "react-bootstrap";


export default function ListItem({airport}){

    return (
        <ListGroupItem action>
            <div>
                <div className="d-flex justify-content-between align-items-center">
                    <h4 className="icao">{airport.icao} { airport.anac && " - " + airport.anac }</h4>

                    {
                        airport.hasTAF ? <Badge bg="primary">METAR - TAF</Badge> : <Badge bg="secondary">METAR</Badge>
                    }
                </div>
                    
                <div className="text-start">
                    <h4>{airport.name}</h4>
                </div>
            </div>
        </ListGroupItem>
    );
}