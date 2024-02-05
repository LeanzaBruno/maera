import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { createContext, useEffect, useState } from 'react';
import {API_AIRPORTS} from './api_variables';
import { Container, Spinner } from 'react-bootstrap';
import SearchPage from './pages/SearchPage';
import LoadingSpinner from './components/LoadingSpinner';

export const AirportsContext = createContext();

function App() {
  
    document.body.dataset.bsTheme = "dark";

    const [isLoading, setIsLoading] = useState(true);
    const [airports, setAirports] = useState(null);
    const [matches, setMatches] = useState([]);
    const [selectedAirport, selectAirport] = useState({});

	useEffect( () => {
                fetch(API_AIRPORTS) 
                .then( response => response.json() )
                .then( data => setAirports(data) )
                .finally( () => setIsLoading(false));
	}, [] );


    return (
        <Container className='main'>
            {
                isLoading ?
                <LoadingSpinner /> :
                <BrowserRouter>
                    <AirportsContext.Provider value={{airports, matches, setMatches, selectedAirport, selectAirport}}>
                        <Routes>
                            <Route path="/" element={<SearchPage />} />
                        </Routes>
                    </AirportsContext.Provider>
                </BrowserRouter>
            }
        </Container>
    );
}

export default App;
