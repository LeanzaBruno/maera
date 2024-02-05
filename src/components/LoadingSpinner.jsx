import { Container, Spinner } from "react-bootstrap";


export default function LoadingSpinner(){
    return (
        <div className="text-center">
            <Spinner animation="border" variant='primary' role="status"/>
            <h4>Cargando aeropuertos...</h4>
        </div>

    );
}