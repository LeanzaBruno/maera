import { useContext } from "react";
import { ListGroup } from "react-bootstrap";
import { AirportsContext } from "../App";
import { Link } from "react-router-dom";


export default function MatchItem({airport}){

    const {selectAirport} = useContext(AirportsContext);

    return(
        <ListGroup.Item action>
            <Link to="/info" onClick={ () => selectAirport(airport) }>
                    <h5>
                        {airport.name}
                    </h5>

                    <h5>{airport.icao}{airport.anac !== "" && "/" + airport.anac}</h5>
            </Link>
        </ListGroup.Item>
    );
}