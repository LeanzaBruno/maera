import { faCancel, faClose, faCross, faSearch } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { useContext, useEffect, useState } from "react";
import { Button, CloseButton, Form, FormControl, InputGroup, ListGroup, ListGroupItem } from "react-bootstrap";
import { AirportsContext } from "../App";
import MatchItem from "../components/MatchItem";

export default function SearchPage(){
    const {airports, matches, setMatches} = useContext(AirportsContext);
    const [criteria, setCriteria] = useState('');

    function handleOnInput(e){
        setCriteria(e.target.value);
        
        let arr = [];
        for(let i = 0 ; i < airports.length ; ++i ){
            if(arr.length > 5)
                break;
            if( isAMatch( airports[i] ))
                arr.push( airports[i] );
        }

        setMatches( arr );
    }


    function handleClear(){
        setCriteria("");
        setMatches([]);
    }

    // TODO Buscar por ciudad también
    function isAMatch(airport){
        return (
            airport.name.toUpperCase().includes( criteria.toUpperCase() ) ||
            airport.icao.includes( criteria.toUpperCase() ) ||
            airport.anac.includes( criteria.toUpperCase() )
        );
    }


    // TODO Agregar iconos en el buscador 
    return (
        <div className="search">
            <form>
                <label htmlFor="search">
                    <FontAwesomeIcon icon={faSearch} />
                </label>
                <input type="text" id="search" value={criteria} onInput={ e => handleOnInput(e) } placeholder="Buscar aeropuerto..."/>

                {
                    criteria != "" && <CloseButton onClick={ () => handleClear() } />
                }
            </form>

            <ListGroup>
                {
                    matches.map( match => <MatchItem airport={match} key={match.icao}/>)
                }
            </ListGroup>
        </div>
    );
}